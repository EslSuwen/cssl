package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.Course;
import com.cqjtu.cssl.entity.ExpProject;
import com.cqjtu.cssl.entity.Teach;
import com.cqjtu.cssl.mapper.CourseMapper;
import com.cqjtu.cssl.mapper.TeachMapper;
import com.cqjtu.cssl.service.ExpProjectService;
import com.cqjtu.cssl.service.TeachService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
  private final CourseMapper courseMapper;
  private final ExpProjectService expProjectService;

  @Autowired
  public TeachServiceImpl(CourseMapper courseMapper, ExpProjectService expProjectService) {
    this.courseMapper = courseMapper;
    this.expProjectService = expProjectService;
  }

  @Override
  public List<Teach> getTeachByTid(String tid) {
    return baseMapper.selectAll(tid);
  }

  @Override
  public List<Teach> getCourseInfoByTid(String tid, String term) {

    List<Integer> courseIdList =
        expProjectService.getExpByTid(tid, term).stream()
            .map(ExpProject::getCourseId)
            .collect(Collectors.toList());

    return list(new QueryWrapper<Teach>().eq("tid", tid)).stream()
        .peek(
            each -> each.setCourseName(courseMapper.selectById(each.getCourseId()).getCourseName()))
        .filter(each -> !courseIdList.contains(each.getCourseId()))
        .collect(Collectors.toList());
  }

  @Override
  public List<Course> selectAvailableCourse(String tid) {
    return baseMapper.selectAvailableCourse(tid);
  }
}
