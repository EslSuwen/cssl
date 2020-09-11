package com.cqjtu.cssl.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import com.cqjtu.cssl.entity.Teacher;
import com.cqjtu.cssl.mapper.TeacherMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限验证接口扩展
 *
 * @author suwen
 */
@Log4j2
@Component
public class StpInterfaceImpl implements StpInterface {

  private final TeacherMapper teacherMapper;

  @Autowired
  public StpInterfaceImpl(TeacherMapper teacherMapper) {
    this.teacherMapper = teacherMapper;
  }

  /** 返回一个账号所拥有的权限码集合 */
  @Override
  public List<Object> getPermissionCodeList(Object loginId, String loginKey) {

    log.info(loginKey + ":" + loginKey);

    Teacher teacher = teacherMapper.selectById(loginId.toString());

    if (teacher == null) {
      return new ArrayList<>();
    }
    List<Object> list = new ArrayList<>();
    switch (teacher.getAuthority()) {
      case ROLE_USER:
        list.add("ROLE_USER");
        break;
      case ROLE_ADMIN:
        list.add("ROLE_ADMIN");
        break;
      default:
        throw new RuntimeException("权限获取转换失败，请联系管理员");
    }
    return list;
  }
}
