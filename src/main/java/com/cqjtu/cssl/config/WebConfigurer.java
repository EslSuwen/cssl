//package com.cqjtu.cssl.config;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//@Configuration
//@EnableWebMvc
//public class WebConfigurer implements WebMvcConfigurer {
//
//    @Autowired
//    LoginInterceptor loginInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        /**
//         *
//         * addPathPatterns("/**") 表示拦截所有的请求，
//         * excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
//         */
//        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/", "/**/*.css",
//                        "/**/*.js", "/**/*.png", "/**/*.jpg",
//                        "/**/*.jpeg", "/**/*.gif", "/**/fonts/*",
//                        "login", "/logout", "index", "main", "/security",
//                        "/mainController", "/security/toLogin", "/security/login");
//    }
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        //设置允许跨域的路径
//        registry.addMapping("/**")
//                //设置允许跨域请求的域名
//                .allowedOrigins("*")  //也可以指定域名 .allowedOrigins("http://192.168.0.0:8080","http://192.168.0.1:8081")
//                //是否允许证书 不再默认开启
//                .allowCredentials(true)
//                //设置允许的方法
//                .allowedMethods("*")
//                //跨域允许时间
//                .maxAge(3600);
//    }
//
//}
