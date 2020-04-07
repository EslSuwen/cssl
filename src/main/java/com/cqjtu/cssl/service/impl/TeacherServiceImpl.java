package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

  @Override
  public int updatePassword(String tid, String oldPw, String newOld) {
    Teacher teacher = getOne(new QueryWrapper<Teacher>().eq("tid", tid).eq("tpassword", oldPw));
    if (teacher != null) {
      teacher.setTpassword(newOld);
      return updateById(teacher) ? 1 : 0;
    }
    return -1;
  }
}
