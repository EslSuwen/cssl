package com.cqjtu.cssl.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.constant.Audit;
import com.cqjtu.cssl.constant.ReturnCode;
import com.cqjtu.cssl.dto.ArrangeAudit;
import com.cqjtu.cssl.dto.ResultDto;
import com.cqjtu.cssl.entity.Class;
import com.cqjtu.cssl.entity.*;
import com.cqjtu.cssl.mapper.ArrangeMapper;
import com.cqjtu.cssl.service.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 实验室安排服务实现类
 *
 * @author suwen
 * @since 2020-02-21
 */
@Log4j2
@Service
public class ArrangeServiceImpl extends ServiceImpl<ArrangeMapper, Arrange>
    implements ArrangeService {

  private final ArrangePeriodService arrangePeriodService;
  private final ExpProjectService expProjectService;
  private final LabInfoService labInfoService;
  private final TeacherService teacherService;
  private final CourseService courseService;

  @Autowired
  public ArrangeServiceImpl(
      ArrangePeriodService arrangePeriodService,
      ExpProjectService expProjectService,
      LabInfoService labInfoService,
      TeacherService teacherService,
      CourseService courseService) {
    this.arrangePeriodService = arrangePeriodService;
    this.expProjectService = expProjectService;
    this.labInfoService = labInfoService;
    this.teacherService = teacherService;
    this.courseService = courseService;
  }

  @Override
  public List<Arrange> findByTid(String tid) {
    List<Arrange> arrangeList = list(new QueryWrapper<Arrange>().eq("tid", tid));
    for (Arrange each : arrangeList) {
      each.setArrangePeriod(
          arrangePeriodService.list(new QueryWrapper<ArrangePeriod>().eq("aid", each.getAid())));
    }
    return arrangeList;
  }

  /*
    @Override
    public boolean auditArrange(Integer aid, Audit status) {
      Arrange arrange = new Arrange();
      arrange.setStatus(status);
      return update(arrange, new UpdateWrapper<Arrange>().eq("aid", aid));
    }
  */

  @Override
  public List<TeachingPlan> getTeachingPlanList() {
    List<TeachingPlan> teachingPlanList = baseMapper.getTeachingPlanList();
    // TODO 排课暂停使用
    for (TeachingPlan each : teachingPlanList) {
      each.setCoursePeriod(baseMapper.getCoursePeriodByProId(each.getProId()));
      each.setLabClass(baseMapper.getClassNameByProId(each.getProId()));
    }
    return teachingPlanList;
  }

  public List<ArrangeAudit> getAuditArrange() {

    return list(new QueryWrapper<Arrange>().eq("status", Audit.AUDITING)).stream()
        .map(
            each -> {
              each.setArrangePeriod(null);
              arrangePeriodService.getOne(
                  new QueryWrapper<ArrangePeriod>().last("LIMIT 1").eq("aid", each.getAid()));
              return ArrangeAudit.builder()
                  .aid(each.getAid())
                  .labId(each.getLabId())
                  .labName(labInfoService.getById(each.getLabId()).getLabName())
                  .campus(each.getCampus())
                  .labClass(each.getLabClass())
                  .courseName(courseService.getById(each.getCourseId()).getCourseName())
                  .tname(teacherService.getById(each.getTid()).getTname())
                  .expProname(each.getExpProname())
                  .labRemark(each.getLabRemark())
                  .arrangePeriod(
                      arrangePeriodService.getOne(
                          new QueryWrapper<ArrangePeriod>()
                              .last("LIMIT 1")
                              .eq("aid", each.getAid())))
                  .period(baseMapper.getCoursePeriodByProId(each.getCourseId()))
                  .build();
            })
        .collect(Collectors.toList());
  }

  @Override
  public boolean addArrange(Arrange arrange) {

    arrange.setCourseId(expProjectService.getById(arrange.getProId()).getCourseId());
    save(arrange);

    int aid =
        getOne(new QueryWrapper<Arrange>().last("LIMIT 1").eq("pro_id", arrange.getProId()))
            .getAid();

    // 更新项目卡片中实验室申请状态
    ExpProject expProject = new ExpProject();
    expProject.setProId(arrange.getProId());
    expProject.setLabStatus(Audit.PASS);
    expProjectService.updateById(expProject);

    return arrangePeriodService.saveBatch(
        arrange.getArrangePeriod().stream()
            .peek(each -> each.setAid(aid))
            .collect(Collectors.toList()));
  }

  @Override
  public List<Class> getClassByGrade(Integer grade) {
    return baseMapper.getClassByGrade(grade);
  }

  @Override
  public ResponseEntity<ResultDto> ifAddArrange(Arrange arrange) {

    List<ArrangePeriod> arrangePeriodList = new ArrayList<>();

    List<Class> classInfo = arrange.getLabClassInfo();
    classInfo.forEach(
        each -> arrangePeriodList.addAll(baseMapper.getArrangePeriodByClassId(each.getClassId())));
    log.info(arrangePeriodList);
    log.info(arrange.getArrangePeriod());
    Optional<ArrangePeriod> arrangePeriodOptional =
        arrangePeriodList.stream().filter(arrange.getArrangePeriod()::contains).findFirst();
    if (!arrangePeriodOptional.isPresent()) {
      return new ResponseEntity<>(
          ResultDto.builder()
              .success(addArrange(arrange))
              .message("课程时间安排增加没有冲突")
              .code(ReturnCode.RETURN_CODE_20001.getCode())
              .build(),
          HttpStatus.OK);
    }
    ArrangePeriod arrangePeriod = arrangePeriodOptional.get();
    List<Class> existClass = baseMapper.getClassByAid(arrangePeriod.getAid());
    log.info(existClass);
    log.info(classInfo);
    Class conflictClass =
        classInfo.stream().filter(existClass::contains).findFirst().orElse(new Class());
    log.info(conflictClass);
    return new ResponseEntity<>(
        ResultDto.builder()
            .success(false)
            .message(
                StrUtil.format(
                    "{} 班在第 {} 周，星期 {}，第 {} 节课程冲突！",
                    conflictClass.getClassName(),
                    arrangePeriod.getLabWeek(),
                    arrangePeriod.getLabDay(),
                    arrangePeriod.getLabSession()))
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .build(),
        HttpStatus.OK);
  }
}
