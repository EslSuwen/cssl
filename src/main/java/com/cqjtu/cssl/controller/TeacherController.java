package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.constant.ReturnCode;
import com.cqjtu.cssl.dto.ResultDto;
import com.cqjtu.cssl.entity.TeacherMsg;
import com.cqjtu.cssl.service.TeacherMsgService;
import com.cqjtu.cssl.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 教师信息前端控制器
 *
 * @author suwen
 * @since 2020-02-27
 */
@Log4j2
@Api(tags = "教师信息-控制器")
@RestController
@RequestMapping("/teacher")
public class TeacherController {

  private final TeacherService teacherService;
  private final TeacherMsgService teacherMsgService;

  @Autowired
  public TeacherController(TeacherService teacherService, TeacherMsgService teacherMsgService) {
    this.teacherService = teacherService;
    this.teacherMsgService = teacherMsgService;
  }

  /**
   * 增加教师消息
   *
   * @param teacherMsg 消息
   * @author suwen
   * @date 2020/8/21 下午2:23
   */
  @PostMapping("/addTeacherMsg")
  public ResponseEntity<ResultDto> addTeacherMsg(@RequestBody TeacherMsg teacherMsg) {
    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20005.getCode())
            .message(ReturnCode.RETURN_CODE_20005.getMessage())
            .data(teacherMsgService.save(teacherMsg))
            .build(),
        HttpStatus.CREATED);
  }

  /**
   * 根据教师 id 获取教师信息
   *
   * @author suwen
   * @date 2020/3/23 16:45 下午
   * @return 教师信息
   */
  @GetMapping(value = "/getTeacherInfo/{tid}")
  public ResponseEntity<ResultDto> getTeacherInfo(@PathVariable String tid) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .message("获取教师信息成功")
            .data(teacherService.getById(tid))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 根据教师 id 获取消息
   *
   * @param tid 教师编号
   * @author suwen
   * @date 2020/3/23 17:28 下午
   * @return 授课信息列表
   */
  @GetMapping(value = "/getMsgInfo/{tid}")
  public ResponseEntity<ResultDto> getMsgInfo(
      @ApiParam(value = "教师编号", required = true) @PathVariable String tid) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .message("获取教师信息成功")
            .data(teacherMsgService.getMsgListByTid(tid))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 根据消息 id 已读消息
   *
   * @author suwen
   * @date 2020/3/24 12:28 下午
   */
  @PutMapping(value = "/readMsg/{mid}")
  public ResponseEntity<ResultDto> readMsg(@PathVariable String mid) {

    TeacherMsg teacherMsg = teacherMsgService.getById(mid);
    teacherMsg.setMstatus(1);
    return new ResponseEntity<>(
        ResultDto.builder()
            .success(teacherMsgService.updateById(teacherMsg))
            .code(ReturnCode.RETURN_CODE_20004.getCode())
            .message("用户消息已读成功")
            .build(),
        HttpStatus.OK);
  }

  /**
   * 根据消息 id 删除消息
   *
   * @param mid 消息编号
   * @author suwen
   * @date 2020/3/24 12:28 下午
   */
  @GetMapping(value = "/deleteMsg/{mid}")
  public ResponseEntity<ResultDto> deleteMsg(
      @ApiParam(value = "消息编号", required = true) @PathVariable String mid) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(teacherMsgService.removeById(mid))
            .code(ReturnCode.RETURN_CODE_20006.getCode())
            .message("教师删除消息成功")
            .build(),
        HttpStatus.OK);
  }

  /**
   * 用户修改密码
   *
   * @param tid 教师编号
   * @param oldPw 当前密码
   * @param newPw 新密码
   * @return int 状态码
   * @author suwen
   * @date 2020/4/1 下午7:56
   */
  @PutMapping("/updatePassword")
  public ResponseEntity<ResultDto> updatePassword(
      @ApiParam(value = "教师编号", required = true) @RequestParam String tid,
      @ApiParam(value = "当前密码", required = true) @RequestParam String oldPw,
      @ApiParam(value = "新密码", required = true) @RequestParam String newPw) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(teacherService.updatePassword(tid, oldPw, newPw))
            .code(ReturnCode.RETURN_CODE_20004.getCode())
            .message("教师修改密码成功")
            .build(),
        HttpStatus.OK);
  }

  /**
   * 获取教师某周课表
   *
   * @param tid 教师编号
   * @param week 周次
   * @return java.util.List<com.cqjtu.cssl.entity.Curriculum>
   * @author suwen
   * @date 2020/5/11 上午9:35
   */
  @GetMapping("/getCurriculum")
  public ResponseEntity<ResultDto> getCurriculum(
      @ApiParam(value = "教师编号", required = true) @RequestParam String tid,
      @ApiParam(value = "周次", required = true) @RequestParam String week) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20004.getCode())
            .message("获取教师该周课表")
            .data(teacherService.getCurriculum(tid, week))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 判断教师是否存在
   *
   * @param tid 教师编号
   * @author suwen
   * @date 2020/9/30 下午4:20
   */
  @GetMapping("/ifTeacher/{tid}")
  public ResponseEntity<ResultDto> ifTeacher(@PathVariable String tid) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(teacherService.getById(tid) != null)
            .code(ReturnCode.RETURN_CODE_20004.getCode())
            .message("检查用户是否存在")
            .build(),
        HttpStatus.OK);
  }
}
