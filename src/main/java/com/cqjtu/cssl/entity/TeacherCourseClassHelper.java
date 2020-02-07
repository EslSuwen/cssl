package com.cqjtu.cssl.entity;

/**
 * 教师课程班级查询辅助类
 *
 * @author: Aplin
 * @time: 2020/1/13 10:28 上午
 */
public class TeacherCourseClassHelper {
  // 教师姓名
  private String tName;
  // 课程名
  private String courseName;
  // 专业名称
  private String majorName;
  // 班级名称
  private String className;

  public TeacherCourseClassHelper() {}

  public TeacherCourseClassHelper(
      String tName, String courseName, String majorName, String className) {
    this.tName = tName;
    this.courseName = courseName;
    this.majorName = majorName;
    this.className = className;
  }

  public String gettName() {
    return tName;
  }

  public void settName(String tName) {
    this.tName = tName;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
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

  @Override
  public String toString() {
    return "TeacherCourseClassHelper{"
        + "tName='"
        + tName
        + '\''
        + ", courseName='"
        + courseName
        + '\''
        + ", majorName='"
        + majorName
        + '\''
        + ", className='"
        + className
        + '\''
        + '}';
  }
}
