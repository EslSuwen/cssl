package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.Notice;
import com.cqjtu.cssl.mapper.NoticeMapper;
import com.cqjtu.cssl.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通知信息表，通知由管理员发布。 服务实现类
 *
 * @author suwen
 * @since 2020-08-24
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {
  @Override
  public boolean addNotice(Notice notice) {
    return save(notice);
  }

  @Override
  public Notice getNotice(Integer nid) {
    return getById(nid);
  }

  @Override
  public List<Notice> getAllNotice() {
    return list();
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
