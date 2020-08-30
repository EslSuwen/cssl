package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.NoticeFile;

import java.io.Serializable;
import java.util.List;

/**
 * 通知文件 Mapper 接口
 *
 * @author suwen
 * @since 2020-08-28
 */
public interface NoticeFileMapper extends BaseMapper<NoticeFile> {

  /**
   * 查找所有通知文件
   *
   * @author suwen
   * @return 通知文件列表
   * @date 2020/8/30 下午13:09
   */
  List<NoticeFile> list();

  /**
   * 通过编号查找通知文件
   *
   * @param fileId 通知编号
   * @author suwen
   * @return 通知信息
   * @date 2020/8/30 下午13:08
   */
  @Override
  NoticeFile selectById(Serializable fileId);
}
