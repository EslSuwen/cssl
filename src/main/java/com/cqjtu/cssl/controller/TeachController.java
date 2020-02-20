package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.Teach;
import com.cqjtu.cssl.entity.User;
import com.cqjtu.cssl.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 授课信息控制器
 *
 * @author: suwen
 * @time: 2020/2/20 上午11:47
 */
@RestController
@RequestMapping("/teach")
public class TeachController {

  @Autowired private TeachService teachService;

  /**
   * 获取用户信息
   *
   * @author: suwen
   * @time: 2020/2/6 3:10 下午
   * @return: com.cqjtu.cssl.entity.User 用户
   */
  @GetMapping(value = "/getTeachInfo/{tid}")
  public List<Teach> getTeachInfo(@PathVariable String tid) {

    System.out.println("tid = " + tid);
    if (tid == null) {
      tid = "" + 1;
    }
    return teachService.getCourseInfoByTid(tid);
  }
}
