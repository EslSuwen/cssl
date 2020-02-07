package com.cqjtu.cssl.entity;

/**
 * 实验室安排实体类
 *
 * @author: Aplin
 * @time: 2020/1/13 10:23 上午
 */
public class CourseArrange {
  // 开课星期
  private int labDay;
  // 开课节次
  private String labSession;
  // 课程名称
  private String courseName;
  // 实验室楼、房号
  private String labID;

  public CourseArrange() {}

  public CourseArrange(int labDay, String labSession, String courseName, String labID) {
    this.labDay = labDay;
    this.labSession = labSession;
    this.courseName = courseName;
    this.labID = labID;
  }

  public int getLabDay() {
    return labDay;
  }

  public void setLabDay(int labDay) {
    this.labDay = labDay;
  }

  public String getLabSession() {
    return labSession;
  }

  public void setLabSession(String labSession) {
    this.labSession = labSession;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getLabID() {
    return labID;
  }

  public void setLabID(String labID) {
    this.labID = labID;
  }

  @Override
  public String toString() {
    return "CourseArrange{"
        + "labDay="
        + labDay
        + ", labSession='"
        + labSession
        + '\''
        + ", courseName='"
        + courseName
        + '\''
        + ", labID='"
        + labID
        + '\''
        + '}';
  }
}
