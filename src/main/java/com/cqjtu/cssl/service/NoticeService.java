package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.entity.Notice;

import java.util.List;
import java.util.Map;

/**
 * 通知信息表，通知由管理员发布。 服务类
 *
 * @author suwen
 * @since 2020-08-24
 */
public interface NoticeService extends IService<Notice> {

  /**
   * 增加通知
   *
   * @param notice 通知
   * @author suwen
   * @return 执行状态
   * @date 2020/8/24 下午12:53
   */
  boolean addNotice(Notice notice);

  /**
   * 通过编号查找通知
   *
   * @param nid 通知编号
   * @author suwen
   * @return 通知信息
   * @date 2020/8/24 下午12:53
   */
  Notice getNotice(Integer nid);

  /**
   * 查找所有通知
   *
   * @author suwen
   * @return 通知信息列表
   * @date 2020/8/24 下午12:53
   * @param noticeType 通知类型
   */
  List<Notice> getAllNotice(String noticeType);

  /**
   * 通过条件查找所有通知
   *
   * @param conditions 查询条件
   * @author suwen
   * @return 通知信息列表
   * @date 2020/8/24 下午12:53
   */
  List<Notice> getNoticeByMap(Map<String, Object> conditions);

  /**
   * 更新通知
   *
   * @param notice 通知
   * @author suwen
   * @return 执行状态
   * @date 2020/8/24 下午12:53
   */
  boolean updateNotice(Notice notice);

  /**
   * 删除通知
   *
   * @param nid 通知编号
   * @author suwen
   * @return 执行状态
   * @date 2020/8/24 下午12:53
   */
  boolean removeNotice(Integer nid);
}
