package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.Notice;
import com.cqjtu.cssl.mapper.NoticeMapper;
import com.cqjtu.cssl.service.NoticeService;
import org.springframework.stereotype.Service;

/**
 * 通知信息表，通知由管理员发布。 服务实现类
 *
 * @author suwen
 * @since 2020-08-24
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {}
