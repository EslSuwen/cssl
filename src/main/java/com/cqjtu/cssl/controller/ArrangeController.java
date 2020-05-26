package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.constant.Audit;
import com.cqjtu.cssl.constant.ReturnCode;
import com.cqjtu.cssl.dto.ResultDto;
import com.cqjtu.cssl.entity.Arrange;
import com.cqjtu.cssl.service.ArrangeService;
import com.cqjtu.cssl.utils.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 实验室安排前端控制器
 *
 * @author suwen
 * @since 2020-02-21
 */
@Log4j2
@Api(tags = "实验室安排-控制器")
@RestController
@RequestMapping("/arrange")
public class ArrangeController {

  private final ArrangeService arrangeService;

  @Autowired
  public ArrangeController(ArrangeService arrangeService) {
    this.arrangeService = arrangeService;
  }

  /**
   * 根据教师编号查询排课
   *
   * @param tid 教师编号
   * @return List<Arrange> 排课数据列表
   * @author suwen
   * @date 2020/2/21 下午7:32
   */
  @GetMapping("/getInfo/{tid}")
  public ResponseEntity<ResultDto> getArrange(
      @NonNull @ApiParam(value = "教师编号", required = true) @PathVariable String tid) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .message("获取排课信息成功")
            .data(arrangeService.findByTid(tid))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 增加排课信息
   *
   * @param arrange 排课信息
   * @return MessageHelper
   * @author suwen
   * @date 2020/2/22 下午1:24
   */
  @PostMapping("/addArrange")
  public ResponseEntity<ResultDto> addArrange(
      @NonNull @ApiParam(value = "排课信息", required = true) @RequestBody Arrange arrange) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(arrangeService.addArrange(arrange))
            .code(ReturnCode.RETURN_CODE_20005.getCode())
            .message("增加排课信息成功")
            .build(),
        HttpStatus.OK);
  }

  /**
   * 获取已申请的实验室安排信息
   *
   * @return 实验室时间安排列表
   * @author suwen
   * @date 2020/5/15 下午7:27
   */
  @GetMapping("getAuditArrange")
  public ResponseEntity<ResultDto> getAuditArrange() {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .message("获取已申请的实验室安排信息成功")
            .data(arrangeService.getAuditArrange())
            .build(),
        HttpStatus.OK);
  }

  /**
   * 管理员审核实验室时间安排
   *
   * @param aid 安排编号
   * @param status 审核状态
   * @return 操作状态
   * @author suwen
   * @date 2020/5/11 上午9:49
   */
  @GetMapping("auditArrange")
  public ResponseEntity<ResultDto> auditArrange(
      @NonNull @ApiParam(value = "安排编号", required = true) @RequestParam Integer aid,
      @NonNull @ApiParam(value = "审核状态", required = true) @RequestParam Audit status) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(arrangeService.auditArrange(aid, status))
            .code(ReturnCode.RETURN_CODE_20004.getCode())
            .message("审核实验室时间安排成功")
            .build(),
        HttpStatus.OK);
  }

  /**
   * 获取教学计划表
   *
   * @return java.util.List<教学计划表>
   * @author suwen
   * @date 2020/5/13 下午3:41
   */
  @GetMapping("getTeachingPlan")
  public ResponseEntity<ResultDto> getTeachingPlanList() {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .message("获取教学计划表成功")
            .data(arrangeService.getTeachingPlanList())
            .build(),
        HttpStatus.OK);
  }

  /**
   * 获取教学计划表 excel
   *
   * @author suwen
   * @date 2020/5/13 下午5:51
   */
  @GetMapping("getTeachingPlanExcel")
  public void getTeachingPlanExcel(HttpServletResponse httpResponse) {
    ExcelUtil.exportExcel(httpResponse, arrangeService.getTeachingPlanList());
  }
}
