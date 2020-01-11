package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.User;
import com.cqjtu.cssl.service.UserService;
import com.cqjtu.cssl.utils.MessageQueryHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;

// 标明是controller的bean
@RestController
// 允许跨域访问。前端端口为4200。server端口为8090
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/test_user")
public class UserTestController {

    @Autowired
    private UserService userService;

    /**
     * 测试用户增加
     */
    //    @CrossOrigin
    //增加数据
    @PostMapping(value = "/newUser")
    // Springboot将返回的类，以JSON字符串形式输出。这里使用Message model建立json格式数据
    public MessageQueryHelper addNewData(@RequestBody User user) {
        System.out.println("addNewData()被调用");
        MessageQueryHelper msg = new MessageQueryHelper();
        // save后自动添加id
        userService.addUser(user);
        msg.setMsg("The info of " + user.getUserName() + " has been added with the ID: " + user.getUserNo());
        ;
        return msg;
    }

    // 获取数据
    @GetMapping(value = "/getUser")
    // 这里返回的是Iterable类型数据，为可迭代类型。可被循环访问
    public Iterable<User> getUsers() {

        System.out.println("getDemodatas()被调用");

        return userService.loadAll();

    }

    // 删除数据
    @DeleteMapping(value = "/clearUser")
    public MessageQueryHelper clearDemodatas() {
        System.out.println("clearDemodatas()被调用");
        List<User> userList = userService.loadAll();
        for (User user : userList) {
            userService.removeUser(Integer.parseInt(user.getUserNo()));
        }
        MessageQueryHelper msg = new MessageQueryHelper();
        msg.setMsg("The database has been cleared");
        return msg;
    }
}
