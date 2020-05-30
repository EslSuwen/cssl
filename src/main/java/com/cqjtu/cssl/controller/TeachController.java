package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.constant.ReturnCode;
import com.cqjtu.cssl.dto.ResultDto;
import com.cqjtu.cssl.service.TeachService;
import io.swagger.annotations.Api;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
  @GetMapping(value = "/getTeachInfo")
  public ResponseEntity<ResultDto> getTeachInfo(@NonNull @RequestParam String tid) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .message("获取授课信息成功")
            .data(teachService.getCourseInfoByTid(tid))
            .build(),
        HttpStatus.OK);
  }
}
