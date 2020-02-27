package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.Teacher;
import com.cqjtu.cssl.mapper.TeacherMapper;
import com.cqjtu.cssl.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 教师信息服务实现类
 *
 * @author Aplin suwen
 * @since 2020-02-27
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
    implements TeacherService {
  private final TeacherMapper teacherMapper;

  @Autowired
  public TeacherServiceImpl(TeacherMapper teacherMapper) {
    this.teacherMapper = teacherMapper;
  }

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
    teacher.setTpassword(teacher1.getTpassword());
    teacher.setTlimit(teacher1.getTlimit());
    teacherMapper.updateById(teacher);
  }

  @Override
  public String findPassword(String tid) {

    return teacherMapper.findPassword(tid);
  }
}
