package com.cqjtu.cssl.mapper;

import com.cqjtu.cssl.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {

    /**
     * 根据ID查询实验项目卡片信息
     *
     * @param proId
     * @return
     */
    Project findProjectById(int proId);

    /**
     * 根据课程名称模糊查询实验项目卡片信息
     *
     * @param expCname
     * @return
     */
    List<Project> findProjectByName(String expCname);

    /**
     * 添加实验项目卡片信息
     *
     * @param project
     */
    void addProject(Project project);

    /**
     * 根据ID修改实验项目卡片信息
     *
     * @param project
     */
    void updateProjectById(Project project);

    /**
     * 根据ID删除实验项目卡片信息
     *
     * @param proId
     */
    void deleProjectById(int proId);

    /**
     * 显示所有实验项目卡片信息
     *
     * @return
     */
    List<Project> findAllProject();

}
