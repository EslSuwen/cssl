package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.constant.Audit;
import com.cqjtu.cssl.dto.ArrangeAudit;
import com.cqjtu.cssl.entity.*;
import com.cqjtu.cssl.mapper.ArrangeMapper;
import com.cqjtu.cssl.service.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 实验室安排服务实现类
 *
 * @author suwen
 * @since 2020-02-21
 */
@Service
@Log4j2
public class ArrangeServiceImpl extends ServiceImpl<ArrangeMapper, Arrange>
    implements ArrangeService {

  private final ArrangePeriodService arrangePeriodService;
  private final ExpProjectService expProjectService;
  private final LabInfoService labInfoService;
  private final TeacherService teacherService;
  private final CourseService courseService;
  private final RedisTemplate<String, Object> redisTemplate;
  private final ValueOperations<String, Object> redisOperations;

  @Autowired
  public ArrangeServiceImpl(
      ArrangePeriodService arrangePeriodService,
      ExpProjectService expProjectService,
      LabInfoService labInfoService,
      TeacherService teacherService,
      CourseService courseService,
      RedisTemplate<String, Object> redisTemplate,
      ValueOperations<String, Object> redisOperations) {
    this.arrangePeriodService = arrangePeriodService;
    this.expProjectService = expProjectService;
    this.labInfoService = labInfoService;
    this.teacherService = teacherService;
    this.courseService = courseService;
    this.redisTemplate = redisTemplate;
    this.redisOperations = redisOperations;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Arrange> findByTid(String tid) {
    String key = "arrange_tid_" + tid;
    Boolean hasKey = redisTemplate.hasKey(key);
    List<Arrange> arrangeList;
    if (hasKey != null && hasKey) {
      arrangeList = (List<Arrange>) redisOperations.get(key);
      log.info("从缓存中获得数据-----------> noticeList");
    } else {
      arrangeList =
          list(new QueryWrapper<Arrange>().eq("tid", tid)).stream()
              .peek(
                  each ->
                      each.setArrangePeriod(
                          arrangePeriodService.list(
                              new QueryWrapper<ArrangePeriod>().eq("aid", each.getAid()))))
              .collect(Collectors.toList());
      log.info("查询数据库获得数据-----------> noticeList");
      redisOperations.set(key, arrangeList, 5, TimeUnit.HOURS);
    }
    return arrangeList;
  }

  /* TODO 审核时间安排
    @Override
    public boolean auditArrange(Integer aid, Audit status) {
      Arrange arrange = new Arrange();
      arrange.setStatus(status);
      return update(arrange, new UpdateWrapper<Arrange>().eq("aid", aid));
    }
  */

  @Override
  @SuppressWarnings("unchecked")
  public List<TeachingPlan> getTeachingPlanList() {
    String key = "TeachingPlan";
    Boolean hasKey = redisTemplate.hasKey(key);
    List<TeachingPlan> teachingPlanList;
    if (hasKey != null && hasKey) {
      teachingPlanList = (List<TeachingPlan>) redisOperations.get(key);
      log.info("从缓存中获得数据-----------> noticeList");
    } else {
      teachingPlanList =
          baseMapper.getTeachingPlanList().stream()
              .peek(
                  each -> each.setCoursePeriod(baseMapper.getCoursePeriodByCid(each.getCourseId())))
              .collect(Collectors.toList());
      log.info("查询数据库获得数据-----------> noticeList");
      redisOperations.set(key, teachingPlanList, 5, TimeUnit.HOURS);
    }
    return teachingPlanList;
  }

  /** TODO 审核时间安排 */
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
                  .period(baseMapper.getCoursePeriodByCid(each.getCourseId()))
                  .build();
            })
        .collect(Collectors.toList());
  }

  @Override
  public Boolean addArrange(Arrange arrange) {

    // arrange.setStatus(Audit.AUDITING);
    arrange.setCourseId(expProjectService.getById(arrange.getProId()).getCourseId());
    save(arrange);

    int aid = getOne(new QueryWrapper<Arrange>().eq("pro_id", arrange.getProId())).getAid();

    // 更新项目卡片中实验室申请状态
    ExpProject expProject = new ExpProject();
    expProject.setLabStatus(Audit.AUDITING);
    expProjectService.update(
        expProject, new UpdateWrapper<ExpProject>().eq("pro_id", arrange.getProId()));

    boolean result =
        arrangePeriodService.saveBatch(
            arrange.getArrangePeriod().stream()
                .peek(each -> each.setAid(aid))
                .collect(Collectors.toList()));
    String key = "arrange_tid_" + arrange.getTid();
    Boolean hasKey = redisTemplate.hasKey(key);
    if (result && hasKey != null && hasKey) {
      redisTemplate.delete(key);
    }
    return result;
  }

  @Override
  public String findLabByClsNo(String tid, Integer courseNo) {
    return baseMapper.findLabByClsNo(tid, courseNo);
  }
}
