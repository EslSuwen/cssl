package com.cqjtu.cssl.service.impl;

import com.cqjtu.cssl.entity.LabInfo;
import com.cqjtu.cssl.mapper.LabInfoMapper;
import com.cqjtu.cssl.service.LabInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实验室信息服务接口实现
 *
 * @author: Aplin
 * @time: 2020/1/13 11:05 上午
 */
@Service
public class LabInfoServiceImpl implements LabInfoService {
  @Autowired private LabInfoMapper labInfoMapper;

  @Override
  public void addLab(LabInfo labInfo) {
    labInfoMapper.addLab(labInfo);
  }

  @Override
  public void updateLabById(LabInfo labInfo) {
    labInfoMapper.updateLabById(labInfo);
  }

  @Override
  public void deleLabById(String labId) {
    labInfoMapper.deleLabById(labId);
  }

  @Override
  public List<LabInfo> findAllLab() {
    return labInfoMapper.findAllLab();
  }

  @Override
  public List<LabInfo> findLabById(String labId) {
    return labInfoMapper.findLabById(labId);
  }
}
