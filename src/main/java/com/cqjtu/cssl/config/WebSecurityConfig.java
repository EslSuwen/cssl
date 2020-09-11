package com.cqjtu.cssl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * WebSecurityConfig Spring Security 配置 完成跨域和请求放行
 *
 * @author suwen
 * @date 2020/2/25 上午11:13
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final SecurityProperties securityProperties;

  @Autowired
  public WebSecurityConfig(SecurityProperties securityProperties) {
    this.securityProperties = securityProperties;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors()
        .and()
        .csrf()
        .disable()
        .exceptionHandling()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and() // don't create session
        .authorizeRequests()
        .antMatchers("/**")
        .permitAll();
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    SecurityProperties.Cors cors = securityProperties.getCors();
    configuration.setAllowedOrigins(cors.getAllowedOrigins());
    configuration.setAllowedMethods(cors.getAllowedMethods());
    configuration.setAllowedHeaders(cors.getAllowedHeaders());
    configuration.setAllowCredentials(true);
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
}
