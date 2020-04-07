package com.cqjtu.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqjtu.cssl.entity.Arrange;
import com.cqjtu.cssl.entity.ArrangePeriod;
import com.cqjtu.cssl.entity.ExpProject;
import com.cqjtu.cssl.service.ArrangePeriodService;
import com.cqjtu.cssl.service.ArrangeService;
import com.cqjtu.cssl.service.ExpProjectService;
import io.swagger.annotations.Api;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
