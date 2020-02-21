package com.cqjtu.cssl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 根目录映射控制器
 *
 * @author suwen
 * @date 2020/2/6 2:49 下午
 */
@Controller
public class IndexController {

  @GetMapping("/index")
  @ResponseBody
  public String root() {
    return "index";
  }
}
