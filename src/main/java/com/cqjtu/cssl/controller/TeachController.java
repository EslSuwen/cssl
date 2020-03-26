package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.Teach;
import com.cqjtu.cssl.entity.TeacherMsg;
import com.cqjtu.cssl.service.TeachService;
import com.cqjtu.cssl.service.TeacherMsgService;
import io.swagger.annotations.Api;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 授课信息控制器
 *
 * @author suwen
 * @date 2020/2/20 上午11:47
 */
@Api(tags = "授课信息-控制器")
@RestController
@RequestMapping("/teach")
public class TeachController {

  private final TeachService teachService;

  @Autowired
  public TeachController(TeachService teachService) {
    this.teachService = teachService;
  }


  /**
   * 根据教师 id 获取授课信息
   *
   * @author suwen
   * @date 2020/3/23 3:10 下午
   * @return 授课信息列表
   */
  @GetMapping(value = "/getTeachInfo/{tid}")
  public List<Teach> getTeachInfo(@NonNull @PathVariable String tid) {
    return teachService.getCourseInfoByTid(tid);
  }


}
