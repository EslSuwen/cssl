package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.ExpClass;

import java.util.List;

/**
 * 排课班级 Mapper 接口
 *
 * @author suwen
 * @since 2020-10-06
 */
public interface ExpClassMapper extends BaseMapper<ExpClass> {

  /**
   * 根据项目编号获取项目班级
   *
   * @param proId 项目编号
   * @return 项目班级
   */
  List<ExpClass> getByProId(Integer proId);
}
