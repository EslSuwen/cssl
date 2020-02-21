package com.cqjtu.cssl.service;

import com.cqjtu.cssl.entity.ProjectItem;

import java.util.List;

/**
 * 实验项目信息服务接口
 *
 * @author suwen
 * @date 2020/2/6 4:03 下午
 */
public interface ProjectItemService {

  /**
   * 新增一条实验项目
   *
   * @author suwen
   * @date 2020/2/6 4:03 下午
   * @param projectItem 实验项目
   */
  void addProjectItem(ProjectItem projectItem);

  /**
   * 删除一条实验项目
   *
   * @author suwen
   * @date 2020/2/6 4:03 下午
   * @param iId 实验项目编号
   */
  void removeProjectItem(Integer iId);

  /**
   * 更新一条实验项目
   *
   * @author suwen
   * @date 2020/2/6 4:03 下午
   * @param projectItem 实验项目
   */
  void updateProjectItem(ProjectItem projectItem);

  /**
   * 获取一条实验项目
   *
   * @author suwen
   * @date 2020/2/6 4:03 下午
   * @param iId 实验项目编号
   */
  ProjectItem getProjectItemById(Integer iId);

  /**
   * 通过实验室项目卡片ID查看它所拥有的实验项目信息
   *
   * @author suwen
   * @date 2020/2/6 4:03 下午
   * @param proId 项目卡片编号
   * @return List<ProjectItem>
   */
  List<ProjectItem> findAllByProId(int proId);
}
