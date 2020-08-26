package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.Notice;
import com.cqjtu.cssl.mapper.NoticeMapper;
import com.cqjtu.cssl.service.NoticeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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
  private final ValueOperations<String, Object> redisOperations;

  @Autowired
  public NoticeServiceImpl(RedisTemplate<String, Object> redisTemplate) {
    this.redisTemplate = redisTemplate;
    redisOperations = redisTemplate.opsForValue();
  }

  @Override
  public boolean addNotice(Notice notice) {
    boolean result = save(notice);
    if (result) {
      String key = "notice_" + notice.getNid();
      redisOperations.set(key, notice, 5, TimeUnit.HOURS);
    }
    return result;
  }

  @Override
  public Notice getNotice(Integer nid) {
    String key = "notice_" + nid;
    // 判断redis中是否有键为key的缓存
    Boolean hasKey = redisTemplate.hasKey(key);
    Notice notice;
    if (hasKey != null && hasKey) {
      notice = (Notice) redisOperations.get(key);
      log.info("从缓存中获得数据-----------> " + notice);
    } else {
      notice = baseMapper.getById(nid);
      log.info("查询数据库获得数据-----------> " + notice);
      // 写入缓存
      redisOperations.set(key, notice, 5, TimeUnit.HOURS);
    }
    return notice;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Notice> getAllNotice() {
    String key = "notice_list";
    Boolean hasKey = redisTemplate.hasKey(key);
    List<Notice> noticeList;
    if (hasKey != null && hasKey) {
      noticeList = (List<Notice>) redisOperations.get(key);
      log.info("从缓存中获得数据-----------> noticeList");
    } else {
      noticeList = baseMapper.list();
      log.info("查询数据库获得数据-----------> noticeList");
      // 写入缓存
      redisOperations.set(key, noticeList, 5, TimeUnit.HOURS);
    }
    return noticeList;
  }

  @Override
  public List<Notice> getNoticeByMap(Map<String, Object> conditions) {
    return listByMap(conditions);
  }

  @Override
  public boolean updateNotice(Notice notice) {
    boolean result = updateById(notice);
    if (result) {
      String key = "notice_" + notice.getNid();
      Boolean hasKey = redisTemplate.hasKey(key);
      if (hasKey != null && hasKey) {
        redisTemplate.delete(key);
        System.out.println("删除缓存中的key-----------> " + key);
      }
      // 再将更新后的数据加入缓存
      notice = baseMapper.getById(notice.getNid());
      if (notice != null) {
        redisOperations.set(key, notice, 3, TimeUnit.HOURS);
      }
    }
    return result;
  }

  @Override
  public boolean removeNotice(Integer nid) {
    boolean result = removeById(nid);
    String key = "notice_" + nid;
    if (result) {
      Boolean hasKey = redisTemplate.hasKey(key);
      if (hasKey != null && hasKey) {
        redisTemplate.delete(key);
        System.out.println("删除了缓存中的key-----------> " + key);
      }
    }
    return result;
  }
}
