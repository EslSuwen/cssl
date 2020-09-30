package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.Major;
import com.cqjtu.cssl.mapper.MajorMapper;
import com.cqjtu.cssl.service.MajorService;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 *
 * @author Aplin suwen
 * @since 2020-02-27
 */
@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements MajorService {}
