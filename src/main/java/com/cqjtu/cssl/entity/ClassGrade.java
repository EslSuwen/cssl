package com.cqjtu.cssl.entity;

/**
 * 班级实体类
 *
 * @author Aplin
 * @date 2020/1/13 10:21 上午
 */
public class ClassGrade {
  // 班级名称
  private String className;
  // 专业ID
  private int majorID;
  // 班级人数
  private int classNum;

  public ClassGrade() {}

  public ClassGrade(String className, int majorID, int classNum) {
    this.className = className;
    this.majorID = majorID;
    this.classNum = classNum;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public int getMajorID() {
    return majorID;
  }

  public void setMajorID(int majorID) {
    this.majorID = majorID;
  }

  public int getClassNum() {
    return classNum;
  }

  public void setClassNum(int classNum) {
    this.classNum = classNum;
  }

  @Override
  public String toString() {
    return "ClassGrade{"
        + "className='"
        + className
        + '\''
        + ", majorID="
        + majorID
        + ", classNum="
        + classNum
        + '}';
  }
}
