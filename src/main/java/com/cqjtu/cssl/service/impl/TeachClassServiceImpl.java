package com.cqjtu.cssl.service.impl;

import com.cqjtu.cssl.entity.TeachClass;
import com.cqjtu.cssl.entity.TeacherCourseClassHelper;
import com.cqjtu.cssl.mapper.MajorMapper;
import com.cqjtu.cssl.mapper.TeachClassMapper;
import com.cqjtu.cssl.mapper.TeacherCourseClassMapper;
import com.cqjtu.cssl.service.TeachClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 教师授课班级信息服务接口实现
 *
 * @author: Aplin
 * @time: 2020/1/13 11:08 上午
 */
@Service
public class TeachClassServiceImpl implements TeachClassService {
  @Autowired private TeachClassMapper teachClassMapper;
  @Autowired private MajorMapper majorMapper;
  @Autowired private TeacherCourseClassMapper teacherCourseClassMapper;

  @Override
  public List<String> findByTidAndCourseID(String tid, int courseID) {
    List<TeachClass> teachClasses = teachClassMapper.findByTidAndCourseID(tid, courseID);
    List<String> list = new ArrayList<>();
    for (TeachClass t : teachClasses) {
      list.add(majorMapper.findById(t.getMajorID()).getManjorName() + t.getClassName());
    }
    return list;
  }

  @Override
  public List<TeacherCourseClassHelper> findAll() {
    return teacherCourseClassMapper.findALL();
  }
}
