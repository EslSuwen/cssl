package com.cqjtu.cssl;

import com.cqjtu.cssl.config.FileProperties;
import com.cqjtu.cssl.config.SecurityProperties;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Boot 入口
 *
 * @author suwen
 * @date 2020/2/21 下午3:29
 */
@MapperScan(basePackages = {"com.cqjtu.cssl.mapper"})
@SpringBootApplication
@EnableConfigurationProperties({
        FileProperties.class,
        SecurityProperties.class
})
@Configuration
@EnableAdminServer
public class CsslApplication {

  public static void main(String[] args) {
    SpringApplication.run(CsslApplication.class, args);
  }
}
