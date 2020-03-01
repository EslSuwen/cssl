package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.User;
import com.cqjtu.cssl.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户信息控制器
 *
 * @author suwen
 * @date 2020/2/6 3:07 下午
 */
@Api(tags = "用户信息-控制器")
@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  /**
   * 获取用户信息
   *
   * @return com.cqjtu.cssl.entity.User 用户
   * @author suwen
   * @date 2020/2/6 3:10 下午
   */
  @GetMapping(value = "/getInfo")
  public User getInfo() {
    return new User();
  }

  /**
   * 修改用户信息
   *
   * @param user 用户
   * @return java.lang.String 状态码
   * @author suwen
   * @date 2020/2/6 3:10 下午
   */
  @PostMapping(value = "/update")
  public String update(User user) {

    userService.updateById(user);
    return "";
  }

  /**
   * 获取所有用户信息
   *
   * @return java.util.List<com.cqjtu.cssl.entity.User>
   * @author suwen
   * @date 2020/2/20 下午5:19
   */
  @GetMapping(value = "/getAllInfo")
  public List<User> getAllInfo() {
    return userService.list();
  }
}
