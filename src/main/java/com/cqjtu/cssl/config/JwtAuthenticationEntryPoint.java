package com.cqjtu.cssl.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * JwtAuthenticationEntryPoint 没有使用 form 或 basic 等验证机制，需要自定义一个
 * AuthenticationEntryPoint，当未验证用户访问受限资源时，返回 401 错误。如没有自定义 AuthenticationEntryPoint，将返回 403 错误。使用方法见
 * WebSecurityConfig。
 *
 * @author suwen
 * @date 2020/2/26 下午12:13
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
  @Override
  public void commence(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException authException)
      throws IOException, ServletException {
    // This is invoked when user tries to access a secured REST resource without supplying any
    // credentials
    // We should just send a 401 Unauthorized response because there is no 'login page' to redirect
    // to
    response.sendError(UNAUTHORIZED.value(), UNAUTHORIZED.getReasonPhrase());
  }
}
