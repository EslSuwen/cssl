package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.entity.Major;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 专业信息服务接口
 *
 * @author Aplin suwen
 * @date 2020/1/13 11:06 上午
 */
public interface MajorService extends IService<Major> {
  /**
   * 添加专业信息
   *
   * @author Aplin
   * @date 2020/1/13 11:06 上午
   * @param major 专业对象
   */
  void addMajor(Major major);

  /**
   * 通过专业ID查询专业信息
   *
   * @author Aplin
   * @date 2020/1/13 11:06 上午
   * @param majorID 专业ID
   * @return Major对象
   */
  Major findById(int majorID);

  /**
   * 通过专业ID修改专业信息
   *
   * @author Aplin
   * @date 2020/1/13 11:06 上午
   * @param newMajor 新专业对象
   * @param majorID 专业ID
   */
  void updateById(int majorID, Major newMajor);

  /**
   * 查询所有的专业信息
   *
   * @author Aplin
   * @date 2020/1/13 11:06 上午
   * @return Major集合
   */
  List<Major> findAll();

  /**
   * 通过专业ID删除专业信息
   *
   * @author Aplin
   * @date 2020/1/13 11:06 上午
   * @param majorID 专业ID
   */
  void deleteById(int majorID);
}
