package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.constant.ReturnCode;
import com.cqjtu.cssl.dto.ResultDto;
import com.cqjtu.cssl.entity.Notice;
import com.cqjtu.cssl.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 通知信息表，通知由管理员发布。 前端控制器
 *
 * @author suwen
 * @since 2020-08-24
 */
@Api(tags = "通知信息-控制器")
@RestController
@RequestMapping("/notice")
public class NoticeController {

  private final NoticeService noticeService;

  @Autowired
  public NoticeController(NoticeService noticeService) {
    this.noticeService = noticeService;
  }

  /**
   * 通过通知编号获取通知信息
   *
   * @param nid 通知编号
   * @author suwen
   * @date 2020/8/24 下午1:07
   */
  @GetMapping("/getNoticeById")
  public ResponseEntity<ResultDto> getNoticeById(
      @ApiParam(value = "通知编号", required = true) @RequestParam Integer nid) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .message("获取通知信息成功")
            .data(noticeService.getNotice(nid))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 获取所有通知信息
   *
   * @author suwen
   * @date 2020/8/24 下午1:07
   */
  @GetMapping("/getAllNotice")
  public ResponseEntity<ResultDto> getAllNotice() {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .message("获取所有通知信息成功")
            .data(noticeService.getAllNotice())
            .build(),
        HttpStatus.OK);
  }

  /**
   * 通过条件查询所有通知信息
   *
   * @author suwen
   * @date 2020/8/24 下午1:07
   */
  @GetMapping("/getNoticeByMap")
  public ResponseEntity<ResultDto> getNoticeByMap(@RequestBody Map<String, Object> conditionsMap) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .message("条件查询通知信息成功")
            .data(noticeService.getNoticeByMap(conditionsMap))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 增加通知信息
   *
   * @param notice 通知信息
   * @author suwen
   * @date 2020/8/24 下午1:10
   */
  @PostMapping("/addNotice")
  public ResponseEntity<ResultDto> addNotice(
      @ApiParam(value = "通知信息", required = true) @RequestBody Notice notice) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20005.getCode())
            .message("增加通知信息成功")
            .data(noticeService.addNotice(notice))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 修改通知信息
   *
   * @param notice 通知信息
   * @author suwen
   * @date 2020/8/24 下午1:13
   */
  @PutMapping("/updateNotice")
  public ResponseEntity<ResultDto> updateNotice(
      @ApiParam(value = "通知信息", required = true) @RequestBody Notice notice) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20004.getCode())
            .message("修改通知信息成功")
            .data(noticeService.updateNotice(notice))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 删除通知信息
   *
   * @author suwen
   * @date 2020/8/24 下午1:11
   */
  @DeleteMapping("/removeNotice")
  public ResponseEntity<ResultDto> removeNotice(
      @ApiParam(value = "通知编号", required = true) @RequestParam Integer nid) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20006.getCode())
            .message("删除通知信息成功")
            .data(noticeService.removeNotice(nid))
            .build(),
        HttpStatus.OK);
  }
}
