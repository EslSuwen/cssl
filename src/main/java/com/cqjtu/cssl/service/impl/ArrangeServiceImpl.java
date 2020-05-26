package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.constant.Audit;
import com.cqjtu.cssl.entity.Arrange;
import com.cqjtu.cssl.entity.ArrangePeriod;
import com.cqjtu.cssl.entity.TeachingPlan;
import com.cqjtu.cssl.mapper.ArrangeMapper;
import com.cqjtu.cssl.service.ArrangePeriodService;
import com.cqjtu.cssl.service.ArrangeService;
import com.cqjtu.cssl.service.ExpProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 实验室安排服务实现类
 *
 * @author suwen
 * @since 2020-02-21
 */
@Service
public class ArrangeServiceImpl extends ServiceImpl<ArrangeMapper, Arrange>
    implements ArrangeService {

  private final ArrangePeriodService arrangePeriodService;
  private final ExpProjectService expProjectService;
  private final ArrangeMapper arrangeMapper;

  @Autowired
  public ArrangeServiceImpl(
      ArrangePeriodService arrangePeriodService,
      ExpProjectService expProjectService,
      ArrangeMapper arrangeMapper) {
    this.arrangePeriodService = arrangePeriodService;
    this.expProjectService = expProjectService;
    this.arrangeMapper = arrangeMapper;
  }

  @Override
  public List<Arrange> findByTid(String tid) {
    List<Arrange> arrangeList = list(new QueryWrapper<Arrange>().eq("tid", tid));
    for (Arrange each : arrangeList) {
      each.setArrangePeriod(
          arrangePeriodService.list(new QueryWrapper<ArrangePeriod>().eq("aid", each.getAid())));
    }
    return arrangeList;
  }

  @Override
  public boolean auditArrange(Integer aid, Audit status) {
    Arrange arrange = new Arrange();
    arrange.setStatus(status);
    return update(arrange, new UpdateWrapper<Arrange>().eq("aid", aid));
  }

  @Override
  public List<TeachingPlan> getTeachingPlanList() {
    List<TeachingPlan> teachingPlanList = arrangeMapper.getTeachingPlanList();
    for (TeachingPlan each : teachingPlanList) {
      each.setCoursePeriod(arrangeMapper.getCoursePeriodByCid(each.getCourseId()));
    }
    return teachingPlanList;
  }

  @Override
  public List<Arrange> getAuditArrange() {

    return list(new QueryWrapper<Arrange>().eq("status", Audit.AUDITING)).stream()
        .map(
            each -> {
              each.setArrangePeriod(
                  arrangePeriodService.list(
                      new QueryWrapper<ArrangePeriod>().eq("aid", each.getAid())));
              return each;
            })
        .collect(Collectors.toList());
  }

  @Override
  public boolean addArrange(Arrange arrange) {

    arrange.setStatus(Audit.AUDITING);
    arrange.setCourseId(expProjectService.getById(arrange.getProId()).getCourseId());
    save(arrange);

    int aid = getOne(new QueryWrapper<Arrange>().eq("pro_id", arrange.getProId())).getAid();

    return arrangePeriodService.saveBatch(
        arrange.getArrangePeriod().stream()
            .map(
                each -> {
                  each.setAid(aid);
                  return each;
                })
            .collect(Collectors.toList()));
  }
}
