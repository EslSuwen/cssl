package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.ProjectItem;
import com.cqjtu.cssl.service.ProjectItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 标明是controller的bean
@RestController
// 允许跨域访问。前端端口为4200。server端口为8090
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/projectItem")
public class ProjectItemController {

    @Autowired
    private ProjectItemService projectItemService;

    /**
     * 测试实验项目项增加
     */
    @PostMapping(value = "/newProjectItem")
    // Springboot将返回的类，以JSON字符串形式输出。这里使用Message model建立json格式数据
    public int addNewProjectItem(@RequestBody ProjectItem projectItem) {

        projectItemService.addProjectItem(projectItem);

        return 0;
    }

    /**
     * 测试实验项目项
     */
    @GetMapping(value = "/getProjectItem")
    // 这里返回的是Iterable类型数据，为可迭代类型。可被循环访问
    public Iterable<ProjectItem> getProjectItem(@RequestBody Integer proId/*, @RequestParam(value = "proId", required = false, defaultValue = "1") Integer Id*/) {

        return projectItemService.findAllByProId(proId);

    }

}
