package com.cqjtu.cssl.mapper;

import com.cqjtu.cssl.entity.ProjectItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectItemMapper {
    /**
     * 添加实验项目表信息
     *
     * @param projectItem
     */
    void addItem(ProjectItem projectItem);

    /**
     * 根据ID修改实验项目信息
     *
     * @param projectItem
     */
    void updateById(ProjectItem projectItem);

    /**
     * 根据ID查找实验室项目信息
     *
     * @param iId
     * @return
     */
    ProjectItem findById(String iId);

    /**
     * 通过实验室项目卡片ID查看它所拥有的实验项目信息
     *
     * @param proId
     * @return List<ProjectItem>
     */
    List<ProjectItem> findAllByProId(int proId);


    /**
     * 根据ID删除实验室项目信息
     *
     * @param iId
     */
    void deleById(String iId);

    /**
     * 通过实验室项目卡片ID删除它所拥有的实验项目信息
     *
     * @param proId
     */
    void deleByProId(int proId);

    int find(String iId);
}
