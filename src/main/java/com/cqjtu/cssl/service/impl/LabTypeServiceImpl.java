package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.LabType;
import com.cqjtu.cssl.mapper.LabTypeMapper;
import com.cqjtu.cssl.service.LabTypeService;
import org.springframework.stereotype.Service;

/**
 * 实验室类型服务实现类
 *
 * @author suwen
 * @since 2020-02-27
 */
@Service
public class LabTypeServiceImpl extends ServiceImpl<LabTypeMapper, LabType>
    implements LabTypeService {}
