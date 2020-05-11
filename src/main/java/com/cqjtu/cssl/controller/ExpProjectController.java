package com.cqjtu.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqjtu.cssl.entity.ExpProject;
import com.cqjtu.cssl.entity.Message;
import com.cqjtu.cssl.service.ExpProjectService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
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
@Log4j2
public class ExpProjectController {

  private final ExpProjectService expProjectService;

  @Autowired
  public ExpProjectController(ExpProjectService expProjectService) {
    this.expProjectService = expProjectService;
  }

  /**
   * 项目卡片增加
   *
   * @param expProject 请求体变量 项目卡片
   * @return int 状态码
   * @author suwen
   * @date 2020/2/6 2:51 下午
   */
  @PostMapping(value = "/addProject")
  public int addNewProject(@RequestBody ExpProject expProject) {

    if (expProjectService.isCardExist(expProject.getExpTid(), expProject.getCourseId())) {
      return -1;
    }
    expProject.setLabCenName("信息技术实践教学中心");
    expProjectService.save(expProject);

    return expProjectService
        .getExpByTidCid(expProject.getExpTid(), expProject.getCourseId())
        .getProId();
  }

  /**
   * 获取项目卡片数据
   *
   * @return java.lang.Iterable<com.cqjtu.cssl.entity.Project>
   * @author suwen
   * @date 2020/2/6 2:52 下午
   */
  @GetMapping(value = "/getProject/{tid}")
  public List<ExpProject> getProjects(@PathVariable String tid) {

    return expProjectService.list(new QueryWrapper<ExpProject>().eq("exp_tid", tid));
  }

  /**
   * 获取待审核项目卡片数据
   *
   * @return java.lang.Iterable<com.cqjtu.cssl.entity.Project>
   * @author suwen
   * @date 2020/5/10 11:14 上午
   */
  @GetMapping(value = "/getAuditProject")
  public List<ExpProject> getAuditProjects() {

    return expProjectService.list(new QueryWrapper<ExpProject>().eq("lab_status", 0));
  }

  /**
   * 审核项目卡片
   *
   * @return java.lang.Iterable<com.cqjtu.cssl.entity.Project>
   * @author suwen
   * @date 2020/5/10 11:24 上午
   */
  @GetMapping(value = "/auditProject")
  public boolean auditProject(@RequestParam String proId, @RequestParam Integer status) {

    return expProjectService.auditProject(proId, status);
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
