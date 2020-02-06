package com.cqjtu.cssl.mapper;

import com.cqjtu.cssl.entity.ProjectItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 实验项目 mapper
 *
 * @author: suwen
 * @time: 2020/2/6 3:30 下午
 */
@Mapper
public interface ProjectItemMapper {

  /**
   * 添加实验项目表信息
   *
   * @author: suwen
   * @time: 2020/2/6 3:37 下午
   * @param projectItem 实验项目
   * @return:
   */
  void addItem(ProjectItem projectItem);

  /**
   * 根据ID修改实验项目信息
   *
   * @author: suwen
   * @time: 2020/2/6 3:38 下午
   * @param projectItem 实验项目
   * @return:
   */
  void updateById(ProjectItem projectItem);

  /**
   * 根据ID查找实验室项目信息
   *
   * @author: suwen
   * @time: 2020/2/6 3:38 下午
   * @param iId 实验项目编号
   * @return: com.cqjtu.cssl.entity.ProjectItem
   */
  ProjectItem findById(String iId);

  /**
   * 通过实验室项目卡片ID查看它所拥有的实验项目信息
   *
   * @author: suwen
   * @time: 2020/2/6 3:39 下午
   * @param proId
   * @return List<ProjectItem>
   */
  List<ProjectItem> findAllByProId(int proId);

  /**
   * 根据ID删除实验室项目信息
   *
   * @author: suwen
   * @time: 2020/2/6 3:41 下午
   * @param iId 实验项目编号
   * @return:
   */
  void deleById(String iId);

  /**
   * 通过实验室项目卡片ID删除它所拥有的实验项目信息
   *
   * @author: suwen
   * @time: 2020/2/6 3:42 下午
   * @param proId 项目编号
   * @return:
   */
  void deleByProId(int proId);

  /**
   * 通过实验项目编号查询项目卡片编号
   *
   * @author: suwen
   * @time: 2020/2/6 3:43 下午
   * @param iId 实验项目编号
   * @return:
   */
  int find(String iId);
}
