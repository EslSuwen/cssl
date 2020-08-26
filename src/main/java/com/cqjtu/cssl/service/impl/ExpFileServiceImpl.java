package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.ExpFile;
import com.cqjtu.cssl.entity.Notice;
import com.cqjtu.cssl.mapper.ExpFileMapper;
import com.cqjtu.cssl.service.ExpFileService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 项目资料关联服务实现类
 *
 * @author suwen
 * @since 2020-07-07
 */
@Log4j2
@Service
public class ExpFileServiceImpl extends ServiceImpl<ExpFileMapper, ExpFile>
    implements ExpFileService {

  private final RedisTemplate<String, Object> redisTemplate;
  private final ValueOperations<String, Object> redisOperations;

  @Autowired
  public ExpFileServiceImpl(
      RedisTemplate<String, Object> redisTemplate,
      ValueOperations<String, Object> redisOperations) {
    this.redisTemplate = redisTemplate;
    this.redisOperations = redisOperations;
  }

  @Override
  public ExpFile getFileStatus(Integer proId) {
    String key = "expFile_" + proId;
    Boolean hasKey = redisTemplate.hasKey(key);
    ExpFile expFile;
    if (hasKey != null && hasKey) {
      expFile = (ExpFile) redisOperations.get(key);
      log.info("从缓存中获得数据-----------> " + expFile);
    } else {
      expFile = getById(proId);
      log.info("查询数据库获得数据-----------> " + expFile);
      redisOperations.set(key, expFile, 5, TimeUnit.HOURS);
    }
    return expFile;
  }
}
