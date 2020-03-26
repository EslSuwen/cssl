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
}
