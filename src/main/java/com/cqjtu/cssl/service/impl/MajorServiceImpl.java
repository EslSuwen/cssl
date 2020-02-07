package com.cqjtu.cssl.service.impl;

import com.cqjtu.cssl.entity.Major;
import com.cqjtu.cssl.mapper.MajorMapper;
import com.cqjtu.cssl.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 专业信息服务接口实现
 *
 * @author: Aplin
 * @time: 2020/1/13 11:06 上午
 */
@Service
public class MajorServiceImpl implements MajorService {
  @Autowired private MajorMapper majorMapper;

  @Override
  public void addMajor(Major major) {
    majorMapper.addMajor(major);
  }

  @Override
  public Major findById(int majorID) {
    return majorMapper.findById(majorID);
  }

  @Override
  public void updateById(int majorID, Major newMajor) {
    majorMapper.updateById(majorID, newMajor);
  }

  @Override
  public List<Major> findAll() {
    return majorMapper.findAll();
  }

  @Override
  public void deleteById(int majorID) {
    majorMapper.deleteById(majorID);
  }
}
