package com.cqjtu.cssl.service.impl;

import com.cqjtu.cssl.constant.AuthorityName;
import com.cqjtu.cssl.entity.Authority;
import com.cqjtu.cssl.entity.Teacher;
import com.cqjtu.cssl.mapper.TeacherMapper;
import com.cqjtu.cssl.service.TeachService;
import com.cqjtu.cssl.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.cqjtu.cssl.utils.AuthorityUtil.createGrantedAuthorities;

/**
 * SpringBoot UserDetails 服务实现类 实现权限列表加载
 *
 * @author suwen
 * @date 2020/2/26 下午12:20
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final TeacherService teachService;

  @Autowired
  public UserDetailsServiceImpl(TeacherService teachService) {
    this.teachService = teachService;
  }

  @Override
  public UserDetails loadUserByUsername(String userNo) {
    Teacher teacher = teachService.getById(userNo);
    List<Authority> authorities = new ArrayList<>();
    for (int i = teacher.getAuthority(); i > 0; i--) {
      authorities.add(new Authority(1L, AuthorityName.valueOf(i)));
    }
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
