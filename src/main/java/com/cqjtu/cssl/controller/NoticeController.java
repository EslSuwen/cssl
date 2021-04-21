package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.dto.Result;
import com.cqjtu.cssl.entity.Notice;
import com.cqjtu.cssl.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 通知信息表，通知由管理员发布-前端控制器
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
  @ApiOperation("通过通知编号获取通知信息")
  @GetMapping("/getNoticeById")
  public ResponseEntity<Result> getNoticeById(
      @ApiParam(value = "通知编号", required = true) @RequestParam Integer nid) {
    return Result.successGet(noticeService.getNotice(nid));
  }

  /**
   * 获取所有通知信息
   *
   * @author suwen
   * @date 2020/8/24 下午1:07
   */
  @ApiOperation("获取所有通知信息")
  @GetMapping("/getAllNotice/{noticeType}")
  public ResponseEntity<Result> getAllNotice(
      @ApiParam(value = "通知类型", required = true) @PathVariable String noticeType) {
    return Result.successGet(noticeService.getAllNotice(noticeType));
  }

  /**
   * 通过条件查询所有通知信息
   *
   * @author suwen
   * @date 2020/8/24 下午1:07
   */
  @ApiOperation("通过条件查询所有通知信息")
  @GetMapping("/getNoticeByMap")
  public ResponseEntity<Result> getNoticeByMap(
      @ApiParam(value = "通知条件", required = true) @RequestBody Map<String, Object> conditionsMap) {
    return Result.successGet(noticeService.getNoticeByMap(conditionsMap));
  }

  /**
   * 增加通知信息
   *
   * @param notice 通知信息
   * @author suwen
   * @date 2020/8/24 下午1:10
   */
  @ApiOperation("增加通知信息")
  @PostMapping("/addNotice")
  public ResponseEntity<Result> addNotice(
      @ApiParam(value = "通知信息", required = true) @RequestBody Notice notice) {
    return Result.successAdd(noticeService.addNotice(notice));
  }

  /**
   * 修改通知信息
   *
   * @param notice 通知信息
   * @author suwen
   * @date 2020/8/24 下午1:13
   */
  @ApiOperation("修改通知信息")
  @PutMapping("/updateNotice")
  public ResponseEntity<Result> updateNotice(
      @ApiParam(value = "通知信息", required = true) @RequestBody Notice notice) {
    return Result.successUpdate(noticeService.updateNotice(notice));
  }

  /**
   * 删除通知信息
   *
   * @author suwen
   * @date 2020/8/24 下午1:11
   */
  @ApiOperation("删除通知信息")
  @DeleteMapping("/removeNotice")
  public ResponseEntity<Result> removeNotice(
      @ApiParam(value = "通知编号", required = true) @RequestParam Integer nid) {
    return Result.successDelete(noticeService.removeNotice(nid));
  }
}
