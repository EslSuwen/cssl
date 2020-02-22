package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.Arrange;
import com.cqjtu.cssl.mapper.ArrangeMapper;
import com.cqjtu.cssl.mapper.ArrangePeriodMapper;
import com.cqjtu.cssl.service.ArrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务实现类
 *
 * @author suwen
 * @since 2020-02-21
 */
@Service
public class ArrangeServiceImpl extends ServiceImpl<ArrangeMapper, Arrange>
    implements ArrangeService {

  @Autowired ArrangePeriodMapper arrangePeriodMapper;

  @Override
  public List<Arrange> findByTid(String tid) {
    Map<String, Object> columnMap = new HashMap<>();
    // 写表中的列名
    columnMap.put("aid", tid);
    List<Arrange> arrangeList = listByMap(columnMap);
    for (Arrange each : arrangeList) {
      each.setArrangePeriod(arrangePeriodMapper.selectByMap(columnMap));
    }
    return arrangeList;
  }
}
