package com.cqjtu.cssl.entity;
/**
 * Message 类不需要往数据库里存放，不用标识为@Entity。只需建立数据模型类即可
 *
 * @author suwen
 * @date 2020/1/31 6:02 下午
 */
public class Message {

  private String msg;

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }
}
