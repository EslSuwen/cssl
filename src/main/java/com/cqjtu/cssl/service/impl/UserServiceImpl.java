package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.User;
import com.cqjtu.cssl.mapper.UserMapper;
import com.cqjtu.cssl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息服务接口实现
 *
 * @author suwen
 * @date 2020/1/12 3:48 下午
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

  private final UserMapper userMapper;

  @Autowired
  public UserServiceImpl(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  /**
   * 注解式 自定义 mappper 方法调用
   *
   * @author suwen
   * @date 2020/1/12 3:45 下午
   * @param userName 用户名
   * @return User 用户
   */
  public User getUserByName(String userName) {
    return userMapper.selectByUserName(userName);
  }
}
