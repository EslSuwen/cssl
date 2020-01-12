package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.Demo;
import com.cqjtu.cssl.service.TestFileService;
import com.cqjtu.cssl.utils.MessageQueryHelper;
import com.cqjtu.cssl.service.DemodataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 标明是controller的bean
@RestController
// 允许跨域访问。前端端口为4200。server端口为1230
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/demo")
public class DemoController {


    //  该注释告诉springboot，去帮助实现Repository接口。否则，抛空指针异常。
    @Autowired
    private DemodataRepository demodataRepository;

    //增加数据
    @PostMapping(value = "/newData")
    // Springboot将返回的类，以JSON字符串形式输出。这里使用Message model建立json格式数据
    public MessageQueryHelper addNewData(@RequestBody Demo demodata) {
        System.out.println("addNewData()被调用");
        MessageQueryHelper msg = new MessageQueryHelper();
        // save后自动添加id
        demodataRepository.save(demodata);
        msg.setMsg("The info of " + demodata.getName() + " has been added with the ID: " + demodata.getId());;
        return msg;
    }

    // 获取数据
    @GetMapping(value = "/getData")
    // 这里返回的是Iterable类型数据，为可迭代类型。可被循环访问
    public Iterable<Demo> getDemodatas() {

        System.out.println("getDemodatas()被调用");

        return demodataRepository.findAll();

    }

    // 删除数据
    @DeleteMapping(value = "/clearData")
    public MessageQueryHelper clearDemodatas() {
        System.out.println("clearDemodatas()被调用");
        demodataRepository.deleteAll();
        MessageQueryHelper msg = new MessageQueryHelper();
        msg.setMsg("The database has been cleared");
        return msg;
    }
}