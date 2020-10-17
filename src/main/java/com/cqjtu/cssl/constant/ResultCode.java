package com.cqjtu.cssl.constant;

/**
 * ReturnCode http 返回码
 *
 * @author suwen
 * @date 2020/5/25 上午9:00
 */
public enum ResultCode {

  /** 成功状态码 */
  SUCCESS(1, "成功"),
  /** 成功状态码：1001-1999 */
  SUCCESS_LOGIN(1001, "登录成功"),
  SUCCESS_GET_DATA(1002, "获取数据成功"),
  SUCCESS_ADD_DATA(1003, "新增数据成功"),
  SUCCESS_UPDATE_DATA(1004, "更新数据成功"),
  SUCCESS_DELETE_DATA(1005, "删除数据成功"),
  SUCCESS_UPLOAD_DATA(1006, "上传数据成功"),

  /** 客户端错误：2001-2999 */
  USER_NOT_EXIST(2001, "不存在该账号"),
  USER_NOT_LOGGED_IN(2002, "未登录"),
  USER_LOGIN_ERROR(2003, "密码错误"),
  PARAM_ERROR(2004, "参数错误"),
  USER_ERROR(2999, "客户端错误"),

  /** 服务器错误消息:3001-3999 */
  REDIS_TIME_OUT(3001,"Redis缓存连接超时"),
  SERVER_ERROR(3999, "服务端错误");

  private final Integer code;
  private final String message;

  ResultCode(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }
}
