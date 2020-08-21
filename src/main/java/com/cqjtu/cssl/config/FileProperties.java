package com.cqjtu.cssl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 自定义文件配置类
 *
 * @author suwen
 * @date 2020/8/10 下午1:32
 */
@ConfigurationProperties(prefix = "file")
public class FileProperties {
  private String fileDir;

  public String getFileDir() {
    return fileDir;
  }

  public void setFileDir(String fileDir) {
    this.fileDir = fileDir;
  }
}
