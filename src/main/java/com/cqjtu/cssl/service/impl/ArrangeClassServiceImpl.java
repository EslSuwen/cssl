package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.ArrangeClass;
import com.cqjtu.cssl.mapper.ArrangeClassMapper;
import com.cqjtu.cssl.service.ArrangeClassService;
import org.springframework.stereotype.Service;

/**
 * 排课班级 服务实现类
 *
 * @author suwen
 * @since 2021/5/28 09:43
 */
@Service
public class ArrangeClassServiceImpl extends ServiceImpl<ArrangeClassMapper, ArrangeClass>
    implements ArrangeClassService {}
