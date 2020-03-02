package com.cqjtu.cssl.controller;

import com.cqjtu.angularspringboot.Model.AuthenticationRequest;
import com.cqjtu.angularspringboot.Model.AuthenticationResponse;
import com.cqjtu.cssl.utils.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
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

  @Autowired
  public AuthenticationController(
          AuthenticationManager authenticationManager,
          JwtTokenUtil jwtTokenUtil,
          @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
    this.authenticationManager = authenticationManager;
    this.jwtTokenUtil = jwtTokenUtil;
    this.userDetailsService = userDetailsService;
  }

  @ApiOperation(value = "用户验证", notes = "进行用户验证，成功返回 token,失败返回空。")
  @PostMapping("/auth")
  public AuthenticationResponse login(@NonNull @RequestBody AuthenticationRequest request) {
    log.info(request);

    Authentication authentication =
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);


    UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
    String token = jwtTokenUtil.generate(userDetails);
    return new AuthenticationResponse(token);
  }

  @ExceptionHandler(AuthenticationException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public void handleAuthenticationException(AuthenticationException exception) {
    log.error(exception.getMessage(), exception);
  }
}
