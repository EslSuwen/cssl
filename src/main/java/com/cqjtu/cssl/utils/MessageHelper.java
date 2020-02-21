package com.cqjtu.cssl.utils;

/**
 * message 辅助类
 *
 * @author suwen
 * @date 2020/2/6 4:06 下午
 */
public class MessageHelper {

  // Message 类不需要往数据库里存放，不用标识为@Entity。只需建立
  // 数据模型类即可
  private String msg;

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }
}
