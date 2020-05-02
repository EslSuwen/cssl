package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.*;
import com.cqjtu.cssl.mapper.*;
import com.cqjtu.cssl.service.TeacherService;
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
  public int updatePassword(String tid, String oldPw, String newOld) {
    Teacher teacher = getOne(new QueryWrapper<Teacher>().eq("tid", tid).eq("tpassword", oldPw));
    if (teacher != null) {
      teacher.setTpassword(newOld);
      return updateById(teacher) ? 1 : 0;
    }
    return -1;
  }

  @Override
  public List<Curriculum> getCurriculum(String tid, String week) {

    List<Arrange> arrangeList =
        arrangeMapper.selectList(new QueryWrapper<Arrange>().eq("tid", tid));

    for (Arrange each : arrangeList) {
      each.setArrangePeriod(
          arrangePeriodMapper.selectList(
              new QueryWrapper<ArrangePeriod>().eq("aid", each.getAid()).eq("lab_week", week)));
    }
    List<Curriculum> curriculumList = new ArrayList<>();

    for (Arrange each : arrangeList) {
      String labClass = each.getLabClass();
      String cname = courseMapper.selectById(each.getCourseId()).getCourseName();
      String labId =each.getLabId();
      String campus=each.getCampus();
      for (ArrangePeriod eachPeriod : each.getArrangePeriod()) {
        Curriculum curriculum =new Curriculum();
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
