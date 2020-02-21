package com.cqjtu.cssl.mapper;

import com.cqjtu.cssl.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 项目 mapper
 *
 * @author suwen
 * @date 2020/2/6 3:30 下午
 */
@Mapper
public interface ProjectMapper {

  /**
   * 根据ID查询实验项目卡片信息
   *
   * @author suwen
   * @date 2020/2/6 3:32 下午
   * @param proId 项目
   * @return com.cqjtu.cssl.entity.Project
   */
  Project findProjectById(int proId);

  /**
   * 根据课程名称模糊查询实验项目卡片信息
   *
   * @author suwen
   * @date 2020/2/6 3:32 下午
   * @param expCname 课程名
   * @return java.util.List<com.cqjtu.cssl.entity.Project>
   */
  List<Project> findProjectByName(String expCname);

  /**
   * 添加实验项目卡片信息
   *
   * @author suwen
   * @date 2020/2/6 3:33 下午
   * @param project 项目
   */
  void addProject(Project project);

  /**
   * 根据ID修改实验项目卡片信息
   *
   * @author suwen
   * @date 2020/2/6 3:33 下午
   * @param project 卡片信息
   */
  void updateProjectById(Project project);

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
  List<Project> findAllProject();
}
