package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.TestFile;
import com.cqjtu.cssl.service.TestFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 文件传输测试 controller
 *
 * @author: suwen
 * @time: 2020/2/6 2:42 下午
 */
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/file")
public class FileTestController {

    @Autowired
    private TestFileService testFileService;

    /**
     * 获取文件
     *
     * @return:
     * @author: suwen
     * @time: 2020/2/6 2:44 下午
     */
    @RequestMapping("/file")
    public void getFile(/*@RequestBody FileHelper[] file_from_sever*/) {

        System.out.println("getFile()被调用");

//        List<FileHelper> files=new ArrayList<>();
        System.out.println();

    }

    /**
     * 测试文件上传
     *
     * @param file
     * @throws IOException
     * @return: java.lang.String
     * @author: suwen
     * @time: 2020/2/6 2:45 下午
     */
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


        TestFile testFile = new TestFile(file.getOriginalFilename(), file.getBytes());


        testFileService.addFile(testFile);

//        testFileService.addUser();

        return "客户资料上传成功";
    }


    /**
     * 测试图片发送
     *
     * @param request 服务器请求
     * @param response 服务器响应
     * @return: java.lang.String
     * @author: suwen
     * @time: 2020/2/6 2:47 下午
     */
    @GetMapping("/getImage")
    public String getImage(HttpServletRequest request, HttpServletResponse response/*@RequestBody FileHelper[] file_from_sever*/) throws Exception {

        System.out.println("getImage()被调用");

        TestFile testFile = testFileService.get(28);
        byte[] bytes = testFile.getFile();

        //向浏览器发通知，我要发送是图片
        response.setContentType("image/jpeg");
        ServletOutputStream sos = response.getOutputStream();
        sos.write(bytes);
        sos.flush();
        sos.close();

        return null;

    }

}
