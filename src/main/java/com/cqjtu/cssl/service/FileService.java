package com.cqjtu.cssl.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务
 *
 * @author suwen
 * @date 2020/8/10 下午1:28
 */
public interface FileService {

  /**
   * 存储文件到系统
   *
   * @param file 文件
   * @return 文件名
   */
  String storeFile(MultipartFile file);

  /**
   * 存储文件到系统
   *
   * @param file 文件
   * @param path 路径
   * @return 文件名
   */
  String storeFile(MultipartFile file, String path);

  /**
   * 加载文件
   *
   * @param fileName 文件名
   * @return 文件
   */
  Resource loadFileAsResource(String fileName);
}
