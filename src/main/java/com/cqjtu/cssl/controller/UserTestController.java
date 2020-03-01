package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.Message;
import com.cqjtu.cssl.entity.User;
import com.cqjtu.cssl.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户测试控制器
 *
 * @author suwen
 * @date 2020/2/6 3:12 下午
 */
@Api(tags = "用户测试-控制器")
@RestController
@RequestMapping("/test_user")
public class UserTestController {

  private final UserService userService;

  @Autowired
  public UserTestController(UserService userService) {
    this.userService = userService;
  }

  /**
   * 测试获取用户
   *
   * @return java.lang.Iterable<com.cqjtu.cssl.entity.User>
   * @author suwen
   * @date 2020/2/6 3:13 下午
   */
  @GetMapping(value = "/getUser")
  public List<User> getUsers() {

    System.out.println("getUsers()被调用");

    return userService.list();
  }

  /**
   * 测试删除用户
   *
   * @return com.cqjtu.cssl.utils.Message
   * @author suwen
   * @date 2020/2/6 3:13 下午
   */
  @DeleteMapping(value = "/clearUser")
  public Message clearDemodatas() {
    System.out.println("clearDemodatas()被调用");
    List<User> userList = userService.list();
    Message msg = new Message();
    msg.setMsg("The database has been cleared");
    return msg;
  }
}
