package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.ProjectItem;
import com.cqjtu.cssl.service.ProjectItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 实验项目控制器
 *
 * @author suwen
 * @date 2020/2/6 2:55 下午
 */
@RestController
@RequestMapping("/projectItem")
public class ProjectItemController {

  @Autowired private ProjectItemService projectItemService;

  /**
   * 测试实验项目项增加
   *
   * @param projectItem 请求体变量 实验项目
   * @return int 状态码
   * @author suwen
   * @date 2020/2/6 2:55 下午
   */
  @PostMapping(value = "/newProjectItem")
  public int addNewProjectItem(@RequestBody ProjectItem projectItem) {

    projectItemService.addProjectItem(projectItem);

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
  public Iterable<ProjectItem> getProjectItem(@PathVariable("proId") Integer proId) {

    System.out.println("proId = " + proId);
    if (proId == null) {
      proId = 1;
    }
    return projectItemService.findAllByProId(proId);
  }
}