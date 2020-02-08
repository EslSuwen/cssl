package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.Message;
import com.cqjtu.cssl.entity.User;
import com.cqjtu.cssl.service.UserService;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * 用户安全登录控制器
 *
 * @author: suwen
 * @time: 2020/2/6 2:58 下午
 */
@RestController
@RequestMapping("/security")
public class SecurityController {

  @Autowired private UserService userService;
  @Autowired private DefaultKaptcha defaultKaptcha;

  /**
   * 登录验证
   *
   * @param user 用户
   * @param request http 请求
   * @return: com.cqjtu.angularspringboot.Model.Message
   * @author: suwen
   * @time: 2020/2/3 1:26 下午
   */
  @PostMapping("/toLogin")
  public Message toLogin(@RequestBody User user, HttpServletRequest request) {
    System.out.println(request.getSession().getAttribute("teachernum"));
    System.out.println(user.getUserNo() + " : " + user.getUserPwd());
    Message msg = new Message();
    msg.setMsg("The member of " + user.getUserNo() + " has been logined: " + user.getUserPwd());
    return msg;
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

  /**
   * 生成图片验证码
   *
   * @author: suwen
   * @time: 2020/2/8 1:33 下午
   * @param request http 请求
   * @param response http 响应
   * @return:
   */
  @RequestMapping("/createImageCode")
  public void createImageCode(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    byte[] captchaChallengeAsJpeg = null;
    ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
    try {
      // 生产验证码字符串并保存到session中
      String createText = defaultKaptcha.createText();
      request.getSession().setAttribute("imageCode", createText);
      // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
      BufferedImage challenge = defaultKaptcha.createImage(createText);
      ImageIO.write(challenge, "jpg", jpegOutputStream);
      System.out.println("createImageCode:{}" + request.getSession().getAttribute("imageCode"));
    } catch (IllegalArgumentException e) {
      response.sendError(HttpServletResponse.SC_NOT_FOUND);
      return;
    }

    // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
    captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("image/jpeg");
    ServletOutputStream responseOutputStream = response.getOutputStream();
    responseOutputStream.write(captchaChallengeAsJpeg);
    responseOutputStream.flush();
    responseOutputStream.close();
  }
}
