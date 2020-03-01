package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.entity.ExpProject;

import java.util.List;

/**
 * 项目卡片信息服务接口
 *
 * @author Aplin suwen
 * @date 2020/2/6 3:57 下午
 */
public interface ExpProjectService extends IService<ExpProject> {

  /**
   * 新增一条项目卡片数据
   *
   * @author suwen
   * @date 2020/2/6 3:57 下午
   * @param expProject 项目卡片
   */
  void addProject(ExpProject expProject);

  /**
   * 删除一条项目卡片数据记录
   *
   * @author suwen
   * @date 2020/2/6 3:57 下午
   * @param proId 项目卡片编号
   */
  void removeProject(Integer proId);

  /**
   * 更新一条项目卡片记录
   *
   * @author suwen
   * @date 2020/2/6 3:57 下午
   * @param proId 项目卡片编号
   */
  void updateProject(ExpProject proId);

  /**
   * 获取一条项目卡片记录
   *
   * @author suwen
   * @date 2020/2/6 3:57 下午
   * @param proId 项目卡片编号
   * @return Project
   */
  ExpProject getProjectById(Integer proId);

  /**
   * 获取所有项目卡片记录
   *
   * @author suwen
   * @date 2020/2/6 3:57 下午
   * @return List<com.cqjtu.cssl.entity.Project>
   */
  List<ExpProject> loadAll();
}
