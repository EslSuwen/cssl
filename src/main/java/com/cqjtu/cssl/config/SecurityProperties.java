package com.cqjtu.cssl.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * SecurityProperties 自定义配置类
 *
 * @author suwen
 * @date 2020/2/24 下午1:32
 */
@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {

  private Cors cors = new Cors();

  private Jwt jwt = new Jwt();

  @Getter
  @Setter
  public static class Cors {
    private List<String> allowedOrigins = new ArrayList<>();

    private List<String> allowedMethods = new ArrayList<>();

    private List<String> allowedHeaders = new ArrayList<>();
  }

  @Getter
  @Setter
  public static class Jwt {
    private String header;

    private String secret;

    private Long expiration;

    private String issuer;

    private String authenticationPath;
  }
}
