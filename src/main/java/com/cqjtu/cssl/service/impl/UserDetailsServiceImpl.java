package com.cqjtu.cssl.service.impl;

import com.cqjtu.cssl.entity.Authority;
import com.cqjtu.cssl.entity.Teacher;
import com.cqjtu.cssl.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.cqjtu.cssl.utils.AuthorityUtil.createGrantedAuthorities;

/**
 * SpringBoot UserDetails 服务实现类
 *
 * @author suwen
 * @date 2020/2/26 下午12:20
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final TeacherMapper teacherMapper;

  @Autowired
  public UserDetailsServiceImpl(TeacherMapper teacherMapper) {
    this.teacherMapper = teacherMapper;
  }

  @Override
  public UserDetails loadUserByUsername(String userNo) {
    Teacher teacher = teacherMapper.selectById(userNo);
    List<Authority> authorities = new ArrayList<>();
    authorities.add(new Authority(1L, teacher.getAuthority()));
    teacher.setAuthorities(authorities);
    return create(teacher);
  }

  private static User create(Teacher teacher) {
    return new User(
        teacher.getTid(),
        teacher.getTpassword(),
        createGrantedAuthorities(teacher.getAuthorities()));
  }
}
