package com.cqjtu.cssl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 根目录映射
 *
 * @author: suwen
 * @time: 2020/2/6 2:49 下午
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

}
