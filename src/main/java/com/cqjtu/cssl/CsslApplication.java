package com.cqjtu.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Spring Boot 入口
 *
 * @author suwen
 * @date 2020/2/21 下午3:29
 */
@EnableSwagger2
@MapperScan(basePackages = {"com.cqjtu.cssl.mapper"})
@SpringBootApplication()
public class CsslApplication {

  public static void main(String[] args) {
    SpringApplication.run(CsslApplication.class, args);
  }
}
