package com.cqjtu.cssl.entity;

/**
 * 专业实体类
 *
 * @author Aplin
 * @date 2020/1/13 10:25 上午
 */
public class Major {
  // 专业ID
  private int majorID;
  // 专业名称
  private String majorName;

  public Major() {}

  public Major(int majorID, String majorName) {
    this.majorID = majorID;
    this.majorName = majorName;
  }

  public int getMajorID() {
    return majorID;
  }

  public void setMajorID(int majorID) {
    this.majorID = majorID;
  }

  public String getManjorName() {
    return majorName;
  }

  public void setManjorName(String manjorName) {
    this.majorName = manjorName;
  }

  @Override
  public String toString() {
    return "Major{" + "majorID=" + majorID + ", manjorName='" + majorName + '\'' + '}';
  }
}
