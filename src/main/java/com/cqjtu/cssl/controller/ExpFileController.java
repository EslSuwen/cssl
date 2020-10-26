package com.cqjtu.cssl.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqjtu.cssl.constant.ResultCode;
import com.cqjtu.cssl.dto.Result;
import com.cqjtu.cssl.entity.ExpFile;
import com.cqjtu.cssl.entity.ExpFileStore;
import com.cqjtu.cssl.service.ExpFileService;
import com.cqjtu.cssl.service.ExpFileStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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

  private final ExpFileService expFileService;
  private final ExpFileStoreService expFileStoreService;
  private final String DEFAULT_PATH = System.getProperty("user.dir");
  private final String FILE_PREFIX = "/CSSL_FILES/expFile/";

  @Autowired
  public ExpFileController(ExpFileService expFileService, ExpFileStoreService expFileStoreService) {
    this.expFileService = expFileService;
    this.expFileStoreService = expFileStoreService;
  }

  /**
   * 获得文件状态
   *
   * @param proId 项目卡片编号
   * @param classId 班级编号
   * @return 文件状态
   * @author suwen
   * @date 2020/7/8 上午9:20
   */
  @ApiOperation("获得文件状态")
  @GetMapping("/getFileStatus")
  public ResponseEntity<Result> getFileStatus(
      @RequestParam Integer proId, @RequestParam Integer classId) {
    ExpFile expFile =
        expFileService.getOne(
            new QueryWrapper<ExpFile>()
                .eq("pro_id", proId)
                .eq("class_id", classId)
                .last("LIMIT 1"));
    if (expFile == null) {
      return new ResponseEntity<>(
          Result.builder()
              .success(true)
              .message("文件状态为空")
              .code(ResultCode.SUCCESS_GET_DATA.getCode())
              .build(),
          HttpStatus.OK);
    }
    List<Integer> ids = new ArrayList<>();
    if (expFile.getAttend() != null) {
      ids.add(expFile.getAttend());
    }
    if (expFile.getTask() != null) {
      ids.add(expFile.getTask());
    }
    if (expFile.getGrade() != null) {
      ids.add(expFile.getGrade());
    }
    if (expFile.getScheme() != null) {
      ids.add(expFile.getScheme());
    }
    if (expFile.getReport() != null) {
      ids.add(expFile.getReport());
    }
    List<ExpFileStore> expFileStoreList = expFileStoreService.listByIds(ids);
    if (!expFileStoreList.isEmpty()) {
      expFile.setFiles(expFileStoreList);
    }
    return Result.successGet(expFile);
  }

  /**
   * 增加项目实验文件
   *
   * @param file 文件
   * @return 执行结果
   * @author suwen
   * @date 2020/7/8 上午10:16
   */
  @ApiOperation("增加项目实验文件")
  @PostMapping("/addExpFile")
  public ResponseEntity<Result> addExpFile(
      ExpFileStore expFileStore, @RequestParam MultipartFile file) throws IOException {
    log.info(expFileStore);
    log.info(file.getOriginalFilename());
    return Result.success(
        expFileStoreService.saveFile(expFileStore, file), ResultCode.SUCCESS_UPLOAD_DATA);
  }

  /**
   * 获取文件储存信息(除文件)
   *
   * @param proId 卡片编号
   * @return 件储存信息
   * @author suwen
   * @date 2020/7/8 下午1:38
   */
  @ApiOperation(value = "获取文件储存信息", notes = "获取文件储存信息(除文件)")
  @GetMapping("/getById/{proId}")
  public ResponseEntity<Result> getById(@PathVariable Integer proId) {
    return Result.successGet(expFileStoreService.getById(proId));
  }

  /**
   * 获取 expFile
   *
   * @param fileNo 文件编号
   * @param term 学期
   * @author suwen
   * @date 2020/8/31 上午12:42
   */
  @ApiOperation("获取 expFile")
  @GetMapping("/getFile")
  public void getFileDownload(
      @RequestParam Integer fileNo, @RequestParam String term, HttpServletResponse response) {
    ExpFileStore expFileStore = expFileStoreService.getById(fileNo);
    String fileName = expFileStore.getName();
    String filePath = DEFAULT_PATH + expFileStore.getFilePath();
    log.info(filePath);
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

  /**
   * 获取文件压缩包
   *
   * @param proId 项目编号
   * @param term 学期
   * @return void
   * @author suwen
   * @date 2020/10/26 10:08
   */
  @ApiOperation("获取文件压缩包")
  @GetMapping("/getFilesZip")
  public void getFilesZipByProId(
      @RequestParam Integer proId, @RequestParam String term, HttpServletResponse response) {
    log.info(proId + term);
    String filePath = StrUtil.format("{}{}{}/{}", DEFAULT_PATH, FILE_PREFIX, term, proId);
    log.info(filePath);
    log.info(FileUtil.exist(filePath));
    if (!FileUtil.exist(filePath)) {
      return;
    }
    File zip = ZipUtil.zip(filePath);
    try {
      response.reset();
      response.setCharacterEncoding("utf-8");
      response.setContentType("multipart/form-data");
      response.setHeader(
          "Content-disposition",
          "attachment; filename="
              + new String(zip.getName().getBytes(), StandardCharsets.ISO_8859_1));
      ServletOutputStream sos = response.getOutputStream();

      sos.write(FileUtil.readBytes(zip));
      sos.flush();
      sos.close();
      log.info(zip.getName() + "设置浏览器下载成功！");
    } catch (Exception e) {
      log.info(zip.getName() + "设置浏览器下载失败！");
      e.printStackTrace();
    }
  }
}
