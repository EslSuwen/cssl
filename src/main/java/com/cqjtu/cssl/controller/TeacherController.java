package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.constant.ResultCode;
import com.cqjtu.cssl.dto.Result;
import com.cqjtu.cssl.entity.Class;
import com.cqjtu.cssl.entity.Course;
import com.cqjtu.cssl.entity.Teacher;
import com.cqjtu.cssl.entity.TeacherMsg;
import com.cqjtu.cssl.service.ClassService;
import com.cqjtu.cssl.service.CourseService;
import com.cqjtu.cssl.service.TeacherMsgService;
import com.cqjtu.cssl.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
  private ClassService classService;
  private CourseService courseService;

  @Autowired
  public void setClassService(ClassService classService) {
    this.classService = classService;
  }

  @Autowired
  public void setCourseService(CourseService courseService) {
    this.courseService = courseService;
  }

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
  @ApiOperation("增加教师消息")
  @PostMapping("/addTeacherMsg")
  public ResponseEntity<Result> addTeacherMsg(
      @ApiParam(value = "增加教师消息", required = true) @RequestBody TeacherMsg teacherMsg) {
    return Result.successAdd(teacherMsgService.save(teacherMsg));
  }

  /**
   * 根据教师 id 获取教师信息
   *
   * @param tid 教师编号
   * @author suwen
   * @date 2020/3/23 16:45 下午
   * @return 教师信息
   */
  @ApiOperation("根据教师 id 获取教师信息")
  @GetMapping("/getTeacherInfo/{tid}")
  public ResponseEntity<Result> getTeacherInfo(
      @ApiParam(value = "教师编号", required = true) @PathVariable String tid) {
    return Result.successGet(teacherService.getById(tid));
  }

  /**
   * 根据教师 id 获取消息
   *
   * @param tid 教师编号
   * @author suwen
   * @date 2020/3/23 17:28 下午
   * @return 授课信息列表
   */
  @ApiOperation("根据教师 id 获取消息")
  @GetMapping("/getMsgInfo/{tid}")
  public ResponseEntity<Result> getMsgInfo(
      @ApiParam(value = "教师编号", required = true) @PathVariable String tid) {

    return new ResponseEntity<>(
        Result.builder()
            .success(true)
            .code(ResultCode.SUCCESS_GET_DATA.getCode())
            .message("获取教师信息成功")
            .data(teacherMsgService.getMsgListByTid(tid))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 根据消息 id 已读消息
   *
   * @param mid 消息编号
   * @author suwen
   * @date 2020/3/24 12:28 下午
   */
  @ApiOperation("根据消息 id 已读消息")
  @PutMapping("/readMsg/{mid}")
  public ResponseEntity<Result> readMsg(
      @ApiParam(value = "消息编号", required = true) @PathVariable String mid) {
    TeacherMsg teacherMsg = teacherMsgService.getById(mid);
    teacherMsg.setMstatus(1);
    return Result.successUpdate(teacherMsgService.updateById(teacherMsg));
  }

  /**
   * 根据消息 id 删除消息
   *
   * @param mid 消息编号
   * @author suwen
   * @date 2020/3/24 12:28 下午
   */
  @ApiOperation("根据消息 id 删除消息")
  @GetMapping("/deleteMsg/{mid}")
  public ResponseEntity<Result> deleteMsg(
      @ApiParam(value = "消息编号", required = true) @PathVariable String mid) {
    return Result.successDelete(teacherMsgService.removeById(mid));
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
  @ApiOperation("用户修改密码")
  @PutMapping("/updatePassword")
  public ResponseEntity<Result> updatePassword(
      @ApiParam(value = "教师编号", required = true) @RequestParam String tid,
      @ApiParam(value = "当前密码", required = true) @RequestParam String oldPw,
      @ApiParam(value = "新密码", required = true) @RequestParam String newPw) {
    return Result.successUpdate(teacherService.updatePassword(tid, oldPw, newPw));
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
  @ApiOperation("获取教师某周课表")
  @GetMapping("/getCurriculum")
  public ResponseEntity<Result> getCurriculum(
      @ApiParam(value = "教师编号", required = true) @RequestParam String tid,
      @ApiParam(value = "周次", required = true) @RequestParam String week) {
    return Result.successGet(teacherService.getCurriculum(tid, week));
  }

  /**
   * 判断教师是否存在
   *
   * @param tid 教师编号
   * @author suwen
   * @date 2020/9/30 下午4:20
   */
  @ApiOperation("判断教师是否存在")
  @GetMapping("/ifTeacher/{tid}")
  public ResponseEntity<Result> ifTeacher(
      @ApiParam(value = "教师编号", required = true) @PathVariable String tid) {
    return new ResponseEntity<>(
        Result.builder()
            .success(teacherService.getById(tid) != null)
            .code(ResultCode.SUCCESS_GET_DATA.getCode())
            .message("检查用户是否存在")
            .build(),
        HttpStatus.OK);
  }

  /**
   * 判断班级是否存在
   *
   * @param classId 班级编号
   * @author suwen
   * @date 2020/9/30 下午7:39
   */
  @ApiOperation("判断班级是否存在")
  @GetMapping("/ifClass/{classId}")
  public ResponseEntity<Result> ifClass(
      @ApiParam(value = "班级编号", required = true) @PathVariable String classId) {
    return new ResponseEntity<>(
        Result.builder()
            .success(classService.getById(classId) != null)
            .code(ResultCode.SUCCESS_GET_DATA.getCode())
            .message("检查班级是否存在")
            .build(),
        HttpStatus.OK);
  }

  /**
   * 判断课程是否存在
   *
   * @param courseId 课程编号
   * @author suwen
   * @date 2020/9/30 下午7:39
   */
  @ApiOperation("判断课程是否存在")
  @GetMapping("/ifCurriculum/{courseId}")
  public ResponseEntity<Result> ifCurriculum(
      @ApiParam(value = "课程编号", required = true) @PathVariable String courseId) {
    return new ResponseEntity<>(
        Result.builder()
            .success(courseService.getById(courseId) != null)
            .code(ResultCode.SUCCESS_GET_DATA.getCode())
            .message("检查课程是否存在")
            .build(),
        HttpStatus.OK);
  }

  /**
   * 增加教师
   *
   * @param teacher 教师
   * @author suwen
   * @date 2020/10/2 上午9:28
   */
  @ApiOperation("增加教师")
  @PostMapping("/addTeacher")
  public ResponseEntity<Result> addTeacher(
      @ApiParam(value = "教师", required = true) @RequestBody Teacher teacher) {
    teacher.setTpassword(new BCryptPasswordEncoder().encode(teacher.getTpassword()));
    return Result.successAdd(teacherService.save(teacher));
  }

  /**
   * 增加班级
   *
   * @param newClass 班级
   * @author suwen
   * @date 2020/10/2 上午9:28
   */
  @ApiOperation("增加班级")
  @PostMapping("/addClass")
  public ResponseEntity<Result> addClass(
      @ApiParam(value = "班级", required = true) @RequestBody Class newClass) {
    return Result.successAdd(classService.save(newClass));
  }

  /**
   * 增加课程
   *
   * @param course 课程
   * @author suwen
   * @date 2020/10/2 上午9:28
   */
  @ApiOperation("增加课程")
  @PostMapping("/addCurriculum")
  public ResponseEntity<Result> addCurriculum(
      @ApiParam(value = "课程", required = true) @RequestBody Course course) {
    return Result.successAdd(courseService.save(course));
  }

  /**
   * 获取所有教师信息
   *
   * @author suwen
   * @date 2020/10/2 上午10:30
   */
  @ApiOperation("获取所有教师信息")
  @GetMapping("/getTeacher")
  public ResponseEntity<Result> getTeacher() {
    return Result.successGet(teacherService.list());
  }

  /**
   * 获取所有班级信息
   *
   * @author suwen
   * @date 2020/10/2 上午10:32
   */
  @ApiOperation("获取所有班级信息")
  @GetMapping("/getClass")
  public ResponseEntity<Result> getClasses() {
    return Result.successGet(classService.list());
  }

  /**
   * 获取所有课程信息
   *
   * @author suwen
   * @date 2020/10/2 上午10:30
   */
  @ApiOperation("获取所有课程信息")
  @GetMapping("/getCourse")
  public ResponseEntity<Result> getCourse() {
    return Result.successGet(courseService.list());
  }

  /**
   * 更新教师信息
   *
   * @param teacher 教师信息
   * @author suwen
   * @date 2020/10/2 上午10:30
   */
  @ApiOperation("更新教师信息")
  @PutMapping("/updateTeacher")
  public ResponseEntity<Result> updateTeacher(
      @ApiParam(value = "教师信息", required = true) @RequestBody Teacher teacher) {
    return Result.successUpdate(teacherService.updateById(teacher));
  }

  /**
   * 更新班级信息
   *
   * @param newClass 班级信息
   * @author suwen
   * @date 2020/10/2 上午10:30
   */
  @ApiOperation("更新班级信息")
  @PutMapping("/updateClass")
  public ResponseEntity<Result> updateClass(
      @ApiParam(value = "班级信息", required = true) @RequestBody Class newClass) {
    return Result.successUpdate(classService.updateById(newClass));
  }

  /**
   * 更新课程信息
   *
   * @param course 课程信息
   * @author suwen
   * @date 2020/10/2 上午10:30
   */
  @ApiOperation("更新课程信息")
  @PutMapping("/updateCourse")
  public ResponseEntity<Result> updateCourse(
      @ApiParam(value = "课程信息", required = true) @RequestBody Course course) {
    return Result.successUpdate(courseService.updateById(course));
  }

  /**
   * 删除教师信息
   *
   * @param tid 教师编号
   */
  @ApiOperation("删除教师信息")
  @DeleteMapping("/removeTeacher/{tid}")
  public ResponseEntity<Result> removeTeacher(
      @ApiParam(value = "教师编号", required = true) @PathVariable String tid) {
    return Result.successDelete(teacherService.removeById(tid));
  }

  /**
   * 删除班级信息
   *
   * @param classId 班级编号
   */
  @ApiOperation("删除班级信息")
  @DeleteMapping("/removeClass/{classId}")
  public ResponseEntity<Result> removeClass(
      @ApiParam(value = "班级编号", required = true) @PathVariable Integer classId) {
    return Result.successDelete(classService.removeById(classId));
  }

  /**
   * 删除课程信息
   *
   * @param courseId 课程编号
   */
  @ApiOperation("删除课程信息")
  @DeleteMapping("/removeCourse/{courseId}")
  public ResponseEntity<Result> removeCourse(
      @ApiParam(value = "课程编号", required = true) @PathVariable Integer courseId) {
    return Result.successDelete(courseService.removeById(courseId));
  }
}
