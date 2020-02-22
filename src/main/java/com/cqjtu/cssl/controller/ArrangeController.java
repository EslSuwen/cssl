package com.cqjtu.cssl.controller;

import com.cqjtu.cssl.entity.Arrange;
import com.cqjtu.cssl.entity.ArrangePeriod;
import com.cqjtu.cssl.service.ArrangePeriodService;
import com.cqjtu.cssl.service.ArrangeService;
import com.cqjtu.cssl.utils.MessageHelper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 实验室安排前端控制器
 *
 * @author suwen
 * @since 2020-02-21
 */
@RestController
@RequestMapping("/arrange")
public class ArrangeController {

  @Autowired private ArrangeService arrangeService;
  @Autowired private ArrangePeriodService arrangePeriodService;

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
  @RequestMapping("/add")
  public MessageHelper addArrange(@NonNull @RequestBody Arrange arrange) {
    arrangeService.save(arrange);
    List<ArrangePeriod> arrangePeriodList = arrange.getArrangePeriod();
    arrangePeriodService.saveBatch(arrangePeriodList);
    return new MessageHelper("增加成功");
  }
}
