package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.TeacherMsg;
import com.cqjtu.cssl.mapper.TeacherMsgMapper;
import com.cqjtu.cssl.service.TeacherMsgService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户消息服务实现类
 *
 * @author suwen
 * @since 2020-03-23
 */
@Service
public class TeacherMsgServiceImpl extends ServiceImpl<TeacherMsgMapper, TeacherMsg>
    implements TeacherMsgService {

  @Override
  public List<TeacherMsg> getMsgListByTid(String tid) {
    return list(new QueryWrapper<TeacherMsg>().eq("tid", tid).orderByAsc("mdate"));
  }
}
