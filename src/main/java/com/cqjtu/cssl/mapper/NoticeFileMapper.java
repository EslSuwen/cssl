package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.NoticeFile;

import java.util.List;

/**
 * 通知文件 Mapper 接口
 *
 * @author suwen
 * @since 2020-08-28
 */
public interface NoticeFileMapper extends BaseMapper<NoticeFile> {

  /**
   * 获取文件列表（除文件）
   *
   * @return 文件列表
   * @author suwen
   * @date 2020/8/28 上午10:34
   */
  List<NoticeFile> getAllNoticeFile();
}
