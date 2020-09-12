package com.cqjtu.cssl.config;

import cn.dev33.satoken.annotation.SaCheckInterceptor;
import cn.dev33.satoken.config.SaTokenConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * sa-token 拦截器配置
 *
 * @author suwen
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
  /** 注册sa-token的拦截器，打开注解式鉴权功能 */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 全局拦截器
    registry.addInterceptor(new SaCheckInterceptor()).addPathPatterns("/**");
  }

}
