package com.cqjtu.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqjtu.cssl.constant.ReturnCode;
import com.cqjtu.cssl.dto.ResultDto;
import com.cqjtu.cssl.entity.ExpFileStore;
import com.cqjtu.cssl.service.ExpFileService;
import com.cqjtu.cssl.service.ExpFileStoreService;
import com.cqjtu.cssl.service.TestFileService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件传输测试控制器
 *
 * @author suwen
 * @date 2020/2/6 2:42 下午
 */
@Api(tags = "文件传输测试-控制器")
@RestController
@Log4j2
@RequestMapping(path = "/file")
public class FileTestController {

  private final TestFileService testFileService;
  private final ExpFileService expFileService;
  private final ExpFileStoreService expFileStoreService;

  @Autowired
  public FileTestController(
      TestFileService testFileService,
      ExpFileService expFileService,
      ExpFileStoreService expFileStoreService) {
    this.testFileService = testFileService;
    this.expFileService = expFileService;
    this.expFileStoreService = expFileStoreService;
  }

  @Autowired

  /**
   * 获取文件
   *
   * @author suwen
   * @date 2020/2/6 2:44 下午
   */
  @GetMapping("/file")
  public void getFile(/*@RequestBody FileHelper[] file_from_sever*/ ) {

    //    System.out.println("getFile()被调用");

    //        List<FileHelper> files=new ArrayList<>();
    System.out.println();
  }

  /**
   * 测试文件上传
   *
   * @param file 文件
   * @throws IOException 文件为空
   * @return java.lang.String
   * @author suwen
   * @date 2020/2/6 2:45 下午
   */
  @PostMapping(value = "/upload")
  public ResponseEntity<ResultDto> upload(
      @RequestParam("file") MultipartFile file,
      @RequestParam("proId") String proId,
      @RequestParam("typeName") String typeName)
      throws IOException {
    log.info("后台文件上传函数");
    log.info(proId);
    log.info(typeName);
    log.info("获取到的文件名称为：" + file.getOriginalFilename());
    // 获取文件的名称
    String filePath = file.getOriginalFilename();

    assert filePath != null;
    BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));

    outputStream.write(file.getBytes());
    outputStream.flush();
    outputStream.close();

    ExpFileStore expFileStore =
        ExpFileStore.builder()
            .proId(Integer.valueOf(proId))
            .file(file.getBytes())
            .name(file.getOriginalFilename())
            .typeName(typeName)
            .build();

    log.info(expFileStore);
    expFileStoreService.save(expFileStore);

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20007.getCode())
            .message("资料上传成功")
            .build(),
        HttpStatus.OK);
  }

  /**
   * 测试图片发送
   *
   * @param request 服务器请求
   * @param response 服务器响应
   * @author suwen
   * @date 2020/2/6 2:47 下午
   */
  @GetMapping("/getImage")
  public void getImage(
      HttpServletRequest request,
      HttpServletResponse response /*@RequestBody FileHelper[] file_from_sever*/)
      throws Exception {

    byte[] bytes =
        expFileStoreService.getOne(new QueryWrapper<ExpFileStore>().last("LIMIT 1")).getFile();

    // 向浏览器发通知，我要发送是图片
    response.setContentType("image/jpeg");
    ServletOutputStream sos = response.getOutputStream();
    sos.write(bytes);
    sos.flush();
    sos.close();
  }
}
