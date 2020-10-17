package com.cqjtu.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqjtu.cssl.constant.ResultCode;
import com.cqjtu.cssl.dto.ResultDto;
import com.cqjtu.cssl.entity.Teach;
import com.cqjtu.cssl.service.TeachService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
   * 根据教师 id 获取当前学期授课信息
   *
   * @param tid 教师编号
   * @param term 学期
   * @author suwen
   * @date 2020/3/23 3:10 下午
   * @return 授课信息列表
   */
  @GetMapping(value = "/getTeachInfo")
  public ResponseEntity<ResultDto> getTeachInfo(
      @ApiParam(value = "教师编号", required = true) @RequestParam String tid,
      @ApiParam(value = "学期", required = true) @RequestParam String term) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ResultCode.SUCCESS_GET_DATA.getCode())
            .message("获取授课信息成功")
            .data(teachService.getCourseInfoByTid(tid, term))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 根据教师 id 获取所有授课信息
   *
   * @param tid 教师编号
   * @author suwen
   * @date 2020/3/23 3:10 下午
   * @return 授课信息列表
   */
  @GetMapping("/getTeach/{tid}")
  public ResponseEntity<ResultDto> getTeachByTid(
      @ApiParam(value = "教师编号", required = true) @PathVariable String tid) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ResultCode.SUCCESS_GET_DATA.getCode())
            .message("获取授课信息成功")
            .data(teachService.getTeachByTid(tid))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 通过教师编号查找可增加课程信息
   *
   * @param tid 教师编号
   * @author suwen
   * @date 2020/10/5 下午3:11
   * @return 课程信息列表
   */
  @GetMapping("/getAvailableCourse/{tid}")
  public ResponseEntity<ResultDto> getAvailableCourse(
      @ApiParam(value = "教师编号", required = true) @PathVariable String tid) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ResultCode.SUCCESS_GET_DATA.getCode())
            .message("获取可用授课课程成功")
            .data(teachService.selectAvailableCourse(tid))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 增加授课信息
   *
   * @param teaches 授课信息
   * @author suwen
   * @date 2020/10/5 下午3:36
   */
  @PostMapping("/addTeaches")
  public ResponseEntity<ResultDto> addTeaches(
      @ApiParam(value = "教师编号", required = true) @RequestBody List<Teach> teaches) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(teachService.saveBatch(teaches))
            .code(ResultCode.SUCCESS_ADD_DATA.getCode())
            .message("授课信息" + ResultCode.SUCCESS_ADD_DATA.getMessage())
            .build(),
        HttpStatus.OK);
  }

  /**
   * 删除授课信息
   *
   * @param tid 教师编号
   * @param courseId 课程编号
   * @author suwen
   * @date 2020/10/5 下午3:36
   */
  @DeleteMapping("/removeTeach")
  public ResponseEntity<ResultDto> removeTeach(
      @ApiParam(value = "教师编号", required = true) @RequestParam String tid,
      @ApiParam(value = "课程编号", required = true) @RequestParam String courseId) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(
                teachService.remove(
                    new QueryWrapper<Teach>().eq("tid", tid).eq("course_id", courseId)))
            .code(ResultCode.SUCCESS_DELETE_DATA.getCode())
            .message("授课信息" + ResultCode.SUCCESS_DELETE_DATA.getMessage())
            .build(),
        HttpStatus.OK);
  }
}
