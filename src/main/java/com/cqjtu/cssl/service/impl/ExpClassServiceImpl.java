package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.ExpClass;
import com.cqjtu.cssl.mapper.ExpClassMapper;
import com.cqjtu.cssl.service.ExpClassService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 排课班级 服务实现类
 *
 * @author suwen
 * @since 2020-10-06
 */
@Service
public class ExpClassServiceImpl extends ServiceImpl<ExpClassMapper, ExpClass>
    implements ExpClassService {

  @Override
  public List<ExpClass> getByProId(Integer proId) {
    return baseMapper.getByProId(proId);
  }
}
