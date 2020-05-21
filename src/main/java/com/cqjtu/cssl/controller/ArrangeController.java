package com.cqjtu.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqjtu.cssl.entity.Arrange;
import com.cqjtu.cssl.entity.ArrangePeriod;
import com.cqjtu.cssl.entity.ExpProject;
import com.cqjtu.cssl.entity.TeachingPlan;
import com.cqjtu.cssl.service.ArrangePeriodService;
import com.cqjtu.cssl.service.ArrangeService;
import com.cqjtu.cssl.service.ExpProjectService;
import com.cqjtu.cssl.utils.ExcelUtil;
import io.swagger.annotations.Api;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
  private final ArrangePeriodService arrangePeriodService;
  private final ExpProjectService expProjectService;

  @Autowired
  public ArrangeController(
      ArrangeService arrangeService,
      ArrangePeriodService arrangePeriodService,
      ExpProjectService expProjectService) {
    this.arrangeService = arrangeService;
    this.arrangePeriodService = arrangePeriodService;
    this.expProjectService = expProjectService;
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
  public List<Arrange> getArrange(@NonNull @PathVariable String tid) {
    return arrangeService.findByTid(tid);
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
  public int addArrange(@NonNull @RequestBody Arrange arrange) {
    int proId = arrange.getProId();
    arrange.setCourseId(expProjectService.getById(proId).getCourseId());
    arrangeService.save(arrange);
    ExpProject exp = expProjectService.getById(arrange.getProId());
    exp.setLabStatus(2);
    expProjectService.updateById(exp);
    int aid =
        arrangeService
            .getOne(new QueryWrapper<Arrange>().eq("pro_id", arrange.getProId()))
            .getAid();
    for (ArrangePeriod each : arrange.getArrangePeriod()) {
      each.setAid(aid);
    }
    arrangePeriodService.saveBatch(arrange.getArrangePeriod());
    return 1;
  }

  /**
   * 获取已申请的实验室安排信息
   *
   * @return 实验室时间安排列表
   * @author suwen
   * @date 2020/5/15 下午7:27
   */
  @GetMapping("auditArrange")
  public List<Arrange> getAuditArrange() {

    return arrangeService.list(new QueryWrapper<Arrange>().eq("status", 2));
  }

  /**
   * 管理员审核实验室时间安排
   *
   * @param aid 安排编号
   * @param status 状态编号
   * @return 操作状态
   * @author suwen
   * @date 2020/5/11 上午9:49
   */
  @GetMapping("getAuditArrange")
  public boolean auditArrange(@RequestParam Integer aid, @RequestParam Integer status) {

    return arrangeService.auditArrange(aid, status);
  }

  /**
   * 获取教学计划表
   *
   * @return java.util.List<教学计划表>
   * @author suwen
   * @date 2020/5/13 下午3:41
   */
  @GetMapping("getTeachingPlan")
  public List<TeachingPlan> getTeachingPlanList() {
    return arrangeService.getTeachingPlanList();
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
