package com.cqjtu.cssl.mapper;

import com.cqjtu.cssl.entity.MajorClassHelper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 班级信息映射接口
 *
 * @author Aplin
 * @date 2020/1/13 10:37 上午
 */
public interface MajorClassMapper {
  /**
   * 查询所有班级的信息（含专业名）
   *
   * @author Aplin
   * @date 2020/1/13 10:37 上午
   * @return List<com.cqjtu.cssl.entity.MajorClassHelper> 专业班级对象
   */
  List<MajorClassHelper> findAll();
}
