package com.cqjtu.cssl.entity;

import lombok.Data;

/**
 * 教师实体类
 *
 * @author Aplin suwen
 * @date 2020/1/13 10:27 上午
 */
@Data
public class Teacher {
  // 教职工号
  private String tID;
  // 教师姓名
  private String tName;
  // 教师电话
  private String tPhone;
  // 教师QQ
  private String tQQ;
  // 教师邮箱
  private String tEmail;
  // 权限（是否为管理员）
  private int tLimit;
  // 密码
  private String tPassword;
}
