package com.cqjtu.cssl.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileReader;
import com.cqjtu.cssl.constant.ResultCode;
import com.cqjtu.cssl.dto.Result;
import com.cqjtu.cssl.entity.NoticeFile;
import com.cqjtu.cssl.service.NoticeFileService;
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
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * 通知文件 前端控制器
 *
 * @author suwen
 * @since 2020-08-28
 */
@Api(tags = "通知文件-控制器")
@Log4j2
@RestController
@RequestMapping("/noticeFile")
public class NoticeFileController {

  private final NoticeFileService noticeFileService;
  private final String DEFAULT_PATH = System.getProperty("user.dir");
  private final String FILE_PREFIX = "/CSSL_FILES/noticeFile/";

  @Autowired
  public NoticeFileController(NoticeFileService noticeFileService) {
    this.noticeFileService = noticeFileService;
  }

  /**
   * 增加通知文件
   *
   * @param noticeFile 通知文件
   * @author suwen
   * @date 2020/8/28 上午11:01
   */
  @ApiOperation("增加通知文件")
  @PostMapping("/add")
  public ResponseEntity<Result> add(
      @ApiParam(value = "通知文件信息", required = true) NoticeFile noticeFile,
      @ApiParam(value = "通知文件内容", required = true) @RequestParam MultipartFile nFile)
      throws IOException {

    log.info(noticeFile);
    log.info(nFile);

    if (!nFile.isEmpty()) {
      String fileName = nFile.getOriginalFilename();
      String targetPath = DEFAULT_PATH + FILE_PREFIX + fileName;
      noticeFile.setFilePath(FILE_PREFIX + fileName);
      InputStream in = nFile.getInputStream();
      BufferedOutputStream out = FileUtil.getOutputStream(new File(targetPath));
      IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
      IoUtil.close(in);
      IoUtil.close(out);
    }
    return new ResponseEntity<>(
        Result.builder()
            .success(noticeFileService.save(noticeFile))
            .code(ResultCode.SUCCESS_UPLOAD_DATA.getCode())
            .message("通知文件" + ResultCode.SUCCESS_UPLOAD_DATA.getMessage())
            .build(),
        HttpStatus.CREATED);
  }

  /**
   * 获取通知文件列表
   *
   * @author suwen
   * @date 2020/8/28 上午11:03
   */
  @ApiOperation("获取通知文件列表")
  @GetMapping("/getAll")
  public ResponseEntity<Result> getAll() {
    return Result.successGet(noticeFileService.list());
  }

  /**
   * 通过编号获取通知文件详细
   *
   * @param id 编号
   * @author suwen
   * @date 2020/8/28 上午11:03
   */
  @ApiOperation("通过编号获取通知文件详细")
  @GetMapping("/getById/{id}")
  public ResponseEntity<Result> getById(
      @ApiParam(value = "通知文件编号", required = true) @PathVariable Integer id) {
    return Result.successGet(noticeFileService.getById(id));
  }

  /**
   * 通过编号删除通知文件
   *
   * @param id 编号
   * @author suwen
   * @date 2020/8/28 上午11:03
   */
  @ApiOperation("通过编号删除通知文件")
  @DeleteMapping("/remove/{id}")
  public ResponseEntity<Result> remove(
      @ApiParam(value = "通知文件编号", required = true) @PathVariable Integer id) {
    return Result.successDelete(noticeFileService.removeById(id));
  }

  /**
   * 文件下载
   *
   * @param fileId 文件编号
   * @author suwen
   * @date 2020/8/30 上午10:42
   */
  @ApiOperation("文件下载")
  @GetMapping("/getFile/{fileId}")
  public void getFileDownload(
      @ApiParam(value = "通知文件编号", required = true) @PathVariable Integer fileId,
      HttpServletResponse response) {
    NoticeFile noticeFile = noticeFileService.getById(fileId);
    String fileName = noticeFile.getFileName();
    String filePath = DEFAULT_PATH + noticeFile.getFilePath();
    log.info("fileName: " + filePath);
    try {
      FileReader fileReader = new FileReader(filePath);
      response.reset();
      response.setCharacterEncoding("utf-8");
      response.setContentType("multipart/form-data");
      response.setHeader(
          "Content-disposition",
          "attachment; filename=" + new String(fileName.getBytes(), StandardCharsets.ISO_8859_1));
      ServletOutputStream sos = response.getOutputStream();

      sos.write(fileReader.readBytes());
      sos.flush();
      sos.close();
      log.info(fileName + "设置浏览器下载成功！");
    } catch (Exception e) {
      log.info(fileName + "设置浏览器下载失败！");
      e.printStackTrace();
    }
  }
}
