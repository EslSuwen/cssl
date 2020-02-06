package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.Project;
import com.cqjtu.cssl.service.ProjectService;
import com.cqjtu.cssl.utils.MessageQueryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 项目 controller
 *
 * @author: suwen
 * @time: 2020/2/6 2:50 下午
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     * 测试实验项目增加
     *
     * @param project 请求体变量 项目实体
     * @return: int 状态码
     * @author: suwen
     * @time: 2020/2/6 2:51 下午
     */
    @PostMapping(value = "/newProject")
    public int addNewProject(@RequestBody Project project) {

        System.out.println("addNewData()被调用");

        projectService.addProject(project);

        // save后自动添加id
        return 0;
    }

    /**
     * 测试获取实验项目数据
     *
     * @return: java.lang.Iterable<com.cqjtu.cssl.entity.Project>
     * @author: suwen
     * @time: 2020/2/6 2:52 下午
     */
    @GetMapping(value = "/getProject")
    public Iterable<Project> getProjects() {

        System.out.println("getDemodatas()被调用");

        return projectService.loadAll();

    }

    /**
     * 测试实验项目删除
     *
     * @author: suwen
     * @time: 2020/2/6 2:53 下午
     */
    @DeleteMapping(value = "/clearProject")
    public MessageQueryHelper clearDemodatas() {
        return null;
    }
}
