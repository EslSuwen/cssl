package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.TeacherMsg;
import com.cqjtu.cssl.mapper.TeacherMsgMapper;
import com.cqjtu.cssl.service.TeacherMsgService;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 用户消息服务实现类
 *
 * @author suwen
 * @since 2020-03-23
 */
@Log4j2
@Service
public class TeacherMsgServiceImpl extends ServiceImpl<TeacherMsgMapper, TeacherMsg>
    implements TeacherMsgService {

  private final RedisTemplate<String, Object> redisTemplate;
  private final ValueOperations<String, Object> redisOperations;

  @Autowired
  public TeacherMsgServiceImpl(
      RedisTemplate<String, Object> redisTemplate,
      ValueOperations<String, Object> redisOperations) {
    this.redisTemplate = redisTemplate;
    this.redisOperations = redisOperations;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<TeacherMsg> getMsgListByTid(String tid) {
    String key = "msg_tid_" + tid;
    Boolean hasKey = redisTemplate.hasKey(key);
    List<TeacherMsg> teacherMsgs;
    if (hasKey != null && hasKey) {
      teacherMsgs = (List<TeacherMsg>) redisOperations.get(key);
      log.info("从缓存中获得数据-----------> " + key);
    } else {
      teacherMsgs = list(new QueryWrapper<TeacherMsg>().eq("tid", tid).orderByAsc("mdate"));
      log.info("查询数据库获得数据-----------> " + key);
      redisOperations.set(key, teacherMsgs, 5, TimeUnit.HOURS);
    }
    return teacherMsgs;
  }

  @Override
  public Boolean addMsg(TeacherMsg msg) {
    Boolean result = save(msg);
    if (result) {
      String key = "msg_tid_" + msg.getTid();
      Boolean hasKey = redisTemplate.hasKey(key);
      if (hasKey != null && hasKey) {
        redisTemplate.delete(key);
        System.out.println("删除缓存中的key-----------> " + key);
      }
    }
    return result;
  }

  @Override
  public Boolean removeMsg(Integer ino) {
    TeacherMsg msg = getById(ino);
    Boolean result = removeById(ino);
    if (result) {
      String key = "msg_tid_" + msg.getTid();
      Boolean hasKey = redisTemplate.hasKey(key);
      if (hasKey != null && hasKey) {
        redisTemplate.delete(key);
        System.out.println("删除缓存中的key-----------> " + key);
      }
    }
    return result;
  }

  @Override
  public Boolean updateMsg(TeacherMsg msg) {
    Boolean result = updateById(msg);
    if (result) {
      String key = "msg_tid_" + msg.getTid();
      Boolean hasKey = redisTemplate.hasKey(key);
      if (hasKey != null && hasKey) {
        redisTemplate.delete(key);
        System.out.println("删除缓存中的key-----------> " + key);
      }
    }
    return result;
  }
}
