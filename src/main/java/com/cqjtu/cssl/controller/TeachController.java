package com.cqjtu.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqjtu.cssl.dto.Result;
import com.cqjtu.cssl.entity.Teach;
import com.cqjtu.cssl.service.TeachService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
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
  @ApiOperation("根据教师 id 获取当前学期授课信息")
  @GetMapping("/getTeachInfo")
  public ResponseEntity<Result> getTeachInfo(
      @ApiParam(value = "教师编号", required = true) @RequestParam String tid,
      @ApiParam(value = "学期", required = true) @RequestParam String term) {
    return Result.successGet(teachService.getCourseInfoByTid(tid, term));
  }

  /**
   * 根据教师 id 获取所有授课信息
   *
   * @param tid 教师编号
   * @author suwen
   * @date 2020/3/23 3:10 下午
   * @return 授课信息列表
   */
  @ApiOperation("根据教师 id 获取所有授课信息")
  @GetMapping("/getTeach/{tid}")
  public ResponseEntity<Result> getTeachByTid(
      @ApiParam(value = "教师编号", required = true) @PathVariable String tid) {
    return Result.successGet(teachService.getTeachByTid(tid));
  }

  /**
   * 通过教师编号查找可增加课程信息
   *
   * @param tid 教师编号
   * @author suwen
   * @date 2020/10/5 下午3:11
   * @return 课程信息列表
   */
  @ApiOperation("通过教师编号查找可增加课程信息")
  @GetMapping("/getAvailableCourse/{tid}")
  public ResponseEntity<Result> getAvailableCourse(
      @ApiParam(value = "教师编号", required = true) @PathVariable String tid) {
    return Result.successGet(teachService.selectAvailableCourse(tid));
  }

  /**
   * 增加授课信息
   *
   * @param teaches 授课信息
   * @author suwen
   * @date 2020/10/5 下午3:36
   */
  @ApiOperation("增加授课信息")
  @PostMapping("/addTeaches")
  public ResponseEntity<Result> addTeaches(
      @ApiParam(value = "教师编号", required = true) @RequestBody List<Teach> teaches) {
    return Result.successAdd(teachService.saveBatch(teaches));
  }

  /**
   * 删除授课信息
   *
   * @param tid 教师编号
   * @param courseId 课程编号
   * @author suwen
   * @date 2020/10/5 下午3:36
   */
  @ApiOperation("删除授课信息")
  @DeleteMapping("/removeTeach")
  public ResponseEntity<Result> removeTeach(
      @ApiParam(value = "教师编号", required = true) @RequestParam String tid,
      @ApiParam(value = "课程编号", required = true) @RequestParam String courseId) {
    return Result.successDelete(
        teachService.remove(new QueryWrapper<Teach>().eq("tid", tid).eq("course_id", courseId)));
  }
}
