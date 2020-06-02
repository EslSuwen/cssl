package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.constant.Audit;
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
  public boolean isCardExist(String tid, Integer cid) {

    return !list(new QueryWrapper<ExpProject>().eq("exp_tid", tid).eq("course_id", cid)).isEmpty();
  }

  @Override
  public ExpProject getExpByTidCid(String tid, Integer cid) {

    return getOne(new QueryWrapper<ExpProject>().eq("exp_tid", tid).eq("course_id", cid));
  }

  @Override
  public List<ExpProject> getExpByTid(String tid, String term) {
    return list(new QueryWrapper<ExpProject>().eq("exp_tid", tid).eq("term", term));
  }

  @Override
  public List<ExpProject> getAuditProjects() {

    return list(new QueryWrapper<ExpProject>().eq("status", Audit.AUDITING));
  }

  @Override
  public boolean auditProject(String proId, Audit status) {

    ExpProject expProject = new ExpProject();
    expProject.setStatus(status);
    return update(expProject, new UpdateWrapper<ExpProject>().eq("pro_Id", proId));
  }

  @Override
  public boolean addProject(ExpProject expProject) throws Exception {
    if (isCardExist(expProject.getExpTid(), expProject.getCourseId())) {
      throw new Exception("该卡片已经存在");
    }
    expProject.setLabCenName("信息技术实践教学中心");
    return save(expProject);
  }

  @Override
  public List<String> getTermList() {
    return expProjectMapper.getTermList();
  }
}
