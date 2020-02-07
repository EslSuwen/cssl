package com.cqjtu.cssl.entity;

/**
 * 专业班级查询辅助类
 *
 * @author: Aplin
 * @time: 2020/1/13 10:26 上午
 */
public class MajorClassHelper {
  // 专业名称
  private String majorName;
  // 班级名称
  private String className;
  // 班级人数
  private int classNum;

  public MajorClassHelper() {}

  public MajorClassHelper(String majorName, String className, int classNum) {
    this.majorName = majorName;
    this.className = className;
    this.classNum = classNum;
  }

  public String getMajorName() {
    return majorName;
  }

  public void setMajorName(String majorName) {
    this.majorName = majorName;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public int getClassNum() {
    return classNum;
  }

  public void setClassNum(int classNum) {
    this.classNum = classNum;
  }

  @Override
  public String toString() {
    return "MajorClassHelper{"
        + "majorName='"
        + majorName
        + '\''
        + ", className='"
        + className
        + '\''
        + ", classNum="
        + classNum
        + '}';
  }
}
