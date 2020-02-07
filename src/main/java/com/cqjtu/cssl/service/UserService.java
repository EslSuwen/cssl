package com.cqjtu.cssl.service;

import com.cqjtu.cssl.entity.User;

import java.util.List;

/**
 * 用户信息服务接口
 *
 * @author: suwen
 * @time: 2020/2/6 3:49 下午
 */
public interface UserService {

  /**
   * 获取一条用户记录
   *
   * @author: suwen
   * @time: 2020/2/6 3:45 下午
   * @param userId 用户编号
   * @return User
   */
  User getUserById(Integer userId);

  /**
   * 更新一条用户记录
   *
   * @author: suwen
   * @time: 2020/2/6 3:45 下午
   * @param user 用户
   */
  void updateUser(User user);

  /**
   * 获取所有用户记录
   *
   * @author: suwen
   * @time: 2020/2/6 3:45 下午
   * @return List<com.cqjtu.cssl.entity.User>
   */
  List<User> loadAll();
}
