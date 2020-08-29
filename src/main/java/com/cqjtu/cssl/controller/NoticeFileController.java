package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.constant.ReturnCode;
import com.cqjtu.cssl.dto.ResultDto;
import com.cqjtu.cssl.entity.NoticeFile;
import com.cqjtu.cssl.service.NoticeFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 通知文件 前端控制器
 *
 * @author suwen
 * @since 2020-08-28
 */
@RestController
@RequestMapping("/noticeFile")
public class NoticeFileController {

  private final NoticeFileService noticeFileService;

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
  public ResponseEntity<ResultDto> add(
      @RequestParam NoticeFile noticeFile, @RequestParam MultipartFile file) throws IOException {
    noticeFile.setFile(file.getBytes());
    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20005.getCode())
            .message("通知文件" + ReturnCode.RETURN_CODE_20005.getMessage())
            .data(noticeFileService.save(noticeFile))
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
}
