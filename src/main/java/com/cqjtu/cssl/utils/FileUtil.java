package com.cqjtu.cssl.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件保存工具类
 *
 * @author suwen
 * @date 2020/8/29 下午11:01
 */
public final class FileUtil {
  /**
   * 静态方法：三个参数：文件的二进制，文件路径，文件名 通过该方法将在指定目录下添加指定文件
   *
   * @param file 文件字节流
   * @param fileName 文件名
   * @param filePath 文件保存路径
   * @author suwen
   * @date 2020/8/29 下午11:01
   */
  public static void fileupload(byte[] file, String filePath, String fileName) throws IOException {
    // 目标目录
    File targetFile = new File(filePath);
    if (!targetFile.exists()) {
      targetFile.mkdirs();
    }

    // 二进制流写入
    FileOutputStream out = new FileOutputStream(filePath + fileName);
    out.write(file);
    out.flush();
    out.close();
  }
}
