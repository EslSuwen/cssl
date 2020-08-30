package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.Class;
import com.cqjtu.cssl.mapper.ClassMapper;
import com.cqjtu.cssl.service.ClassService;
import org.springframework.stereotype.Service;

/**
 * 班级服务实现类
 *
 * @author suwen Aplin
 * @since 2020-02-27
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {}
