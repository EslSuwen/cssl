package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.LabInfo;
import com.cqjtu.cssl.mapper.LabInfoMapper;
import com.cqjtu.cssl.service.LabInfoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 实验室信息服务实现类
 *
 * @author suwen
 * @since 2020-02-27
 */
@Log4j2
@Service
public class LabInfoServiceImpl extends ServiceImpl<LabInfoMapper, LabInfo>
    implements LabInfoService {

  private final RedisTemplate<String, Object> redisTemplate;
  private final ValueOperations<String, Object> redisOperations;

  @Autowired
  public LabInfoServiceImpl(
      RedisTemplate<String, Object> redisTemplate,
      ValueOperations<String, Object> redisOperations) {
    this.redisTemplate = redisTemplate;
    this.redisOperations = redisOperations;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<LabInfo> getLabByTypeId(Integer typeId) {
    String key = "lab_" + typeId;
    Boolean hasKey = redisTemplate.hasKey(key);
    List<LabInfo> labInfoList;
    if (hasKey != null && hasKey) {
      labInfoList = (List<LabInfo>) redisOperations.get(key);
      log.info("从缓存中获得数据-----------> " + key);
    } else {
      labInfoList = list(new QueryWrapper<LabInfo>().eq("type_id", typeId));
      log.info("查询数据库获得数据-----------> " + key);
      redisOperations.set(key, labInfoList, 5, TimeUnit.HOURS);
    }
    return labInfoList;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<LabInfo> getLabByTypeIdCampus(Integer typeId, String campus) {
    String key = String.format("lab_%s_campus_%s", typeId, campus);
    Boolean hasKey = redisTemplate.hasKey(key);
    List<LabInfo> labInfoList;
    if (hasKey != null && hasKey) {
      labInfoList = (List<LabInfo>) redisOperations.get(key);
      log.info("从缓存中获得数据-----------> " + key);
    } else {
      labInfoList =
          list(new QueryWrapper<LabInfo>().eq("type_id", typeId).eq("lab_campus", campus));
      log.info("查询数据库获得数据-----------> " + key);
      redisOperations.set(key, labInfoList, 5, TimeUnit.HOURS);
    }
    return labInfoList;
  }

  @Override
  public LabInfo getLabByProId(Integer proId) {
    return baseMapper.getLabByProId(proId);
  }
}
