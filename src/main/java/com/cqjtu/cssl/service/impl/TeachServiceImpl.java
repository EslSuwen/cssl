package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.Course;
import com.cqjtu.cssl.entity.Teach;
import com.cqjtu.cssl.mapper.TeachMapper;
import com.cqjtu.cssl.service.CourseService;
import com.cqjtu.cssl.service.ExpProjectService;
import com.cqjtu.cssl.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 授课信息服务实现类
 *
 * @author Aplin suwen
 * @since 2020-02-27
 */
@Service
public class TeachServiceImpl extends ServiceImpl<TeachMapper, Teach> implements TeachService {
  private CourseService courseService;
  private ExpProjectService expProjectService;

  @Autowired
  public CourseService getCourseService() {
    return courseService;
  }

  @Autowired
  public ExpProjectService getExpProjectService() {
    return expProjectService;
  }

  @Override
  public List<Teach> getTeachByTid(String tid) {
    return baseMapper.selectAll(tid);
  }

  @Override
  public List<Teach> getCourseInfoByTid(String tid, String term) {

    /*List<Integer> courseIdList =
        expProjectService.getExpByTid(tid, term).stream()
            .map(ExpProject::getCourseId)
            .collect(Collectors.toList());

    return list(new QueryWrapper<Teach>().eq("tid", tid)).stream()
        .peek(
            each -> each.setCourseName(courseService.getById(each.getCourseId()).getCourseName()))
        .filter(each -> !courseIdList.contains(each.getCourseId()))
        .collect(Collectors.toList());*/
    return baseMapper.getCourseInfoByTid(tid, term);
  }

  @Override
  public List<Course> selectAvailableCourse(String tid) {
    return baseMapper.selectAvailableCourse(tid);
  }
}
