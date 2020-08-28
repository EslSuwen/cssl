package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.cqjtu.cssl.entity.NoticeFile;
import com.cqjtu.cssl.mapper.NoticeFileMapper;
import com.cqjtu.cssl.service.NoticeFileService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 通知文件 服务实现类
 *
 * @author suwen
 * @since 2020-08-28
 */
@Log4j2
@Service
public class NoticeFileServiceImpl extends ServiceImpl<NoticeFileMapper, NoticeFile>
    implements NoticeFileService {

  private final RedisTemplate<String, Object> redisTemplate;
  private final ValueOperations<String, Object> redisOperations;

  @Autowired
  public NoticeFileServiceImpl(
      RedisTemplate<String, Object> redisTemplate,
      ValueOperations<String, Object> redisOperations) {
    this.redisTemplate = redisTemplate;
    this.redisOperations = redisOperations;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<NoticeFile> list() {
    String key = "notice_file_list";
    Boolean hasKey = redisTemplate.hasKey(key);
    List<NoticeFile> noticeFileList;
    if (hasKey != null && hasKey) {
      noticeFileList = (List<NoticeFile>) redisOperations.get(key);
      log.info("从缓存中获得数据-----------> notice_file_list");
    } else {
      noticeFileList = baseMapper.getAllNoticeFile();
      log.info("查询数据库获得数据-----------> notice_file_list");
      redisOperations.set(key, noticeFileList, 5, TimeUnit.HOURS);
    }
    return noticeFileList;
  }

  @Override
  public boolean save(NoticeFile noticeFile) {
    return removeCache(SqlHelper.retBool(baseMapper.insert(noticeFile)));
  }

  @Override
  public boolean updateById(NoticeFile entity) {
    return removeCache(SqlHelper.retBool(baseMapper.updateById(entity)));
  }

  @Override
  public boolean removeById(Serializable id) {
    return removeCache(SqlHelper.retBool(baseMapper.deleteById(id)));
  }

  public boolean removeCache(boolean result) {
    if (result) {
      String key = "notice_file_list";
      Boolean hasKey = redisTemplate.hasKey(key);
      if (hasKey != null && hasKey) {
        redisTemplate.delete(key);
        log.info("删除缓存中的key-----------> " + key);
      }
    }
    return result;
  }
}
