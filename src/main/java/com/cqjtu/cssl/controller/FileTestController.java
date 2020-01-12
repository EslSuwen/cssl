package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.config.CorsConfig;
import com.cqjtu.cssl.entity.TestFile;
import com.cqjtu.cssl.entity.User;
import com.cqjtu.cssl.service.TestFileService;
import com.cqjtu.cssl.service.UserService;
import com.cqjtu.cssl.utils.FileHelper;
import com.cqjtu.cssl.utils.MessageQueryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 标明是controller的bean
@RestController
// 允许跨域访问。前端端口为4200。server端口为8090
//@CrossOrigin(origins = "http://localhost:4200")
public class FileTestController extends CorsConfig {


    @Autowired
    private TestFileService testFileService;

    // 获取数据
    @RequestMapping("/file")
    // 这里返回的是Iterable类型数据，为可迭代类型。可被循环访问
    public void getFile(/*@RequestBody FileHelper[] file_from_sever*/) {

        System.out.println("getFile()被调用");

//        List<FileHelper> files=new ArrayList<>();
        System.out.println();

    }

    @CrossOrigin
    @PostMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
//        System.out.println("后台文件上传函数");
        System.out.println("获取到的文件名称为：" + file);
        String filePath = file.getOriginalFilename(); // 获取文件的名称
//        filePath = "G:/" + filePath; // 这是文件的保存路径，如果不设置就会保存到项目的根目录

//        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
//
//        outputStream.write(file.getBytes());
//        outputStream.flush();
//        outputStream.close();


        TestFile testFile=new TestFile (file.getOriginalFilename(),file.getBytes());


        testFileService.addFile(testFile);

        testFileService.addUser();

        return "客户资料上传成功";
    }

}
