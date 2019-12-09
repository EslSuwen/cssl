package com.cqjtu.cssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CsslApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsslApplication.class, args);
    }

//    @SpringBootApplication
    @RequestMapping(value = "/hello", produces = "text/plain;charset=UTF-8")
    String index() {
        return "Hello Spring Boot!";
    }
}
