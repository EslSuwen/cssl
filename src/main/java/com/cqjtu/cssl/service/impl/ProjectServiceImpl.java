package com.cqjtu.cssl.service.impl;

import com.cqjtu.cssl.entity.Project;
import com.cqjtu.cssl.mapper.ProjectMapper;
import com.cqjtu.cssl.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 项目卡片信息服务接口实现
 *
 * @author: suwen
 * @time: 2020/2/6 3:57 下午
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl implements ProjectService {

  @Autowired private ProjectMapper projectMapper;

  @Override
  public void addProject(Project project) {
    projectMapper.addProject(project);
  }

  @Override
  public List<Project> loadAll() {
    return projectMapper.findAllProject();
  }

  @Override
  public void removeProject(Integer proId) {
    projectMapper.deleProjectById(proId);
  }

  @Override
  public void updateProject(Project project) {
    projectMapper.updateProjectById(project);
  }

  @Override
  public Project getProjectById(Integer proId) {
    return projectMapper.findProjectById(proId);
  }
}
