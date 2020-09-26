package com.cqjtu.cssl.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.cqjtu.cssl.constant.ReturnCode;
import com.cqjtu.cssl.dto.ResultDto;
import com.cqjtu.cssl.entity.Arrange;
import com.cqjtu.cssl.service.ArrangeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

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
      @ApiParam(value = "教师编号", required = true) @PathVariable String tid) {

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
   * 增加排课信息冲突检测
   *
   * @param arrange 排课信息
   * @return MessageHelper
   * @author suwen
   * @date 2020/9/26 早先10:05
   */
  @PostMapping("/AddArrange")
  public ResponseEntity<ResultDto> ifAddArrange(
      @ApiParam(value = "排课信息", required = true) @RequestBody Arrange arrange) {

    return arrangeService.ifAddArrange(arrange);
  }

  /**
   * 获取已申请的实验室安排信息
   *
   * @return 实验室时间安排列表
   * @author suwen
   * @date 2020/5/15 下午7:27 @GetMapping("getAuditArrange") public ResponseEntity<ResultDto>
   *     getAuditArrange() {
   *     <p>return new ResponseEntity<>( ResultDto.builder() .success(true)
   *     .code(ReturnCode.RETURN_CODE_20001.getCode()) .message("获取已申请的实验室安排信息成功")
   *     .data(arrangeService.getAuditArrange()) .build(), HttpStatus.OK); }
   */

  /**
   * 管理员审核实验室时间安排
   *
   * @param aid 安排编号
   * @param status 审核状态
   * @return 操作状态
   * @author suwen
   * @date 2020/5/11 上午9:49 @PutMapping("auditArrange") public ResponseEntity<ResultDto>
   *     auditArrange( @ApiParam(value = "安排编号", required = true) @RequestParam Integer
   *     aid, @ApiParam(value = "审核状态", required = true) @RequestParam Audit status) {
   *     <p>return new ResponseEntity<>( ResultDto.builder()
   *     .success(arrangeService.auditArrange(aid, status))
   *     .code(ReturnCode.RETURN_CODE_20004.getCode()) .message("审核实验室时间安排成功") .build(),
   *     HttpStatus.OK); }
   */

  /**
   * 获取教学计划表
   *
   * @return java.util.List<教学计划表>
   * @author suwen
   * @date 2020/5/13 下午3:41
   */
  @GetMapping("/getTeachingPlan/{term}")
  public ResponseEntity<ResultDto> getTeachingPlanList(@PathVariable String term) {

    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .message("获取教学计划表成功")
            .data(arrangeService.getTeachingPlanList(term))
            .build(),
        HttpStatus.OK);
  }

  /**
   * 获取教学计划表 excel
   *
   * @author suwen
   * @date 2020/5/13 下午5:51
   */
  @GetMapping("/getTeachingPlanExcel/{term}")
  public void getTeachingPlanExcel(@PathVariable String term, HttpServletResponse response)
      throws IOException {

    ExcelWriter writer = ExcelUtil.getWriter(true);
    writer.merge(14, "教学计划表");
    writer.addHeaderAlias("proId", "编号");
    writer.addHeaderAlias("labName", "实验室名");
    writer.addHeaderAlias("expMajor", "专业名");
    writer.addHeaderAlias("term", "学期");
    writer.addHeaderAlias("labClass", "班级");
    writer.addHeaderAlias("expCname", "实验课程名");
    writer.addHeaderAlias("courseId", "课程编号");
    writer.addHeaderAlias("expTime", "学时");
    writer.addHeaderAlias("coursePeriod", "行课周期");
    writer.addHeaderAlias("courseCollege", "开课学院");
    writer.addHeaderAlias("campus", "校区");
    writer.addHeaderAlias("tname", "教师名");
    writer.addHeaderAlias("tid", "教师工号");
    writer.addHeaderAlias("courseType", "课程类型");
    writer.addHeaderAlias("labRemark", "备注");

    writer.write(arrangeService.getTeachingPlanList(term), true);
    OutputStream out = response.getOutputStream();
    response.setContentType(
        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
    response.setHeader("Content-Disposition", "attachment;filename=" + term + ".xlsx");

    writer.flush(out, true);
    writer.close();
    IoUtil.close(out);
  }

  /**
   * 通过年级获取班级名单 TODO 增加字段 grade
   *
   * @param grade 年级
   * @return 班级名单
   */
  @GetMapping("/getClassByGrade/{grade}")
  public ResponseEntity<ResultDto> getClassByGrade(@PathVariable Integer grade) {
    return new ResponseEntity<>(
        ResultDto.builder()
            .success(true)
            .message("获取班级信息成功")
            .data(arrangeService.getClassByGrade(grade))
            .code(ReturnCode.RETURN_CODE_20001.getCode())
            .build(),
        HttpStatus.OK);
  }
}
