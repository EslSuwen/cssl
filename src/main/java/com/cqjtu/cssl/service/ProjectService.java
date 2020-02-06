package com.cqjtu.cssl.service;

import com.cqjtu.cssl.entity.Project;

import java.util.List;

/**
 * 项目服务接口
 *
 * @author: suwen
 * @time: 2020/2/6 3:57 下午
 */
public interface ProjectService {

  /**
   * 新增一条实验项目数据
   *
   * @author: suwen
   * @time: 2020/2/6 3:57 下午
   * @param project 项目
   */
  void addProject(Project project);

  /**
   * 删除一条实验项目数据记录
   *
   * @author: suwen
   * @time: 2020/2/6 3:57 下午
   * @param proId 项目编号
   */
  void removeProject(Integer proId);

  /**
   * 更新一条实验项目记录
   *
   * @author: suwen
   * @time: 2020/2/6 3:57 下午
   * @param proId 项目编号
   */
  void updateProject(Project proId);

  /**
   * 获取一条实验项目记录
   *
   * @author: suwen
   * @time: 2020/2/6 3:57 下午
   * @param proId 项目编号
   * @return Project
   */
  Project getProjectById(Integer proId);

  /**
   * 获取所有实验项目记录
   *
   * @author: suwen
   * @time: 2020/2/6 3:57 下午
   * @return List<com.cqjtu.cssl.entity.Project>
   */
  List<Project> loadAll();
}
