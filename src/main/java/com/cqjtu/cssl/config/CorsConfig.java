package com.cqjtu.cssl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 对系统后台进行跨域访问进行配置
 *
 * @author suwen
 * @date 2019/3/7 2:27 下午
 */
@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    // 设置允许跨域的路径
    registry
        .addMapping("/**")
        // 设置允许跨域请求的域名
        .allowedOrigins(
            "*") // 也可以指定域名 .allowedOrigins("http://192.168.0.0:8080","http://192.168.0.1:8081")
        // 是否允许证书 不再默认开启
        .allowCredentials(true)
        // 设置允许的方法
        .allowedMethods("*")
        // 跨域允许时间
        .maxAge(3600);
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
    registry
        .addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }
}
