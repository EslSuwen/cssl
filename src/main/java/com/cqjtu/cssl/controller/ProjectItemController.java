package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.ProjectItem;
import com.cqjtu.cssl.service.ProjectItemService;
import io.swagger.annotations.Api;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * (项目卡片)实验项目控制器
 *
 * @author suwen
 * @date 2020/2/6 2:55 下午
 */
@Api(tags = "(项目卡片)实验项目-控制器")
@RestController
@RequestMapping("/projectItem")
public class ProjectItemController {

  private final ProjectItemService projectItemService;

  @Autowired
  public ProjectItemController(ProjectItemService projectItemService) {
    this.projectItemService = projectItemService;
  }

  /**
   * 测试实验项目项增加
   *
   * @param projectItems 请求体变量 实验项目
   * @return int 状态码
   * @author suwen
   * @date 2020/2/6 2:55 下午
   */
  @PostMapping(value = "/addProjectItems")
  public int addNewProjectItem(@RequestBody List<ProjectItem> projectItems) {

    projectItemService.saveBatch(projectItems);

    return 0;
  }

  /**
   * 测试获取实验项目
   *
   * @param proId 项目 id
   * @return java.lang.Iterable<com.cqjtu.cssl.entity.ProjectItem> 实验项目序列
   * @author suwen
   * @date 2020/2/6 2:55 下午
   */
  @GetMapping(value = "/getProjectItem/{proId}")
  public List<ProjectItem> getProjectItem(@NonNull @PathVariable("proId") Integer proId) {

    return projectItemService.listByProId(proId);
  }
}
