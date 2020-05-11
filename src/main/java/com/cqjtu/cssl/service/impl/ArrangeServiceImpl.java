package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.Arrange;
import com.cqjtu.cssl.entity.ArrangePeriod;
import com.cqjtu.cssl.mapper.ArrangeMapper;
import com.cqjtu.cssl.mapper.ArrangePeriodMapper;
import com.cqjtu.cssl.mapper.LabArrangeMapper;
import com.cqjtu.cssl.mapper.TeachMapper;
import com.cqjtu.cssl.service.ArrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实验室安排服务实现类
 *
 * @author suwen
 * @since 2020-02-21
 */
@Service
public class ArrangeServiceImpl extends ServiceImpl<ArrangeMapper, Arrange>
    implements ArrangeService {

  private final ArrangePeriodMapper arrangePeriodMapper;
  private final LabArrangeMapper labArrangeMapper;
  private final TeachMapper teachMapper;

  @Autowired
  public ArrangeServiceImpl(
      ArrangePeriodMapper arrangePeriodMapper,
      LabArrangeMapper labArrangeMapper,
      TeachMapper teachMapper) {
    this.arrangePeriodMapper = arrangePeriodMapper;
    this.labArrangeMapper = labArrangeMapper;
    this.teachMapper = teachMapper;
  }

  @Override
  public List<Arrange> findByTid(String tid) {
    List<Arrange> arrangeList = list(new QueryWrapper<Arrange>().eq("tid", tid));
    for (Arrange each : arrangeList) {
      each.setArrangePeriod(
          arrangePeriodMapper.selectList(
              new QueryWrapper<ArrangePeriod>().eq("aid", each.getAid())));
    }
    return arrangeList;
  }

  @Override
  public boolean auditArrange(Integer aid, Integer status) {
    Arrange arrange = new Arrange();
    arrange.setStatus(status);
    return update(arrange, new UpdateWrapper<Arrange>().eq("aid", aid));
  }
}
