package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.Project;
import com.cqjtu.cssl.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 标明是controller的bean
@RestController
// 允许跨域访问。前端端口为4200。server端口为8090
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     * 测试实验项目增加
     */
    //    @CrossOrigin
    @PostMapping(value = "/newProject")
    // Springboot将返回的类，以JSON字符串形式输出。这里使用Message model建立json格式数据
    public int addNewProject(@RequestBody Project project) {

        System.out.println("addNewData()被调用");

        projectService.addProject(project);

        // save后自动添加id
        return 0;
    }

    /**
     * 测试实验项目数据
     */
    @GetMapping(value = "/getProject")
    // 这里返回的是Iterable类型数据，为可迭代类型。可被循环访问
    public Iterable<Project> getProjects() {

        System.out.println("getDemodatas()被调用");

        return projectService.loadAll();

    }

    /**
     * 测试实验项目删除
     */
    /*@DeleteMapping(value = "/clearProject")
    public MessageQueryHelper clearDemodatas() {
        System.out.println("clearDemodatas()被调用");
        List<User> userList = userService.loadAll();
        for (User user : userList) {
            userService.removeUser(Integer.parseInt(user.getUserNo()));
        }
        MessageQueryHelper msg = new MessageQueryHelper();
        msg.setMsg("The database has been cleared");
        return msg;
    }*/
}
