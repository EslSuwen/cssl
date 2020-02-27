package com.cqjtu.cssl.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Swagger 配置 springfox 注解简单介绍 常用注解： @Api () 用于类； 表示标识这个类是 swagger 的资源 @ApiOperation () 用于方法； 表示一个
 * http * 请求的操作 @ApiParam () 用于方法，参数，字段说明； 表示对参数的添加元数据（说明或是否必填等） @ApiModel () 用于类
 * 表示对类进行说明，用于参数用实体类接收 @ApiModelProperty () 用于方法，字段 表示对 model 属性的说明或者数据操作更改 @ApiIgnore ()
 * 用于类，方法，方法参数 表示这个方法或者类被忽略 @ApiImplicitParam () 用于方法 表示单独的请求参数 @ApiImplicitParams ()
 * 用于方法，包含多个 @ApiImplicitParam
 *
 * @author suwen
 * @date 2020/2/26 下午3:55
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

  /** 项目版本 */
  @Value("${info.app.version}")
  private String appVersion;

  @Bean
  public Docket petApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.cqjtu.cssl.controller"))
        .paths(PathSelectors.any())
        .build()
        //        .groupName("前端控制器接口文档 " + appVersion)
        .apiInfo(apiInfo())
        .pathMapping("/")
        .directModelSubstitute(LocalDate.class, String.class)
        .genericModelSubstitutes(ResponseEntity.class)
        .useDefaultResponseMessages(false)
        .securitySchemes(newArrayList(apiKey()))
        //        .securityContexts(newArrayList(securityContext()))
        .enableUrlTemplating(false);
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Api Documentation")
        .description("Author")
        .contact(new Contact("Suwen", "https://github.com/eslsuwen", "esllovesn@gmail.com"))
        .version(appVersion)
        .build();
  }

  private ApiKey apiKey() {
    // 用于Swagger UI测试时添加Bearer Token
    return new ApiKey("BearerToken", "Authorization", "header");
  }

  /*  private SecurityContext securityContext() {
    return SecurityContext.builder()
        .securityReferences(defaultAuth())
        // 注意要与Restful API路径一致
        .forPaths(PathSelectors.regex("/api/.*"))
        .build();
  }

  List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;
    return newArrayList(new SecurityReference("BearerToken", authorizationScopes));
  }*/
}
