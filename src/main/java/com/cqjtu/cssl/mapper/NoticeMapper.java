package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.Notice;

import java.util.List;

/**
 * 通知信息表，通知由管理员发布。 Mapper 接口
 *
 * @author suwen
 * @since 2020-08-24
 */
public interface NoticeMapper extends BaseMapper<Notice> {
  /**
   * 通过编号查找通知
   *
   * @param nid 通知编号
   * @author suwen
   * @return 通知信息
   * @date 2020/8/24 下午12:53
   */
  Notice getById(Integer nid);

  /**
   * 查找所有通知
   *
   * @author suwen
   * @return 通知信息列表
   * @date 2020/8/24 下午12:53
   * @param noticeType 通知类型
   */
  List<Notice> list(String noticeType);
}
