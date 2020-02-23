package com.cqjtu.cssl.service.impl;

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
 * 教师授课信息服务接口实现
 *
 * @author: Aplin suwen
 * @time: 2020/1/13 11:08 上午
 */
@Service
public class TeachServiceImpl implements TeachService {
  @Autowired TeachMapper teachMapper;
  @Autowired CourseMapper courseMapper;
  @Autowired ArrangeMapper arrangeMapper;

  @Override
  public List<String> findCourseByTeacher(String tid) {
    List<String> list = new ArrayList<>();
    List<Teach> list1 = teachMapper.findByTid(tid);
    for (Teach t : list1) {
      list.add(courseMapper.findByID(t.getCourseID()).getCourseName());
    }
    return list;
  }

  @Override
  public List<Teach> getCourseInfoByTid(String tid) {
    List<Teach> teachList = teachMapper.findByTid(tid);
    for (Teach each : teachList) {
      each.setCourseName(courseMapper.findByID(each.getCourseID()).getCourseName());
      each.setLabId(arrangeMapper.findLabByClsNo(each.getCourseID()));
      if (each.getApplyLimit() == 0) {
        each.setStatus("审核中");
      } else {
        each.setStatus("审核通过");
      }
    }
    return teachList;
  }
}
