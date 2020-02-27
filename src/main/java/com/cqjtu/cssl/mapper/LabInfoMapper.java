package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.LabInfo;

import java.util.List;

/**
 * 实验室 Mapper 接口
 *
 * @author Aplin suwen
 * @date 2020/2/6 3:30 下午
 */
public interface LabInfoMapper extends BaseMapper<LabInfo> {
  /**
   * 增加实验室信息
   *
   * @author Aplin
   * @date 2020/1/13 10:37 上午
   * @param labInfo 实验室信息
   */
  void addLab(LabInfo labInfo);

  /**
   * 修改实验室信息
   *
   * @author Aplin
   * @date 2020/1/13 10:37 上午
   * @param labInfo 实验室信息
   */
  void updateLabById(LabInfo labInfo);

  /**
   * 删除实验室信息
   *
   * @author Aplin
   * @date 2020/1/13 10:37 上午
   * @param labId 实验室编号
   */
  void deleLabById(String labId);

  /**
   * 显示所有实验室信息
   *
   * @author Aplin
   * @date 2020/1/13 10:37 上午
   * @return List<com.cqjtu.cssl.entity.LabInfo>
   */
  List<LabInfo> findAllLab();

  /**
   * 根据房间号模糊查询实验室
   *
   * @author Aplin
   * @date 2020/1/13 10:37 上午
   * @return List<com.cqjtu.cssl.entity.LabInfo>
   */
  List<LabInfo> findLabById(String labId);
}
