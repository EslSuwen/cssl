package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.constant.ResultCode;
import com.cqjtu.cssl.dto.ResultDto;
import com.cqjtu.cssl.entity.ProjectItem;
import com.cqjtu.cssl.service.ProjectItemService;
import io.swagger.annotations.Api;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
  @PostMapping(value = "/addProjectItems")
  public ResponseEntity<ResultDto> addNewProjectItem(
      @NonNull @RequestBody List<ProjectItem> projectItems) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(projectItemService.saveBatch(projectItems))
            .code(ResultCode.SUCCESS_ADD_DATA.getCode())
            .message("实验项目项增加成功")
            .build(),
        HttpStatus.OK);
  }

  /**
   * 获取实验项目
   *
   * @param proId 项目 id
   * @return java.lang.Iterable<com.cqjtu.cssl.entity.ProjectItem> 实验项目序列
   * @author suwen
   * @date 2020/2/6 2:55 下午
   */
  @GetMapping(value = "/getProjectItem/{proId}")
  public ResponseEntity<ResultDto> getProjectItem(@NonNull @PathVariable("proId") Integer proId) {

    @NonNull List<ProjectItem> projectItemList = projectItemService.listByProId(proId);
    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ResultCode.SUCCESS_GET_DATA.getCode())
            .message("实验项目项获取成功")
            .data(projectItemList)
            .build(),
        HttpStatus.OK);
  }

  /**
   * 更新实验项目
   *
   * @param projectItem 实验项目
   * @return 成功（true）/ 失败 （false）
   * @author suwen
   * @date 2020/7/5 下午4:08
   */
  @PutMapping("/updateItem")
  public ResponseEntity<ResultDto> updateItem(@RequestBody ProjectItem projectItem) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(projectItemService.updateItem(projectItem))
            .code(ResultCode.SUCCESS_UPDATE_DATA.getCode())
            .message("更新实验项目")
            .build(),
        HttpStatus.OK);
  }

  /**
   * 删除实验项目信息
   *
   * @param ino 实验项目编号
   * @return 成功（true）/ 失败 （false）
   * @author suwen
   * @date 2020/7/6 上午9:41
   */
  @DeleteMapping("deleteExp")
  public ResponseEntity<ResultDto> deleteExp(@RequestParam Integer ino) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(projectItemService.deleteItem(ino))
            .code(ResultCode.SUCCESS_DELETE_DATA.getCode())
            .message("删除实验项目信息")
            .build(),
        HttpStatus.OK);
  }
}
