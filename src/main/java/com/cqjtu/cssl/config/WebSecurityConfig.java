package com.cqjtu.cssl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.http.HttpMethod.*;

/**
 * WebSecurityConfig Spring Security 配置。 在 Spring Boot 2.0 中必须覆盖 authenticationManagerBean ()
 * 方法，否则在 @Autowired authenticationManager 时会报错：Field authenticationManager required a bean of type
 * 'org.springframework.security.authentication.AuthenticationManager' that could not be found.
 * 初始化数据中的密码是调用 new BCryptPasswordEncoder ().encode () 方法生成的。 POST\PUT\DELETE 请求需要 "ADMIN" 角色。调用
 * hasRole () 方法时应去掉前缀 "ROLE_"，方法会自动补充，否则请使用 hasAuthority ()。
 *
 * @author suwen
 * @date 2020/2/25 上午11:13
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  private static final String ROLE_ADMIN = "ADMIN";

  @Value("${management.endpoints.web.exposure.include}")
  private String[] actuatorExposures;

  /** 放行白名单 */
  private static final String[] WHITE_LIST = {
    // TODO 调试关闭验证
    "/**",
    "/**/*.css,",
    "/**/*.jpg,",
    "/**/*.png,",
    "/**/*.ico,",
    "/**/*.js",
    "/**/*.html",
    "/api-docs",
    "/swagger-resources/**",
    "/webjars/**",
    "/csrf/**",
    "/api/createImageCode"
  };

  private final JwtAuthenticationEntryPoint unauthorizedHandler;

  private final SecurityProperties securityProperties;

  private final UserDetailsService userDetailsService;

  @Autowired
  public WebSecurityConfig(
      JwtAuthenticationEntryPoint unauthorizedHandler,
      SecurityProperties securityProperties,
      @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
    this.unauthorizedHandler = unauthorizedHandler;
    this.securityProperties = securityProperties;
    this.userDetailsService = userDetailsService;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    String authPath = "/auth";
    http.cors()
        .and()
        .csrf()
        .disable()
        .exceptionHandling()
        .authenticationEntryPoint(unauthorizedHandler)
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and() // don't create session
        .authorizeRequests()
        //        .requestMatchers(EndpointRequest.to(actuatorExposures))
        //        .hasRole(ROLE_ADMIN)
        .requestMatchers(EndpointRequest.toAnyEndpoint())
        .permitAll()
        .antMatchers(securityProperties.getJwt().getAuthenticationPath())
        .permitAll()
        .antMatchers(OPTIONS, "/**")
        .permitAll()
        .antMatchers(authPath)
        .permitAll()
        .antMatchers(DELETE, "/**")
        .hasRole(ROLE_ADMIN)
        .antMatchers(WHITE_LIST)
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        // Custom JWT based security filter
        .addFilterBefore(
            authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class)
        .headers()
        .cacheControl(); // disable page caching
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Bean
  public AuthenticationTokenFilter authenticationTokenFilterBean() {
    return new AuthenticationTokenFilter();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
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
