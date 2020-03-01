package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.ExpProject;
import com.cqjtu.cssl.entity.Message;
import com.cqjtu.cssl.service.ExpProjectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ExpProjectController {

  private final ExpProjectService expProjectService;

  @Autowired
  public ExpProjectController(ExpProjectService expProjectService) {
    this.expProjectService = expProjectService;
  }

  /**
   * 测试项目卡片增加
   *
   * @param expProject 请求体变量 项目卡片
   * @return int 状态码
   * @author suwen
   * @date 2020/2/6 2:51 下午
   */
  @PostMapping(value = "/newProject")
  public int addNewProject(@RequestBody ExpProject expProject) {

    System.out.println("addNewData()被调用");

    expProjectService.addProject(expProject);

    // save后自动添加id
    return 0;
  }

  /**
   * 测试获取项目卡片数据
   *
   * @return java.lang.Iterable<com.cqjtu.cssl.entity.Project>
   * @author suwen
   * @date 2020/2/6 2:52 下午
   */
  @GetMapping(value = "/getProject")
  public List<ExpProject> getProjects() {

    System.out.println("getProjects()被调用");

    return expProjectService.loadAll();
  }

  /**
   * 测试项目卡片删除
   *
   * @author suwen
   * @date 2020/2/6 2:53 下午
   */
  @DeleteMapping(value = "/clearProject")
  public Message clearProject() {
    System.out.println("clearProject()被调用");

    Message msg = new Message();
    msg.setMsg("clearProject()被调用");

    return msg;
  }
}
