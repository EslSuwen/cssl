package com.cqjtu.cssl.controller;

import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 项目资料控制器
 *
 * @author suwen
 * @date 2020/7/7 上午9:42
 */
@RequestMapping("/expFile")
@Api(tags = "项目资料-控制器")
@RestController
@Log4j2
public class ExpFileController {

  /** 新建页面添加数据 使用MultipartFile接口接收前台传的file（文件），其他的参数用实体类接收就可以了 */
  @PostMapping("/addTest")
  @ResponseBody
  public int addTest(@RequestParam("file") MultipartFile file) throws IOException {
    if (file.isEmpty()) {
      log.error("file为空");
    }
    // 使用时间给上传的文件命名，这种方式没有用uuid命名好，因为同一时间有可能会上传多个文件
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
    String res = sdf.format(new Date());
    String originalFilename = file.getOriginalFilename();
    // 获取文件的后缀名
    assert originalFilename != null;
    String newFileName = res + originalFilename.substring(originalFilename.lastIndexOf("."));
    String rootPath = "/images/";
    File newFile = new File(rootPath + newFileName);
    System.out.println(rootPath + newFileName);
    // 定义向数据库中存取的文件路径
    String src = rootPath + newFileName;
    if (!newFile.getParentFile().exists()) {
      newFile.getParentFile().mkdirs();
    } else {
      log.info(newFile.getParentFile());
    }
    if (!newFile.exists()) {
      // 使用transferTo()方法将文件存到所在服务器上
      file.transferTo(newFile);
    }
    return 0;
  }
}
