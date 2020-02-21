package com.cqjtu.cssl.entity;

/**
 * 授课班级实体类
 *
 * @author Aplin
 * @date 2020/1/13 10:27 上午
 */
public class TeachClass {
  // 教职工号
  private String tid;
  // 课程号
  private int courseID;
  // 班级名称
  private String className;
  // 专业号
  private int majorID;

  public TeachClass() {}

  public TeachClass(String tid, int courseID, String className, int majorID) {
    this.tid = tid;
    this.courseID = courseID;
    this.className = className;
    this.majorID = majorID;
  }

  public String getTid() {
    return tid;
  }

  public void setTid(String tid) {
    this.tid = tid;
  }

  public int getCourseID() {
    return courseID;
  }

  public void setCourseID(int courseID) {
    this.courseID = courseID;
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

  @Override
  public String toString() {
    return "TeachClass{"
        + "tid='"
        + tid
        + '\''
        + ", courseID="
        + courseID
        + ", className='"
        + className
        + '\''
        + ", majorID="
        + majorID
        + '}';
  }
}
