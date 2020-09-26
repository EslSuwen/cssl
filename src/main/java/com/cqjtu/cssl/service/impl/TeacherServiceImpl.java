package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.Arrange;
import com.cqjtu.cssl.entity.ArrangePeriod;
import com.cqjtu.cssl.entity.Curriculum;
import com.cqjtu.cssl.entity.Teacher;
import com.cqjtu.cssl.mapper.*;
import com.cqjtu.cssl.service.TeacherService;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 教师信息服务实现类
 *
 * @author Aplin suwen
 * @since 2020-02-27
 */
@Log4j2
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
    implements TeacherService {

  private final ExpProjectMapper expProjectMapper;
  private final ArrangeMapper arrangeMapper;
  private final ArrangePeriodMapper arrangePeriodMapper;
  private final CourseMapper courseMapper;

  @Autowired
  public TeacherServiceImpl(
      ExpProjectMapper expProjectMapper,
      ArrangeMapper arrangeMapper,
      ArrangePeriodMapper arrangePeriodMapper,
      CourseMapper courseMapper) {
    this.expProjectMapper = expProjectMapper;
    this.arrangeMapper = arrangeMapper;
    this.arrangePeriodMapper = arrangePeriodMapper;
    this.courseMapper = courseMapper;
  }

  @Override
  public boolean updatePassword(String tid, String oldPw, String newOld) {
    @NonNull
    Teacher teacher = getOne(new QueryWrapper<Teacher>().eq("tid", tid).eq("tpassword", oldPw));
    teacher.setTpassword(newOld);
    return updateById(teacher);
  }

  @Override
  public List<Curriculum> getCurriculum(String tid, String week) {

    List<Arrange> arrangeList =
        arrangeMapper.selectList(new QueryWrapper<Arrange>().eq("tid", tid));

    for (Arrange each : arrangeList) {
      each.setArrangePeriod(
          arrangePeriodMapper.selectList(
              new QueryWrapper<ArrangePeriod>().eq("aid", each.getAid()).eq("lab_week", week)));
      each.setLabClass(arrangeMapper.getClassNameByAid(each.getAid()));
    }
    List<Curriculum> curriculumList = new ArrayList<>();

    for (Arrange each : arrangeList) {
      String labClass = each.getLabClass();
      String cname = courseMapper.selectById(each.getCourseId()).getCourseName();
      String labId = each.getLabId();
      String campus = each.getCampus();
      for (ArrangePeriod eachPeriod : each.getArrangePeriod()) {
        Curriculum curriculum = new Curriculum();
        curriculum.setArrangePeriod(eachPeriod);
        curriculum.setCname(cname);
        curriculum.setLabClass(labClass);
        curriculum.setLabId(labId);
        curriculum.setCampus(campus);
        curriculumList.add(curriculum);
      }
    }

    return curriculumList;
  }
}
