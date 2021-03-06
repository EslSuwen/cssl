package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.LabInfo;
import com.cqjtu.cssl.mapper.LabInfoMapper;
import com.cqjtu.cssl.service.LabInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实验室信息服务实现类
 *
 * @author Aplin suwen
 * @since 2020-02-27
 */
@Service
public class LabInfoServiceImpl extends ServiceImpl<LabInfoMapper, LabInfo>
    implements LabInfoService {

  @Override
  public List<LabInfo> getLabByTypeId(Integer typeId) {

    return list(new QueryWrapper<LabInfo>().eq("type_id", typeId));
  }

  @Override
  public List<LabInfo> getLabByTypeIdCampus(Integer typeId, String campus) {

    return list(new QueryWrapper<LabInfo>().eq("type_id", typeId).eq("lab_campus", campus));
  }

  @Override
  public LabInfo getLabByProId(Integer proId) {
    return baseMapper.getLabByProId(proId);
  }
}
