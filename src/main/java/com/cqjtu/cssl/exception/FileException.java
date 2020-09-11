package com.cqjtu.cssl.exception;

/**
 * 自定义文件异常
 *
 * @author suwen
 * @date 2020/8/10 下午1:26
 */
public class FileException extends RuntimeException {
  public FileException(String message) {
    super(message);
  }

  public FileException(String message, Throwable cause) {
    super(message, cause);
  }
}
