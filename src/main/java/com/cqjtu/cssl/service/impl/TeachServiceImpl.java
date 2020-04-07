package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.Teach;
import com.cqjtu.cssl.mapper.ArrangeMapper;
import com.cqjtu.cssl.mapper.CourseMapper;
import com.cqjtu.cssl.mapper.TeachMapper;
import com.cqjtu.cssl.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 授课信息服务实现类
 *
 * @author Aplin suwen
 * @since 2020-02-27
 */
@Service
public class TeachServiceImpl extends ServiceImpl<TeachMapper, Teach> implements TeachService {
  private final TeachMapper teachMapper;
  private final CourseMapper courseMapper;
  private final ArrangeMapper arrangeMapper;

  @Autowired
  public TeachServiceImpl(
      TeachMapper teachMapper, CourseMapper courseMapper, ArrangeMapper arrangeMapper) {
    this.teachMapper = teachMapper;
    this.courseMapper = courseMapper;
    this.arrangeMapper = arrangeMapper;
  }

  @Override
  public List<String> findCourseByTeacher(String tid) {
    List<String> list = new ArrayList<>();
    List<Teach> list1 = teachMapper.selectList(new QueryWrapper<Teach>().eq("tid",tid));
    for (Teach t : list1) {
      list.add(courseMapper.selectById(t.getCourseId()).getCourseName());
    }
    return list;
  }

  @Override
  public List<Teach> getCourseInfoByTid(String tid) {
    List<Teach> teachList = teachMapper.selectList(new QueryWrapper<Teach>().eq("tid",tid));
    for (Teach each : teachList) {
      each.setCourseName(courseMapper.selectById(each.getCourseId()).getCourseName());
      each.setLabId(arrangeMapper.findLabByClsNo(each.getCourseId()));
      if (each.getApplyLimit() == 0) {
        each.setStatus("审核中");
      } else {
        each.setStatus("审核通过");
      }
    }
    return teachList;
  }
}
