package com.cqjtu.cssl.entity;

/**
 * 课程实体类
 *
 * @author: Aplin
 * @time: 2020/1/13 10:31 上午
 */
public class Course {

  /** 课程编号 */
  private int courseID;
  /** 课程名字 */
  private String courseName;

  public Course() {}

  public Course(int courseID, String courseName) {
    this.courseID = courseID;
    this.courseName = courseName;
  }

  public int getCourseID() {
    return courseID;
  }

  public void setCourseID(int courseID) {
    this.courseID = courseID;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }
}
