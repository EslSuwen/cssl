package com.cqjtu.cssl.entity;

/**
 * 授课实体类
 *
 * @author: Aplin
 * @time: 2020/1/13 10:27 上午
 */
public class Teach {
  // 教职工号
  private String tid;
  // 课程号
  private int courseID;
  // 实验室申请权限
  private int applyLimit;

  public Teach() {}

  public Teach(String tid, int courseID) {
    this.tid = tid;
    this.courseID = courseID;
    this.applyLimit = 0;
  }

  public Teach(String tid, int courseID, int applyLimit) {
    this.tid = tid;
    this.courseID = courseID;
    this.applyLimit = applyLimit;
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

  public int isApplyLimit() {
    return applyLimit;
  }

  public void setApplyLimit(int applyLimit) {
    this.applyLimit = applyLimit;
  }

  @Override
  public String toString() {
    return "TeachClass{"
        + "tid='"
        + tid
        + '\''
        + ", courseID="
        + courseID
        + ", applyLimit="
        + applyLimit
        + '}';
  }
}
