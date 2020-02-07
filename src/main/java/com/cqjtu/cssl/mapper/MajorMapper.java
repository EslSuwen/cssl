package com.cqjtu.cssl.mapper;

import com.cqjtu.cssl.entity.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 专业映射接口
 *
 * @author: Aplin
 * @time: 2020/1/13 10:45 上午
 */
@Mapper
public interface MajorMapper {
  /**
   * 添加专业信息
   *
   * @author: Aplin
   * @time: 2020/1/13 10:45 上午
   * @param major 专业对象
   */
  void addMajor(Major major);

  /**
   * 通过专业ID查询专业信息
   *
   * @author: Aplin
   * @time: 2020/1/13 10:45 上午
   * @param majorID 专业ID
   * @return Major对象
   */
  Major findById(int majorID);

  /**
   * 通过专业ID修改专业信息
   *
   * @author: Aplin
   * @time: 2020/1/13 10:45 上午
   * @param newMajor 新专业对象
   * @param majorID 专业ID
   */
  void updateById(int majorID, Major newMajor);

  /**
   * 查询所有的专业信息
   *
   * @author: Aplin
   * @time: 2020/1/13 10:45 上午
   * @return Major集合
   */
  List<Major> findAll();

  /**
   * 通过专业ID删除专业信息
   *
   * @author: Aplin
   * @time: 2020/1/13 10:45 上午
   * @param majorID 专业ID
   */
  void deleteById(int majorID);
}
