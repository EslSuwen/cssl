package com.cqjtu.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqjtu.cssl.constant.ResultCode;
import com.cqjtu.cssl.dto.Result;
import com.cqjtu.cssl.entity.ExpClass;
import com.cqjtu.cssl.entity.ExpProject;
import com.cqjtu.cssl.service.ExpClassService;
import com.cqjtu.cssl.service.ExpProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目卡片控制器
 *
 * @author suwen
 * @date 2020/2/6 2:50 下午
 */
@Api(tags = "项目卡片-控制器")
@RestController
@RequestMapping("/project")
@Log4j2
public class ExpProjectController {

  private final ExpProjectService expProjectService;
  private ExpClassService expClassService;

  @Autowired
  public void setExpClassService(ExpClassService expClassService) {
    this.expClassService = expClassService;
  }

  @Autowired
  public ExpProjectController(ExpProjectService expProjectService) {
    this.expProjectService = expProjectService;
  }

  /**
   * 项目卡片增加
   *
   * @param expProject 请求体变量 项目卡片
   * @return pro
   * @author suwen
   * @date 2020/2/6 2:51 下午
   */
  @ApiOperation("项目卡片增加")
  @PostMapping("/addProject")
  public ResponseEntity<Result> addNewProject(@RequestBody ExpProject expProject) throws Exception {
    return new ResponseEntity<>(
        Result.builder()
            .success(expProjectService.addProject(expProject))
            .code(ResultCode.SUCCESS_ADD_DATA.getCode())
            .message("增加卡片成功")
            .data(
                expProjectService.getOne(
                    new QueryWrapper<ExpProject>()
                        .eq("exp_tid", expProject.getExpTid())
                        .eq("course_id", expProject.getCourseId())
                        .eq("term", expProject.getTerm())
                        .last("LIMIT 1")))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 项目班级增加
   *
   * @param expClassList 项目班级
   * @author suwen
   * @date 2020/2/6 2:51 下午
   */
  @ApiOperation("项目班级增加")
  @PostMapping("/addExpClass")
  public ResponseEntity<Result> addExpClass(@RequestBody List<ExpClass> expClassList) {
    return Result.successGet(expClassService.saveBatch(expClassList));
  }

  /**
   * 获取项目班级数据
   *
   * @param proId 项目编号
   * @return java.lang.Iterable<com.cqjtu.cssl.entity.Project>
   * @author suwen
   * @date 2020/10/6 2:52 下午
   */
  @ApiOperation("获取项目班级数据")
  @GetMapping("/getExpClass/{proId}")
  public ResponseEntity<Result> getExpClass(
      @ApiParam(value = "项目编号", required = true) @PathVariable Integer proId) {
    return Result.successGet(expClassService.getByProId(proId));
  }

  /**
   * 获取项目卡片数据
   *
   * @param tid 教师编号
   * @return java.lang.Iterable<com.cqjtu.cssl.entity.Project>
   * @author suwen
   * @date 2020/2/6 2:52 下午
   */
  @ApiOperation("获取项目卡片数据")
  @GetMapping("/getProject")
  public ResponseEntity<Result> getProjects(
      @ApiParam(value = "教师编号", required = true) @RequestParam String tid,
      @ApiParam(value = "学期", required = true) @RequestParam String term) {
    return Result.successGet(expProjectService.getByTidTerm(tid, term));
  }

  /**
   * 项目卡片删除
   *
   * @author suwen
   * @date 2020/2/6 2:53 下午
   */
  @ApiOperation("项目卡片删除")
  @DeleteMapping("/deleteProject")
  public ResponseEntity<Result> deleteProject(
      @ApiParam(value = "项目卡片编号", required = true) @RequestParam String proId) {
    return Result.success(expProjectService.removeById(proId), ResultCode.SUCCESS_DELETE_DATA);
  }

  /**
   * 获得存在学期列表
   *
   * @return 学期列表
   * @author suwen
   * @date 2020/6/1 下午10:06
   */
  @ApiOperation("获得存在学期列表")
  @GetMapping("/getTermList")
  public ResponseEntity<Result> getTermList() {
    return Result.successGet(expProjectService.getTermList());
  }

  /**
   * 重用以往卡片信息
   *
   * @param tid 教师编号
   * @param courseId 课程编号
   * @return 卡片信息
   * @author suwen
   * @date 2020/7/1 下午4:52
   */
  @ApiOperation("重用以往卡片信息")
  @GetMapping("/reuseCard")
  public ResponseEntity<Result> reuseCard(
      @ApiParam(value = "教师编号", required = true) @RequestParam String tid,
      @ApiParam(value = "课程编号", required = true) @RequestParam String courseId) {
    ExpProject project = expProjectService.reuseCard(tid, courseId);
    return new ResponseEntity<>(
        Result.builder()
            .success(project != null)
            .code(ResultCode.SUCCESS_GET_DATA.getCode())
            .message("重用以往卡片信息")
            .data(project)
            .build(),
        HttpStatus.OK);
  }

  /**
   * 更新卡片信息
   *
   * @param expProject 卡片信息
   * @return 成功（true）/ 失败 （false）
   * @author suwen
   * @date 2020/7/5 下午4:05
   */
  @ApiOperation("更新卡片信息")
  @PutMapping("/updateExp")
  public ResponseEntity<Result> updateExp(@RequestBody ExpProject expProject) {
    return Result.successUpdate(expProjectService.updateExp(expProject));
  }

  /**
   * 删除卡片信息
   *
   * @param proId 卡片编号
   * @return 成功（true）/ 失败 （false）
   * @author suwen
   * @date 2020/7/6 上午9:38
   */
  @ApiOperation("删除卡片信息")
  @DeleteMapping("/deleteExp")
  public ResponseEntity<Result> deleteExp(@RequestParam Integer proId) {
    return Result.successDelete(expProjectService.deleteExp(proId));
  }
}
