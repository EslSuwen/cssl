package com.cqjtu.cssl.constant;

/**
 * AuthorityName 用户权限枚举
 *
 * @author suwen
 * @date 2020/2/24 下午1:36
 */
public enum AuthorityName {
  /** 权限为普通用户 */
  ROLE_USER(0),

  /** 权限为管理员用户 */
  ROLE_ADMIN(1),

  /** 权限为超级管理员用户 */
  ROLE_SUPER_ADMIN(2);

  private final int value;

  AuthorityName(int value) { // 必须是private的，否则编译错误
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public static AuthorityName valueOf(int value) { // 手写的从int到enum的转换函数
    switch (value) {
      case 0:
        return ROLE_USER;
      case 1:
        return ROLE_ADMIN;
      case 2:
        return ROLE_SUPER_ADMIN;
      default:
        return null;
    }
  }
}
