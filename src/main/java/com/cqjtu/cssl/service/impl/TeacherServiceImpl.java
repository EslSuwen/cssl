package com.cqjtu.cssl.service.impl;

import com.cqjtu.cssl.entity.Teacher;
import com.cqjtu.cssl.mapper.TeacherMapper;
import com.cqjtu.cssl.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 教师信息服务接口实现
 *
 * @author: Aplin
 * @time: 2020/1/13 11:09 上午
 */
@Service
public class TeacherServiceImpl implements TeacherService {
  @Autowired private TeacherMapper teacherMapper;

  @Override
  public Teacher findByTid(String tid) {
    return teacherMapper.findById(tid);
  }

  @Override
  public void updatePassword(String tid, String password) {
    teacherMapper.updatePassword(tid, password);
  }

  @Override
  public void updateTeacher(String tid, Teacher teacher) {
    Teacher teacher1 = teacherMapper.findById(tid);
    teacher.settPassword(teacher1.gettPassword());
    teacher.setytLimit(teacher1.gettLimit());
    teacherMapper.updateById(teacher);
  }

  @Override
  public String findPassword(String tid) {

    return teacherMapper.findPassword(tid);
  }
}
