package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.Notice;
import com.cqjtu.cssl.mapper.NoticeMapper;
import com.cqjtu.cssl.service.NoticeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 通知信息表，通知由管理员发布。 服务实现类
 *
 * @author suwen
 * @since 2020-08-24
 */
@Log4j2
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

  private final RedisTemplate<String, Object> redisTemplate;

  @Autowired
  public NoticeServiceImpl(RedisTemplate<String, Object> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  @Override
  public boolean addNotice(Notice notice) {
    return save(notice);
  }

  @Override
  public Notice getNotice(Integer nid) {
    String key = "notice_" + nid;
    ValueOperations<String, Object> operations = redisTemplate.opsForValue();
    // 判断redis中是否有键为key的缓存
    Notice notice;
    try {
      Boolean hasKey = redisTemplate.hasKey(key);
      if (hasKey != null && hasKey) {
        notice = (Notice) operations.get(key);
        log.info("从缓存中获得数据：" + notice);
        log.info("------------------------------------");
      } else {
        notice = baseMapper.getById(nid);
        log.info("查询数据库获得数据：" + notice);
        log.info("------------------------------------");
        // 写入缓存
        operations.set(key, notice, 5, TimeUnit.HOURS);
      }
    } catch (QueryTimeoutException e) {
      notice = baseMapper.getById(nid);
      log.info("缓存读取失败：" + notice);
    }
    return notice;
  }

  @Override
  public List<Notice> getAllNotice(String noticeType) {
    return baseMapper.list(noticeType);
  }

  @Override
  public List<Notice> getNoticeByMap(Map<String, Object> conditions) {
    return listByMap(conditions);
  }

  @Override
  public boolean updateNotice(Notice notice) {
    return updateById(notice);
  }

  @Override
  public boolean removeNotice(Integer nid) {
    return removeById(nid);
  }
}
