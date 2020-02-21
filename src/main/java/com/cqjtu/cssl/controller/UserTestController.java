package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.User;
import com.cqjtu.cssl.service.UserService;
import com.cqjtu.cssl.utils.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户测试控制器
 *
 * @author suwen
 * @date 2020/2/6 3:12 下午
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/test_user")
public class UserTestController {

  @Autowired private UserService userService;

  /**
   * 测试获取用户
   *
   * @return java.lang.Iterable<com.cqjtu.cssl.entity.User>
   * @author suwen
   * @date 2020/2/6 3:13 下午
   */
  @GetMapping(value = "/getUser")
  public Iterable<User> getUsers() {

    System.out.println("getUsers()被调用");

    return userService.loadAll();
  }

  /**
   * 测试删除用户
   *
   * @return com.cqjtu.cssl.utils.MessageHelper
   * @author suwen
   * @date 2020/2/6 3:13 下午
   */
  @DeleteMapping(value = "/clearUser")
  public MessageHelper clearDemodatas() {
    System.out.println("clearDemodatas()被调用");
    List<User> userList = userService.loadAll();
    MessageHelper msg = new MessageHelper();
    msg.setMsg("The database has been cleared");
    return msg;
  }
}
