package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.ExpFileStore;
import com.cqjtu.cssl.mapper.ExpFileStoreMapper;
import com.cqjtu.cssl.service.ExpFileStoreService;
import org.springframework.stereotype.Service;

/**
 * 项目资料存储服务实现类
 *
 * @author suwen
 * @since 2020-07-07
 */
@Service
public class ExpFileStoreServiceImpl extends ServiceImpl<ExpFileStoreMapper, ExpFileStore>
    implements ExpFileStoreService {}
