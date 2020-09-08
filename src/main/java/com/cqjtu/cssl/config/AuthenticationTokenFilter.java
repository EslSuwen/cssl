package com.cqjtu.cssl.config;

import com.cqjtu.cssl.utils.JwtTokenUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AuthenticationTokenFilter 验证权限。 token 过滤器 从 Request Header 中读取 Bearer Token 并验证，如验证成功则将用户信息保存在
 * SecurityContext 中，用户才可访问受限资源。在每次请求结束后，SecurityContext 会自动清空。
 *
 * @author suwen
 * @date 2020/2/24 下午1:42
 */
@Log4j2
public class AuthenticationTokenFilter extends OncePerRequestFilter {
  @Autowired private JwtTokenUtil jwtTokenUtil;

  @Autowired private SecurityProperties securityProperties;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws ServletException, IOException {
    String authToken = request.getHeader(securityProperties.getJwt().getHeader());

    String agentUri = request.getRequestURI();

    if (!agentUri.contains("actuator")
        && !agentUri.contains("instances")
        && !agentUri.contains("applications")) {
      // 略过 actuator 请求
      if (authToken != null && authToken.startsWith("Bearer ")) {
        authToken = authToken.substring(7);
      }
      UserDetails user = jwtTokenUtil.verify(authToken);
      log.info("user: " + user + "  URI: " + request.getRequestURI());
      log.info(authToken);

      if (user != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        log.info(
            "checking authentication for user "
                + user.getUsername()
                + " with tab "
                + user.getAuthorities());
        UsernamePasswordAuthenticationToken authentication =
            new UsernamePasswordAuthenticationToken(
                user.getUsername(), "N/A", user.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }

    chain.doFilter(request, response);
  }
}
