package com.cqjtu.cssl.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileReader;
import com.cqjtu.cssl.constant.ReturnCode;
import com.cqjtu.cssl.dto.ResultDto;
import com.cqjtu.cssl.entity.NoticeFile;
import com.cqjtu.cssl.service.NoticeFileService;
import io.swagger.annotations.Api;
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
  @PostMapping("/add")
  public ResponseEntity<ResultDto> add(NoticeFile noticeFile, @RequestParam MultipartFile nFile)
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
        ResultDto.builder()
            .success(noticeFileService.save(noticeFile))
            .code(ReturnCode.RETURN_CODE_20005.getCode())
            .message("通知文件" + ReturnCode.RETURN_CODE_20005.getMessage())
            .build(),
        HttpStatus.CREATED);
  }

  /**
   * 获取通知文件列表
   *
   * @author suwen
   * @date 2020/8/28 上午11:03
   */
  @GetMapping("/getAll")
  public ResponseEntity<ResultDto> getAll() {
    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .message("通知文件" + ReturnCode.RETURN_CODE_20001.getMessage())
            .data(noticeFileService.list())
            .build(),
        HttpStatus.CREATED);
  }

  /**
   * 通过编号获取通知文件详细
   *
   * @param id 编号
   * @author suwen
   * @date 2020/8/28 上午11:03
   */
  @GetMapping("/getById/{id}")
  public ResponseEntity<ResultDto> getById(@PathVariable Integer id) {
    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .message("通知文件" + ReturnCode.RETURN_CODE_20001.getMessage())
            .data(noticeFileService.getById(id))
            .build(),
        HttpStatus.CREATED);
  }

  /**
   * 通过编号删除通知文件
   *
   * @param id 编号
   * @author suwen
   * @date 2020/8/28 上午11:03
   */
  @GetMapping("/remove/{id}")
  public ResponseEntity<ResultDto> remove(@PathVariable Integer id) {
    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20006.getCode())
            .message("通知文件" + ReturnCode.RETURN_CODE_20006.getMessage())
            .data(noticeFileService.removeById(id))
            .build(),
        HttpStatus.CREATED);
  }

  /**
   * 文件下载
   *
   * @param fileId 文件编号
   * @author suwen
   * @date 2020/8/30 上午10:42
   */
  @GetMapping("/getFile/{fileId}")
  public void getFileDownload(@PathVariable Integer fileId, HttpServletResponse response) {
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
