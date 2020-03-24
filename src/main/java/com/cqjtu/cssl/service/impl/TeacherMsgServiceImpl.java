package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqjtu.cssl.entity.TeacherMsg;
import com.cqjtu.cssl.mapper.TeacherMsgMapper;
import com.cqjtu.cssl.service.TeacherMsgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  用户消息服务实现类
 * </p>
 *
 * @author suwen
 * @since 2020-03-23
 */
@Service
public class TeacherMsgServiceImpl extends ServiceImpl<TeacherMsgMapper, TeacherMsg> implements TeacherMsgService {

    private TeacherMsgMapper teacherMsgMapper;

    @Autowired
    public TeacherMsgServiceImpl(TeacherMsgMapper teacherMsgMapper) {
        this.teacherMsgMapper = teacherMsgMapper;
    }

    @Override
    public List<TeacherMsg> getMsgListByTid(String tid) {

        return teacherMsgMapper.selectList(new QueryWrapper<TeacherMsg>()
                .eq("tid",tid).orderByAsc("mdate"));

    }
}
