package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.dto.Result;
import com.cqjtu.cssl.entity.ProjectItem;
import com.cqjtu.cssl.service.ProjectItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (项目卡片)实验项目控制器
 *
 * @author suwen
 * @date 2020/2/6 2:55 下午
 */
@Api(tags = "实验项目-控制器")
@RestController
@RequestMapping("/projectItem")
public class ProjectItemController {

  private final ProjectItemService projectItemService;

  @Autowired
  public ProjectItemController(ProjectItemService projectItemService) {
    this.projectItemService = projectItemService;
  }

  /**
   * 实验项目项增加
   *
   * @param projectItems 请求体变量 实验项目
   * @return int 状态码
   * @author suwen
   * @date 2020/2/6 2:55 下午
   */
  @ApiOperation("实验项目项增加")
  @PostMapping("/addProjectItems")
  public ResponseEntity<Result> addNewProjectItem(
      @ApiParam(value = "实验项目", required = true) @RequestBody List<ProjectItem> projectItems) {
    return Result.successAdd(projectItemService.saveBatch(projectItems));
  }

  /**
   * 获取实验项目
   *
   * @param proId 项目 id
   * @return java.lang.Iterable<com.cqjtu.cssl.entity.ProjectItem> 实验项目序列
   * @author suwen
   * @date 2020/2/6 2:55 下午
   */
  @ApiOperation("获取实验项目")
  @GetMapping("/getProjectItem/{proId}")
  public ResponseEntity<Result> getProjectItem(
      @ApiParam(value = "项目编号", required = true) @PathVariable("proId") Integer proId) {
    return Result.successGet(projectItemService.listByProId(proId));
  }

  /**
   * 更新实验项目
   *
   * @param projectItem 实验项目
   * @return 成功（true）/ 失败 （false）
   * @author suwen
   * @date 2020/7/5 下午4:08
   */
  @ApiOperation("更新实验项目")
  @PutMapping("/updateItem")
  public ResponseEntity<Result> updateItem(
      @ApiParam(value = "实验项目", required = true) @RequestBody ProjectItem projectItem) {
    return Result.successUpdate(projectItemService.updateItem(projectItem));
  }

  /**
   * 删除实验项目信息
   *
   * @param ino 实验项目编号
   * @return 成功（true）/ 失败 （false）
   * @author suwen
   * @date 2020/7/6 上午9:41
   */
  @ApiOperation("删除实验项目信息")
  @DeleteMapping("/deleteExp")
  public ResponseEntity<Result> deleteExp(
      @ApiParam(value = "实验项目编号", required = true) @RequestParam Integer ino) {
    return Result.successDelete(projectItemService.deleteItem(ino));
  }
}
