package com.cqjtu.cssl.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.cqjtu.cssl.constant.ResultCode;
import com.cqjtu.cssl.dto.Result;
import com.cqjtu.cssl.entity.Arrange;
import com.cqjtu.cssl.service.ArrangeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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
  @ApiOperation("根据教师编号查询排课")
  @GetMapping("/getInfo/{tid}")
  public ResponseEntity<Result> getArrange(
      @ApiParam(value = "教师编号", required = true) @PathVariable String tid) {
    return Result.successGet(arrangeService.findByTid(tid));
  }

  /**
   * 增加排课信息冲突检测
   *
   * @param arrange 排课信息
   * @return MessageHelper
   * @author suwen
   * @date 2020/9/26 早先10:05
   */
  @ApiOperation("增加排课信息冲突检测")
  @PostMapping("/AddArrange")
  public ResponseEntity<Result> ifAddArrange(
      @ApiParam(value = "排课信息", required = true) @RequestBody Arrange arrange) {
    return arrangeService.ifAddArrange(arrange);
  }

  /**
   * 获取教学计划表
   *
   * @return java.util.List<教学计划表>
   * @author suwen
   * @date 2020/5/13 下午3:41
   */
  @ApiOperation("获取教学计划表")
  @GetMapping("/getTeachingPlan")
  public ResponseEntity<Result> getTeachingPlanList() {
    return Result.successGet(arrangeService.getTeachingPlanList());
  }

  /**
   * 获取教学计划表 excel
   *
   * @author suwen
   * @date 2020/5/13 下午5:51
   */
  @ApiOperation("获取教学计划表 excel")
  @GetMapping("/getTeachingPlanExcel")
  public void getTeachingPlanExcel(HttpServletResponse response) throws IOException {

    ExcelWriter writer = ExcelUtil.getWriter(true);
    writer.merge(14, "教学计划表");
    writer.addHeaderAlias("proId", "卡片编号");
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

    writer.write(arrangeService.getTeachingPlanList(), true);
    OutputStream out = response.getOutputStream();
    response.setContentType(
        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
    response.setHeader("Content-Disposition", "attachment;filename=卡片总览表.xlsx");

    writer.flush(out, true);
    writer.close();
    IoUtil.close(out);
  }

  /**
   * 通过年级获取班级名单
   *
   * @param grade 年级
   * @return 班级名单
   */
  @ApiOperation("通过年级获取班级名单")
  @GetMapping("/getClassByGrade/{grade}")
  public ResponseEntity<Result> getClassByGrade(@PathVariable Integer grade) {
    return Result.successGet(arrangeService.getClassByGrade(grade));
  }
}
