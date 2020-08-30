package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.LabInfo;

/**
 * 实验室 Mapper 接口
 *
 * @author Aplin suwen
 * @date 2020/2/6 3:30 下午
 */
public interface LabInfoMapper extends BaseMapper<LabInfo> {
  /**
   * 通过项目编号查找实验室信息
   *
   * @param proId 项目编号
   * @return 实验室信息
   * @author suwen
   * @date 2020/8/21 上午11:30
   */
  LabInfo getLabByProId(Integer proId);
}
