package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.Arrange;
import com.cqjtu.cssl.service.ArrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 实验室安排前端控制器
 *
 * @author suwen
 * @since 2020-02-21
 */
@RestController
@RequestMapping("/arrange")
public class ArrangeController {

  @Autowired private ArrangeService arrangeService;

  /**
   * 查询排课
   *
   * @return List<Arrange> 排课数据列表
   * @author suwen
   * @date 2020/2/21 下午7:32
   */
  @GetMapping("/getArrange")
  public List<Arrange> getArrange() {
    return arrangeService.list();
  }
}
