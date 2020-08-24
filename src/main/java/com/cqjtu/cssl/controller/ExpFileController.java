package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.constant.ReturnCode;
import com.cqjtu.cssl.dto.ResultDto;
import com.cqjtu.cssl.entity.ExpFile;
import com.cqjtu.cssl.entity.ExpFileStore;
import com.cqjtu.cssl.service.ExpFileService;
import com.cqjtu.cssl.service.ExpFileStoreService;
import com.cqjtu.cssl.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 项目资料控制器
 *
 * <p>TODO 重构：文件存在磁盘上
 *
 * @author suwen
 * @date 2020/7/7 上午9:42
 */
@RequestMapping("/expFile")
@Api(tags = "项目资料-控制器")
@RestController
@Log4j2
public class ExpFileController {

  private final ExpFileService expFileService;
  private final ExpFileStoreService expFileStoreService;
  private final FileService fileService;

  @Autowired
  public ExpFileController(
      ExpFileService expFileService,
      ExpFileStoreService expFileStoreService,
      FileService fileService) {
    this.expFileService = expFileService;
    this.expFileStoreService = expFileStoreService;
    this.fileService = fileService;
  }

  /**
   * 获得文件状态
   *
   * @param proId 项目卡片编号
   * @return 文件状态
   * @author suwen
   * @date 2020/7/8 上午9:20
   */
  @GetMapping("/getFileStatus")
  public ResponseEntity<ResultDto> getFileStatus(@RequestParam("proId") Integer proId) {

    ExpFile expFile = expFileService.getById(proId);
    List<ExpFileStore> expFileStoreList = expFileStoreService.getQuickFile(proId);
    if (!expFileStoreList.isEmpty()) {
      expFile.setFiles(expFileStoreList);
    }

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .message("获得文件状态成功")
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .data(expFile)
            .build(),
        HttpStatus.OK);
  }

  /**
   * 增加项目实验文件
   *
   * @param file 文件
   * @param proId 项目编号
   * @param typeName 文件类型名
   * @return 执行结果
   * @author suwen
   * @date 2020/7/8 上午10:16
   */
  @PostMapping("/addExpFile")
  public ResponseEntity<ResultDto> addExpFile(
      @RequestParam("file") MultipartFile file,
      @RequestParam("proId") String proId,
      @RequestParam("typeName") String typeName)
      throws Exception {

    ExpFileStore expFileStore =
        ExpFileStore.builder()
            .proId(Integer.valueOf(proId))
            .file(file.getBytes())
            .name(file.getOriginalFilename())
            .typeName(typeName)
            .build();

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(expFileStoreService.saveFile(expFileStore))
            .code(ReturnCode.RETURN_CODE_20007.getCode())
            .message("文件上传成功")
            .build(),
        HttpStatus.OK);
  }

  /**
   * 获取文件储存信息除文件
   *
   * @param proId 卡片编号
   * @return 件储存信息
   * @author suwen
   * @date 2020/7/8 下午1:38
   */
  @GetMapping("/getQuickFile")
  public ResponseEntity<ResultDto> getQuickFile(@RequestParam("proId") Integer proId) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .message("获取文件储存信息成功")
            .data(expFileStoreService.getQuickFile(proId))
            .build(),
        HttpStatus.OK);
  }

  @GetMapping("/getFile")
  public void getFileDownload(@RequestParam("no") Integer fileNo, HttpServletResponse response) {
    try {
      ExpFileStore expFileStore = expFileStoreService.getById(fileNo);
      byte[] bytes = expFileStore.getFile();

      // 清空response
      response.reset();
      // 设置response的Header
      response.setCharacterEncoding("utf-8");
      response.setContentType("multipart/form-data");
      response.setHeader(
          "Content-disposition",
          "attachment; filename="
              + new String((expFileStore.getName()).getBytes(), StandardCharsets.ISO_8859_1));
      OutputStream os = new BufferedOutputStream(response.getOutputStream());
      ServletOutputStream sos = response.getOutputStream();

      // 将excel写入到输出流中
      sos.write(bytes);
      sos.flush();
      sos.close();
      log.info("设置浏览器下载成功！");
    } catch (Exception e) {
      log.info("设置浏览器下载失败！");
      e.printStackTrace();
    }
  }

  @ApiOperation(value = "上传文件")
  @PostMapping("/file/upload")
  public ResponseEntity<File> uploadFile(
      @ApiParam(name = "file", value = "待上传文件", required = true) @RequestPart(name = "file")
          MultipartFile multipartFile)
      throws IOException {
    String fileName = fileService.storeFile(multipartFile);
    File file = fileService.loadFileAsResource(fileName).getFile();
    return new ResponseEntity<>(file, HttpStatus.CREATED);
  }
}
