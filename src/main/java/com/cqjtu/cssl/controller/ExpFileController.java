package com.cqjtu.cssl.controller;

import cn.hutool.core.io.file.FileReader;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqjtu.cssl.constant.ReturnCode;
import com.cqjtu.cssl.dto.ResultDto;
import com.cqjtu.cssl.entity.ExpFile;
import com.cqjtu.cssl.entity.ExpFileStore;
import com.cqjtu.cssl.service.ExpFileService;
import com.cqjtu.cssl.service.ExpFileStoreService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
   * @return 文件状态
   * @author suwen
   * @date 2020/7/8 上午9:20
   */
  @GetMapping("/getFileStatus/{proId}")
  public ResponseEntity<ResultDto> getFileStatus(@PathVariable Integer proId) {

    ExpFile expFile = expFileService.getById(proId);
    List<ExpFileStore> expFileStoreList =
        expFileStoreService.list(new QueryWrapper<ExpFileStore>().eq("pro_id", proId));
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
   * @return 执行结果
   * @author suwen
   * @date 2020/7/8 上午10:16
   */
  @PostMapping("/addExpFile")
  public ResponseEntity<ResultDto> addExpFile(
      ExpFileStore expFileStore, @RequestParam MultipartFile file) throws IOException {

    log.info(expFileStore);
    log.info(file.getOriginalFilename());

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(expFileStoreService.saveFile(expFileStore, file))
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
  @GetMapping("/getById/{proId}")
  public ResponseEntity<ResultDto> getById(@PathVariable Integer proId) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .message("获取文件储存信息成功")
            .data(expFileStoreService.getById(proId))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 获取 expFile
   *
   * @param fileNo 文件编号
   * @param term 学期
   * @author suwen
   * @date 2020/8/31 上午12:42
   */
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
}
