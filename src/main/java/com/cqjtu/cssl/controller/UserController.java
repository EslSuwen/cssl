package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.User;
import com.cqjtu.cssl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户 controller
 *
 * @author: suwen
 * @time: 2020/2/6 3:07 下午
 */
@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired private UserService userService;

  /**
   * 获取用户信息
   *
   * @author: suwen
   * @time: 2020/2/6 3:10 下午
   * @return: com.cqjtu.cssl.entity.User 用户
   */
  @GetMapping(value = "/getInfo")
  public User getInfo() {
    return new User();
  }

  /**
   * 修改用户信息
   *
   * @author: suwen
   * @time: 2020/2/6 3:10 下午
   * @param user 用户
   * @return: java.lang.String 状态码
   */
  @RequestMapping(value = "/update")
  public String update(User user) {

    userService.updateUser(user);
    return "";
  }
}
