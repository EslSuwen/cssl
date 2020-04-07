package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.LabInfo;
import com.cqjtu.cssl.mapper.LabInfoMapper;
import com.cqjtu.cssl.service.LabInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实验室信息服务实现类
 *
 * @author Aplin suwen
 * @since 2020-02-27
 */
@Service
public class LabInfoServiceImpl extends ServiceImpl<LabInfoMapper, LabInfo>
    implements LabInfoService {}
