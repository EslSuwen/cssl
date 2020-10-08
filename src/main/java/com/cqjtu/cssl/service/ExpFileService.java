package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.entity.ExpFile;

/**
 * 项目资料关联服务类
 *
 * @author suwen
 * @since 2020-07-07
 */
public interface ExpFileService extends IService<ExpFile> {

  /**
   * 获得文件状态
   *
   * @param proId 项目编号
   * @param classId 班级编号
   * @return 文件状态
   * @author suwen
   * @date 2020/7/8 上午9:18
   */
  ExpFile getFileStatus(Integer proId, Integer classId);
}
