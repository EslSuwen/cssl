package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.entity.ExpFileStore;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 项目资料存储服务类
 *
 * @author suwen
 * @since 2020-07-07
 */
public interface ExpFileStoreService extends IService<ExpFileStore> {

  /**
   * 保存文件信息
   *
   * @param expFileStore 文件信息
   * @exception Exception typeName
   * @return 执行结果
   * @author suwen
   * @date 2020/7/8 上午9:30
   */
  boolean saveFile(ExpFileStore expFileStore) throws Exception;

  /**
   * 获取文件储存信息除文件
   *
   * @param proId 卡片编号
   * @return 件储存信息
   * @author suwen
   * @date 2020/7/8 下午1:38
   */
  List<ExpFileStore> getQuickFile(Integer proId);
}
