package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.constant.ReturnCode;
import com.cqjtu.cssl.dto.ResultDto;
import com.cqjtu.cssl.entity.NoticeFile;
import com.cqjtu.cssl.service.NoticeFileService;
import com.cqjtu.cssl.utils.FileUtil;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
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
@Api(tags = "通知文件-控制器")
@Log4j2
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
  public ResponseEntity<ResultDto> add(NoticeFile noticeFile, @RequestParam MultipartFile nFile)
      throws IOException {
    noticeFile.setFile(nFile.getBytes());

    log.info(noticeFile);
    log.info(nFile);

    if (!nFile.isEmpty()) {
      // 获取文件名称,包含后缀
      String fileName = nFile.getOriginalFilename();

      // 存放在这个路径下：该路径是该工程目录下的static文件下：(注：该文件可能需要自己创建)
      // 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
      String path = System.getProperty("user.dir") + "/CSSL_FILES/noticeFile/";

      try {
        // 该方法是对文件写入的封装，在util类中，导入该包即可使用，后面会给出方法
        FileUtil.fileupload(nFile.getBytes(), path, fileName);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20005.getCode())
            .message("通知文件" + ReturnCode.RETURN_CODE_20005.getMessage())
            //            .data(noticeFileService.save(noticeFile))
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
