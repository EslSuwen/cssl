package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.ExpFile;
import com.cqjtu.cssl.mapper.ExpFileMapper;
import com.cqjtu.cssl.service.ExpFileService;
import org.springframework.stereotype.Service;

/**
 * 项目资料关联服务实现类
 *
 * @author suwen
 * @since 2020-07-07
 */
@Service
public class ExpFileServiceImpl extends ServiceImpl<ExpFileMapper, ExpFile>
    implements ExpFileService {

  @Override
  public ExpFile getFileStatus(Integer proId) {
    return getById(proId);
  }
}
