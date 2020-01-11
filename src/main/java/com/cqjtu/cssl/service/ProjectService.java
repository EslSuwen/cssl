package com.cqjtu.cssl.service;

import com.cqjtu.cssl.entity.Project;

import java.util.List;


public interface ProjectService {

    /**
     * 获取一条实验项目数据
     *
     * @param  proId
     * @return User
     *
     */
    Project get(Integer proId);


    /**
     * 新增一条实验项目数据
     *
     * @param  proId
     *
     */
    void addProject(Project proId);


    /**
     * 删除一条实验项目数据记录
     *
     * @param  proId
     *
     */
    void removeProject(Integer proId);

    /**
     * 更新一条实验项目记录
     *
     * @param proId
     *
     */
    void updateProject(Project proId);

    /**
     * 获取一条实验项目记录
     *
     * @param proId
     * @return Project
     *
     */
    Project getProjectById(Integer proId);

    /**
     *  获取所有实验项目记录
     *
     * @return List
     *
     */
    List<Project> loadAll();

}

