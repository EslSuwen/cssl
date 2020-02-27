package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.Major;

import java.util.List;

/**
 * 专业 Mapper 接口
 *
 * @author Aplin suwen
 * @date 2020/2/6 3:30 下午
 */
public interface MajorMapper extends BaseMapper<Major> {
  /**
   * 添加专业信息
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @param major 专业对象
   */
  void addMajor(Major major);

  /**
   * 通过专业Id查询专业信息
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @param majorId 专业Id
   * @return Major对象
   */
  Major findById(int majorId);

  /**
   * 通过专业Id修改专业信息
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @param newMajor 新专业对象
   * @param majorId 专业Id
   */
  void updateById(int majorId, Major newMajor);

  /**
   * 查询所有的专业信息
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @return Major集合
   */
  List<Major> findAll();

  /**
   * 通过专业Id删除专业信息
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @param majorId 专业Id
   */
  void deleteById(int majorId);
}
