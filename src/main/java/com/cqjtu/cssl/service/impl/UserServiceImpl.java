package com.cqjtu.cssl.service.impl;

import com.cqjtu.cssl.entity.User;
import com.cqjtu.cssl.mapper.UserMapper;
import com.cqjtu.cssl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户服务接口实现
 *
 * @author: suwen
 * @time: 2020/2/6 3:48 下午
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

  @Autowired private UserMapper userMapper;

  @Override
  public User getUserById(Integer userId) {
    return userMapper.selectByPrimaryKey(userId);
  }

  @Override
  public void updateUser(User user) {
    userMapper.updateByPrimaryKey(user);
  }

  @Override
  public List<User> loadAll() {
    return userMapper.selectAll();
  }

  /**
   * 注解式 自定义 mappper 方法调用
   *
   * @author: suwen
   * @time: 2020/2/6 3:45 下午
   * @param userName
   * @return
   */
  public User getUserByName(String userName) {
    return userMapper.selectByUserName(userName);
  }
}
