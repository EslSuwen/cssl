package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.ProjectItem;
import com.cqjtu.cssl.mapper.ProjectItemMapper;
import com.cqjtu.cssl.service.ProjectItemService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实验项目信息服务实现类
 *
 * @author Aplin suwen
 * @since 2020-02-27
 */
@Service
public class ProjectItemServiceImpl extends ServiceImpl<ProjectItemMapper, ProjectItem>
    implements ProjectItemService {

  @Override
  public List<ProjectItem> listByProId(int proId) {
    return list(new QueryWrapper<ProjectItem>().eq("pro_Id", proId));
  }

  @Override
  public boolean updateItem(ProjectItem projectItem) {
    return updateById(projectItem);
  }

  @Override
  public Boolean deleteItem(int ino) {
    return removeById(ino);
  }
}
