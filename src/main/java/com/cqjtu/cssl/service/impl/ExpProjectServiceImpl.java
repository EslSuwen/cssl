package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.constant.Audit;
import com.cqjtu.cssl.entity.ExpProject;
import com.cqjtu.cssl.mapper.ExpProjectMapper;
import com.cqjtu.cssl.service.ExpProjectService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 项目卡片信息服务实现类
 *
 * @author suwen
 * @since 2020-02-27
 */
@Log4j2
@Service
public class ExpProjectServiceImpl extends ServiceImpl<ExpProjectMapper, ExpProject>
    implements ExpProjectService {

  private final RedisTemplate<String, Object> redisTemplate;
  private final ValueOperations<String, Object> redisOperations;

  @Autowired
  public ExpProjectServiceImpl(
      RedisTemplate<String, Object> redisTemplate,
      ValueOperations<String, Object> redisOperations) {
    this.redisTemplate = redisTemplate;
    this.redisOperations = redisOperations;
  }

  @Override
  public boolean isCardExist(String tid, Integer cid) {

    return !list(new QueryWrapper<ExpProject>().eq("exp_tid", tid).eq("course_id", cid)).isEmpty();
  }

  @Override
  public ExpProject getExpByTidCid(String tid, Integer cid) {

    return getOne(new QueryWrapper<ExpProject>().eq("exp_tid", tid).eq("course_id", cid));
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<ExpProject> getExpByTid(String tid, String term) {
    String key = String.format("exp_tid_%s_term_%s", tid, term);
    Boolean hasKey = redisTemplate.hasKey(key);
    List<ExpProject> expProjectList;
    if (hasKey != null && hasKey) {
      expProjectList = (List<ExpProject>) redisOperations.get(key);
      log.info("从缓存中获得数据-----------> " + key);
    } else {
      expProjectList = list(new QueryWrapper<ExpProject>().eq("exp_tid", tid).eq("term", term));
      log.info("查询数据库获得数据-----------> " + key);
      redisOperations.set(key, expProjectList, 5, TimeUnit.HOURS);
    }
    return expProjectList;
  }

  public List<ExpProject> getAuditProjects() {

    return list(new QueryWrapper<ExpProject>().eq("status", Audit.AUDITING));
  }

  public boolean auditProject(String proId, Audit status) {

    ExpProject expProject = new ExpProject();
    // expProject.setStatus(status);
    return update(expProject, new UpdateWrapper<ExpProject>().eq("pro_Id", proId));
  }

  @Override
  public boolean addProject(ExpProject expProject) {
    if (isCardExist(expProject.getExpTid(), expProject.getCourseId())) {
      throw new IllegalArgumentException("该卡片已经存在");
    }
    expProject.setLabCenName("信息技术实践教学中心");

    boolean result = save(expProject);
    if (result) {
      String key =
          String.format("exp_tid_%s_term_%s", expProject.getExpTid(), expProject.getTerm());
      Boolean hasKey = redisTemplate.hasKey(key);
      if (hasKey != null && hasKey) {
        redisTemplate.delete(key);
        log.info("删除缓存中的key-----------> " + key);
      }
    }
    return result;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<String> getTermList() {
    String key = "termList";
    Boolean hasKey = redisTemplate.hasKey(key);
    List<String> termList;
    if (hasKey != null && hasKey) {
      termList = (List<String>) redisOperations.get(key);
      log.info("从缓存中获得数据-----------> " + termList);
    } else {
      termList = baseMapper.getTermList();
      log.info("查询数据库获得数据-----------> " + termList);
      redisOperations.set(key, termList, 5, TimeUnit.HOURS);
    }
    return termList;
  }

  @Override
  public ExpProject reuseCard(String tid, String courseId) {
    return getOne(
        new QueryWrapper<ExpProject>()
            .last("LIMIT 1")
            .eq("exp_tid", tid)
            .eq("course_id", courseId));
  }

  @Override
  public Boolean updateExp(ExpProject expProject) {

    boolean result = updateById(expProject);
    if (result) {
      String key =
          String.format("exp_tid_%s_term_%s", expProject.getExpTid(), expProject.getTerm());
      Boolean hasKey = redisTemplate.hasKey(key);
      if (hasKey != null && hasKey) {
        redisTemplate.delete(key);
        log.info("删除缓存中的key-----------> " + key);
      }
    }
    return result;
  }

  @Override
  public Boolean deleteExp(int proId) {
    ExpProject expProject = getById(proId);
    boolean result = removeById(proId);
    if (result) {
      String key =
          String.format("exp_tid_%s_term_%s", expProject.getExpTid(), expProject.getTerm());
      Boolean hasKey = redisTemplate.hasKey(key);
      if (hasKey != null && hasKey) {
        redisTemplate.delete(key);
        log.info("删除缓存中的key-----------> " + key);
      }
    }
    return result;
  }
}
