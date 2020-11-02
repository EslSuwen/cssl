package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.entity.ExpFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

  /**
   * 保存文件信息
   *
   * @param expFile 文件信息
   * @param file 文件
   * @return 执行结果
   * @author suwen
   * @date 2020/7/8 上午9:30
   */
  boolean saveFile(ExpFile expFile, MultipartFile file) throws IOException;
}
