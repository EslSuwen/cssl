package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.ArrangePeriod;
import com.cqjtu.cssl.mapper.ArrangePeriodMapper;
import com.cqjtu.cssl.service.ArrangePeriodService;
import org.springframework.stereotype.Service;

/**
 * 实验项目服务实现类
 *
 * @author suwen
 * @since 2020-02-21
 */
@Service
public class ArrangePeriodServiceImpl extends ServiceImpl<ArrangePeriodMapper, ArrangePeriod>
    implements ArrangePeriodService {}
