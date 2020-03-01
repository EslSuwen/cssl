package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.ExpProject;
import com.cqjtu.cssl.mapper.ExpProjectMapper;
import com.cqjtu.cssl.service.ExpProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目卡片信息服务实现类
 *
 * @author Aplin suwen
 * @since 2020-02-27
 */
@Service
public class ExpProjectServiceImpl extends ServiceImpl<ExpProjectMapper, ExpProject>
    implements ExpProjectService {

  private final ExpProjectMapper expProjectMapper;

  @Autowired
  public ExpProjectServiceImpl(ExpProjectMapper expProjectMapper) {
    this.expProjectMapper = expProjectMapper;
  }

  @Override
  public void addProject(ExpProject expProject) {
    expProjectMapper.addProject(expProject);
  }

  @Override
  public List<ExpProject> loadAll() {
    return expProjectMapper.findAllProject();
  }

  @Override
  public void removeProject(Integer proId) {
    expProjectMapper.deleProjectById(proId);
  }

  @Override
  public void updateProject(ExpProject expProject) {
    expProjectMapper.updateProjectById(expProject);
  }

  @Override
  public ExpProject getProjectById(Integer proId) {
    return expProjectMapper.findProjectById(proId);
  }
}
