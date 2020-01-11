package com.cqjtu.cssl.service;

import com.cqjtu.cssl.entity.ProjectItem;

import java.util.List;


public interface ProjectItemService {

    /**
     * 新增一条实验项目项
     *
     * @param  projectItem
     *
     */
    void addProjectItem(ProjectItem projectItem);


    /**
     * 删除一条实验项目项
     *
     * @param  iId
     *
     */
    void removeProjectItem(Integer iId);

    /**
     * 更新一条实验项目项
     *
     * @param projectItem
     *
     */
    void updateProjectItem(ProjectItem projectItem);

    /**
     * 获取一条实验项目项
     *
     * @param iId
     *
     */
    ProjectItem getProjectItemById(Integer iId);

    /**
     * 通过实验室项目卡片ID查看它所拥有的实验项目信息
     *
     * @param proId
     * @return List<ProjectItem>
     */
    List<ProjectItem> findAllByProId(int proId);

}

