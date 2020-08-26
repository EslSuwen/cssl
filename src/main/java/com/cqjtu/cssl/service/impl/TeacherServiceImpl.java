package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.Arrange;
import com.cqjtu.cssl.entity.ArrangePeriod;
import com.cqjtu.cssl.entity.Curriculum;
import com.cqjtu.cssl.entity.Teacher;
import com.cqjtu.cssl.mapper.*;
import com.cqjtu.cssl.service.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

  private final RedisTemplate<String, Object> redisTemplate;
  private final ValueOperations<String, Object> redisOperations;
  private final ArrangeService arrangeService;
  private final ArrangePeriodService arrangePeriodService;
  private final CourseService courseService;

  @Autowired
  public TeacherServiceImpl(
      RedisTemplate<String, Object> redisTemplate,
      ValueOperations<String, Object> redisOperations,
      ArrangeService arrangeService,
      ArrangePeriodService arrangePeriodService,
      CourseService courseService) {
    this.redisTemplate = redisTemplate;
    this.redisOperations = redisOperations;
    this.arrangeService = arrangeService;
    this.arrangePeriodService = arrangePeriodService;
    this.courseService = courseService;
  }

  @Override
  public Boolean updatePassword(String tid, String oldPw, String newOld) {
    @NonNull
    Teacher teacher = getOne(new QueryWrapper<Teacher>().eq("tid", tid).eq("tpassword", oldPw));
    teacher.setTpassword(newOld);
    return updateById(teacher);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Curriculum> getCurriculum(String tid, String week) {
    String key = String.format("c_tid_%s_week_%s", tid, week);
    Boolean hasKey = redisTemplate.hasKey(key);
    List<Curriculum> curriculumList;
    if (hasKey != null && hasKey) {
      curriculumList = (List<Curriculum>) redisOperations.get(key);
      log.info("从缓存中获得数据-----------> " + key);
    } else {
      curriculumList = getCurriculumInfo(tid, week);
      log.info("查询数据库获得数据-----------> " + key);
      redisOperations.set(key, curriculumList, 1, TimeUnit.HOURS);
    }
    return curriculumList;
  }

  @Override
  public Teacher getTeacher(String tid) {
    String key = "teacher_" + tid;
    Boolean hasKey = redisTemplate.hasKey(key);
    Teacher teacher;
    if (hasKey != null && hasKey) {
      teacher = (Teacher) redisOperations.get(key);
      log.info("从缓存中获得数据-----------> " + key);
    } else {
      teacher = getById(tid);
      log.info("查询数据库获得数据-----------> " + key);
      teacher.setTpassword("");
      redisOperations.set(key, teacher, 5, TimeUnit.HOURS);
    }
    return teacher;
  }

  public List<Curriculum> getCurriculumInfo(String tid, String week) {
    List<Arrange> arrangeList = arrangeService.list(new QueryWrapper<Arrange>().eq("tid", tid));
    // new QueryWrapper<Arrange>().eq("tid", tid).eq("status", Audit.PASS));
    for (Arrange each : arrangeList) {
      each.setArrangePeriod(
          arrangePeriodService.list(
              new QueryWrapper<ArrangePeriod>().eq("aid", each.getAid()).eq("lab_week", week)));
    }
    List<Curriculum> curriculumList = new ArrayList<>();
    for (Arrange each : arrangeList) {
      String labClass = each.getLabClass();
      String cname = courseService.getById(each.getCourseId()).getCourseName();
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
