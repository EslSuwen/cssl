package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.ExpProject;
import com.cqjtu.cssl.entity.Teach;
import com.cqjtu.cssl.mapper.ArrangeMapper;
import com.cqjtu.cssl.mapper.CourseMapper;
import com.cqjtu.cssl.mapper.TeachMapper;
import com.cqjtu.cssl.service.ArrangeService;
import com.cqjtu.cssl.service.CourseService;
import com.cqjtu.cssl.service.ExpProjectService;
import com.cqjtu.cssl.service.TeachService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 授课信息服务实现类
 *
 * @author Aplin suwen
 * @since 2020-02-27
 */
@Log4j2
@Service
public class TeachServiceImpl extends ServiceImpl<TeachMapper, Teach> implements TeachService {

  private final RedisTemplate<String, Object> redisTemplate;
  private final ValueOperations<String, Object> redisOperations;
  private final ExpProjectService expProjectService;
  private final TeachService teachService;
  private final CourseService courseService;
  private final ArrangeService arrangeService;

  @Autowired
  public TeachServiceImpl(
      RedisTemplate<String, Object> redisTemplate,
      ValueOperations<String, Object> redisOperations,
      ExpProjectService expProjectService,
      TeachService teachService,
      CourseService courseService,
      ArrangeService arrangeService) {
    this.redisTemplate = redisTemplate;
    this.redisOperations = redisOperations;
    this.expProjectService = expProjectService;
    this.teachService = teachService;
    this.courseService = courseService;
    this.arrangeService = arrangeService;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<String> findCourseByTeacher(String tid) {
    String key = "c_tid_" + tid;
    Boolean hasKey = redisTemplate.hasKey(key);
    List<String> courseNames;
    if (hasKey != null && hasKey) {
      courseNames = (List<String>) redisOperations.get(key);
      log.info("从缓存中获得数据-----------> " + key);
    } else {
      courseNames = new ArrayList<>();
      teachService
          .list(new QueryWrapper<Teach>().eq("tid", tid))
          .forEach(
              each -> courseNames.add(courseService.getById(each.getCourseId()).getCourseName()));
      log.info("查询数据库获得数据-----------> " + key);
      redisOperations.set(key, courseNames, 5, TimeUnit.HOURS);
    }
    return courseNames;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Teach> getCourseInfoByTid(String tid, String term) {
    String key = String.format("c_tid_%s_term_%s", tid, term);
    Boolean hasKey = redisTemplate.hasKey(key);
    List<Teach> teachList;
    if (hasKey != null && hasKey) {
      teachList = (List<Teach>) redisOperations.get(key);
    } else {
      teachList = getCourseInfoByTidInfo(tid, term);
      redisOperations.set(key, teachList, 5, TimeUnit.HOURS);
    }
    return teachList;
  }

  public List<Teach> getCourseInfoByTidInfo(String tid, String term) {

    List<Integer> courseIdList =
        expProjectService.getExpByTid(tid, term).stream()
            .map(ExpProject::getCourseId)
            .collect(Collectors.toList());

    return teachService.list(new QueryWrapper<Teach>().eq("tid", tid)).stream()
        .peek(
            each -> {
              each.setCourseName(courseService.getById(each.getCourseId()).getCourseName());
              each.setLabId(arrangeService.findLabByClsNo(each.getTid(), each.getCourseId()));
              if (each.getApplyLimit() == 0) {
                each.setStatus("审核中");
              } else {
                each.setStatus("审核通过");
              }
            })
        .filter(each -> !courseIdList.contains(each.getCourseId()))
        .collect(Collectors.toList());
  }
}
