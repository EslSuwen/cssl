package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.AuthenticationRequest;
import com.cqjtu.cssl.entity.AuthenticationResponse;
import com.cqjtu.cssl.entity.Message;
import com.cqjtu.cssl.service.TeacherService;
import com.cqjtu.cssl.utils.JwtTokenUtil;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * 用户验证控制器
 *
 * @author suwen
 * @date 2020/2/26 下午12:15
 */
@Api(tags = "用户验证-控制器")
@RestController
@RequestMapping(value = "${api.base-path}", produces = MediaType.APPLICATION_JSON_VALUE)
@Log4j2
public class AuthenticationController {

  private final JwtTokenUtil jwtTokenUtil;
  private final UserDetailsService userDetailsService;
  private final AuthenticationManager authenticationManager;
  private final DefaultKaptcha defaultKaptcha;
  private final TeacherService teacherService;

  @Autowired
  public AuthenticationController(
      AuthenticationManager authenticationManager,
      JwtTokenUtil jwtTokenUtil,
      @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService,
      DefaultKaptcha defaultKaptcha,
      TeacherService teacherService) {
    this.authenticationManager = authenticationManager;
    this.jwtTokenUtil = jwtTokenUtil;
    this.userDetailsService = userDetailsService;
    this.defaultKaptcha = defaultKaptcha;
    this.teacherService = teacherService;
  }

  @ApiOperation(value = "用户验证", notes = "进行用户验证，成功返回 token,失败返回空。")
  @PostMapping("/auth")
  public AuthenticationResponse login(
      @NonNull @RequestBody AuthenticationRequest authRequest, HttpServletRequest request) {
    log.info(authRequest);
    log.info(request.getSession().getAttribute("imageCode"));

    if (!authRequest.getImgCode().equals(request.getSession().getAttribute("imageCode"))) {
      return new AuthenticationResponse("", null, new Message("Wrong imageCode!!!"));
    }

    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                authRequest.getUserNo(), authRequest.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);

    UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUserNo());
    String token = jwtTokenUtil.generate(userDetails);
    return new AuthenticationResponse(
        token, teacherService.getById(authRequest.getUserNo()), new Message("successful"));
  }

  /**
   * 生成图片验证码
   *
   * @author suwen
   * @date 2020/2/8 1:33 下午
   * @param request http 请求
   * @param response http 响应
   */
  @ApiOperation(value = "生成图片验证码", notes = "生成图片验证码并保存在 session 中。")
  @GetMapping("/createImageCode")
  public void createImageCode(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    byte[] captchaChallengeAsJpeg;
    ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
    try {
      // 生产验证码字符串并保存到session中
      String createText = defaultKaptcha.createText();
      request.getSession().setAttribute("imageCode", createText);

      // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
      BufferedImage challenge = defaultKaptcha.createImage(createText);
      ImageIO.write(challenge, "jpg", jpegOutputStream);
      System.out.println("createImageCode:{}" + request.getSession().getAttribute("imageCode"));
      log.info("createImageCode:" + createText);
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

  @ExceptionHandler(AuthenticationException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public void handleAuthenticationException(AuthenticationException exception) {
    log.error(exception.getMessage(), exception);
  }
}
