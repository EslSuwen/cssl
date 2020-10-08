package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.constant.Audit;
import com.cqjtu.cssl.entity.ExpProject;
import com.cqjtu.cssl.mapper.ExpProjectMapper;
import com.cqjtu.cssl.service.ExpProjectService;
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

  @Override
  public boolean isCardExist(String tid, Integer cid, String term) {

    return !list(new QueryWrapper<ExpProject>()
            .eq("exp_tid", tid)
            .eq("course_id", cid)
            .eq("term", term))
        .isEmpty();
  }

  @Override
  public ExpProject getExpByTidCid(String tid, Integer cid) {

    return getOne(new QueryWrapper<ExpProject>().eq("exp_tid", tid).eq("course_id", cid));
  }

  @Override
  public List<ExpProject> getExpByTid(String tid, String term) {
    return list(new QueryWrapper<ExpProject>().eq("exp_tid", tid).eq("term", term));
  }

  public List<ExpProject> getAuditProjects() {

    return list(new QueryWrapper<ExpProject>().eq("status", Audit.AUDITING));
  }

  public boolean auditProject(String proId, Audit status) {

    ExpProject expProject = new ExpProject();
    expProject.setLabStatus(status);
    return update(expProject, new UpdateWrapper<ExpProject>().eq("pro_id", proId));
  }

  @Override
  public boolean addProject(ExpProject expProject) {
    if (isCardExist(expProject.getExpTid(), expProject.getCourseId(), expProject.getTerm())) {
      throw new IllegalArgumentException("该卡片已经存在");
    }
    return save(expProject);
  }

  @Override
  public List<String> getTermList() {
    return baseMapper.getTermList();
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
    return updateById(expProject);
  }

  @Override
  public Boolean deleteExp(int proId) {
    return removeById(proId);
  }

  @Override
  public List<ExpProject> getByTidTerm(String tid, String term) {
    return baseMapper.getByTidTerm(tid, term);
  }
}
