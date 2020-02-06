package com.cqjtu.cssl.service.impl;

import com.cqjtu.cssl.entity.ProjectItem;
import com.cqjtu.cssl.mapper.ProjectItemMapper;
import com.cqjtu.cssl.service.ProjectItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 实验项目接口实现
 *
 * @author: suwen
 * @time: 2020/2/6 4:04 下午
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectItemServiceImpl implements ProjectItemService {

  @Autowired private ProjectItemMapper projectItemMapper;

  @Override
  public void addProjectItem(ProjectItem projectItem) {

    projectItemMapper.addItem(projectItem);
  }

  @Override
  public void removeProjectItem(Integer iId) {

    projectItemMapper.deleById(iId.toString());
  }

  @Override
  public void updateProjectItem(ProjectItem projectItem) {

    projectItemMapper.updateById(projectItem);
  }

  @Override
  public ProjectItem getProjectItemById(Integer iId) {

    return projectItemMapper.findById(iId.toString());
  }

  @Override
  public List<ProjectItem> findAllByProId(int proId) {

    return projectItemMapper.findAllByProId(proId);
  }
}
