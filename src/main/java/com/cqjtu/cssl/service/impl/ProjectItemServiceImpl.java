package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.ProjectItem;
import com.cqjtu.cssl.mapper.ProjectItemMapper;
import com.cqjtu.cssl.service.ProjectItemService;
import com.mysql.cj.util.TimeUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 实验项目信息服务实现类
 *
 * @author Aplin suwen
 * @since 2020-02-27
 */
@Log4j2
@Service
public class ProjectItemServiceImpl extends ServiceImpl<ProjectItemMapper, ProjectItem>
    implements ProjectItemService {

  private final RedisTemplate<String, Object> redisTemplate;
  private final ValueOperations<String, Object> redisOperations;

  @Autowired
  public ProjectItemServiceImpl(
      RedisTemplate<String, Object> redisTemplate,
      ValueOperations<String, Object> redisOperations) {
    this.redisTemplate = redisTemplate;
    this.redisOperations = redisOperations;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<ProjectItem> listByProId(Integer proId) {
    String key = "item_proId_" + proId;
    Boolean hasKey = redisTemplate.hasKey(key);
    List<ProjectItem> projectItemList;
    if (hasKey != null && hasKey) {
      projectItemList = (List<ProjectItem>) redisOperations.get(key);
      log.info("从缓存中获得数据-----------> " + key);
    } else {
      projectItemList = list(new QueryWrapper<ProjectItem>().eq("pro_Id", proId));
      log.info("查询数据库获得数据-----------> " + key);
      redisOperations.set(key, projectItemList, 5, TimeUnit.HOURS);
    }
    return projectItemList;
  }

  @Override
  public Boolean updateItem(ProjectItem projectItem) {
    Boolean result = updateById(projectItem);
    if (result) {
      String key = "item_proId_" + projectItem.getProId();
      Boolean hasKey = redisTemplate.hasKey(key);
      if (hasKey != null && hasKey) {
        redisTemplate.delete(key);
        log.info("删除缓存中的key-----------> " + key);
      }
    }
    return result;
  }

  @Override
  public Boolean deleteItem(Integer ino) {
    ProjectItem projectItem = getById(ino);
    boolean result = removeById(ino);
    if (result) {
      String key = "item_proId_" + projectItem.getProId();
      Boolean hasKey = redisTemplate.hasKey(key);
      if (hasKey != null && hasKey) {
        redisTemplate.delete(key);
        log.info("删除缓存中的key-----------> " + key);
      }
    }
    return result;
  }
}
