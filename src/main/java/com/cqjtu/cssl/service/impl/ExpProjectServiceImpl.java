package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.ExpProject;
import com.cqjtu.cssl.mapper.ExpProjectMapper;
import com.cqjtu.cssl.service.ExpProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
  public boolean isCardExist(String tid, String cid) {

    return !list(new QueryWrapper<ExpProject>().eq("exp_tid", tid).eq("course_id", cid)).isEmpty();
  }

  @Override
  public ExpProject getExpByTidCid(String tid, String cid) {

    return getOne(new QueryWrapper<ExpProject>().eq("exp_tid", tid).eq("course_id", cid));
  }

  @Override
  public boolean auditProject(String proId, Integer status) {

    ExpProject expProject=new ExpProject();
    expProject.setLabStatus(status);
    return update(expProject,new UpdateWrapper<ExpProject>().eq("pro_Id",proId));
  }
}
