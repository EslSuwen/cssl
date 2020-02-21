package com.cqjtu.cssl.entity;

/**
 * 教师实体类
 *
 * @author Aplin
 * @date 2020/1/13 10:27 上午
 */
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

  public Teacher() {}

  public Teacher(
      String tID,
      String tName,
      String tPhone,
      String tQQ,
      String tEmail,
      int tLimit,
      String tPassword) {
    this.tID = tID;
    this.tName = tName;
    this.tPhone = tPhone;
    this.tQQ = tQQ;
    this.tEmail = tEmail;
    this.tLimit = tLimit;
    this.tPassword = tPassword;
  }

  public String gettPassword() {
    return tPassword;
  }

  public void settPassword(String tPassword) {
    this.tPassword = tPassword;
  }

  public String gettID() {
    return tID;
  }

  public void settID(String tID) {
    this.tID = tID;
  }

  public String gettName() {
    return tName;
  }

  public void settName(String tName) {
    this.tName = tName;
  }

  public String gettPhone() {
    return tPhone;
  }

  public void settPhone(String tPhone) {
    this.tPhone = tPhone;
  }

  public String gettQQ() {
    return tQQ;
  }

  public void settQQ(String tQQ) {
    this.tQQ = tQQ;
  }

  public String gettEmail() {
    return tEmail;
  }

  public void settEmail(String tEmail) {
    this.tEmail = tEmail;
  }

  public int gettLimit() {
    return tLimit;
  }

  public void setytLimit(int tLimit) {
    this.tLimit = tLimit;
  }

  public String toString() {
    return "id="
        + tID
        + ", name="
        + tName
        + ", phone="
        + tPhone
        + ", QQ="
        + tQQ
        + ",email="
        + tEmail
        + ",password="
        + tPassword
        + ",limit="
        + tLimit;
  }
}
