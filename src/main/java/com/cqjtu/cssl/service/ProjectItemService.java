package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.entity.ProjectItem;

import java.util.List;

/**
 * 实验项目信息服务类
 *
 * @author Aplin suwen
 * @since 2020-02-27
 */
public interface ProjectItemService extends IService<ProjectItem> {

  /**
   * 通过实验室项目卡片ID查看它所拥有的实验项目信息
   *
   * @author suwen
   * @date 2020/2/6 4:03 下午
   * @param proId 项目卡片编号
   * @return List<ProjectItem>
   */
  List<ProjectItem> listByProId(int proId);

  /**
   * 更新实验卡片项目项信息
   *
   * @param projectItem 项目项信息
   * @return 成功（true）/ 失败 （false）
   * @author suwen
   * @date 2020/7/5 下午4:02
   */
  boolean updateItem(ProjectItem projectItem);
}
