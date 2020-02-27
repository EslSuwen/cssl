package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.ExpProject;

import java.util.List;

/**
 * 项目(实验卡片) Mapper 接口
 *
 * @author Aplin suwen
 * @date 2020/2/6 3:30 下午
 */
public interface ExpProjectMapper extends BaseMapper<ExpProject> {

  /**
   * 根据ID查询实验项目卡片信息
   *
   * @author suwen
   * @date 2020/2/6 3:32 下午
   * @param proId 项目
   * @return com.cqjtu.cssl.entity.Project
   */
  ExpProject findProjectById(int proId);

  /**
   * 根据课程名称模糊查询实验项目卡片信息
   *
   * @author suwen
   * @date 2020/2/6 3:32 下午
   * @param expCname 课程名
   * @return java.util.List<com.cqjtu.cssl.entity.Project>
   */
  List<ExpProject> findProjectByName(String expCname);

  /**
   * 添加实验项目卡片信息
   *
   * @author suwen
   * @date 2020/2/6 3:33 下午
   * @param expProject 项目
   */
  void addProject(ExpProject expProject);

  /**
   * 根据ID修改实验项目卡片信息
   *
   * @author suwen
   * @date 2020/2/6 3:33 下午
   * @param expProject 卡片信息
   */
  void updateProjectById(ExpProject expProject);

  /**
   * 根据ID删除实验项目卡片信息
   *
   * @author suwen
   * @date 2020/2/6 3:34 下午
   * @param proId 卡片编号
   */
  void deleProjectById(int proId);

  /**
   * 显示所有实验项目卡片信息
   *
   * @author suwen
   * @date 2020/2/6 3:35 下午
   * @return java.util.List<com.cqjtu.cssl.entity.Project>
   */
  List<ExpProject> findAllProject();
}
