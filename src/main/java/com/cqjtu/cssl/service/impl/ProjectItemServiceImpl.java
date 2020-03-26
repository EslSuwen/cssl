package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.ProjectItem;
import com.cqjtu.cssl.mapper.ProjectItemMapper;
import com.cqjtu.cssl.service.ProjectItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    Map<String, Object> map = new HashMap<>();
    map.put("pro_Id", proId);

    return listByMap(map);
  }
}
