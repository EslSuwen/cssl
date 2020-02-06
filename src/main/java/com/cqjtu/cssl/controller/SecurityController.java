package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.User;
import com.cqjtu.cssl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户安全登录 controller
 *
 * @author: suwen
 * @time: 2020/2/6 2:58 下午
 */
@RestController
@RequestMapping("/security")
public class SecurityController {

  @Autowired private UserService userService;

  /**
   * 用户登录请求
   *
   * @author: suwen
   * @time: 2020/2/6 3:07 下午
   * @param user 用户
   * @param request http 请求
   * @return: java.lang.String 状态码
   */
  @PostMapping(value = "/login")
  public String login(@RequestBody User user, HttpServletRequest request) {

    return "login";
  }

  /**
   * 用户注销请求
   *
   * @author: suwen
   * @time: 2020/2/6 3:02 下午
   * @param request http 请求
   * @return: java.lang.String 状态码
   */
  @GetMapping("/logout")
  public String logout(HttpServletRequest request) {

    // 获取session并将userName存入session对象
    HttpSession session = request.getSession();
    session.setAttribute("USER_SESSION_KEY", null);
    return "redirect:/security/toLogin";
  }
}
