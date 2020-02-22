package com.cqjtu.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)

/**
 * Spring Boot 入口
 *
 * @author suwen
 * @date 2020/2/21 下午3:29
 */
@MapperScan(basePackages = {"com.cqjtu.cssl.mapper"})
public class CsslApplication {

  public static void main(String[] args) {
    SpringApplication.run(CsslApplication.class, args);
  }
}
