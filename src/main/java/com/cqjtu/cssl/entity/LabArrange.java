package com.cqjtu.cssl.entity;

/**
 * 实验室安排实体类
 *
 * @author Aplin
 * @date 2020/1/13 10:23 上午
 */
public class LabArrange {
  // 开课周次
  int labWeek;
  // 开课星期
  int labDay;
  // 开课节次
  String labSession;
  // 实验室编号
  String labId;
  // 项目ID
  int proId;
  // 教职工号
  String tId;
  // 课程号
  int courseId;
  // 班级
  String labClass;
  // 备注
  String labRemark;
  // 实验项目名称
  String expProname;

  public LabArrange() {}

  public LabArrange(
      int labWeek,
      int labDay,
      String labSession,
      String labId,
      int proId,
      String tId,
      int courseId,
      String labClass,
      String labRemark,
      String expProname) {
    this.labWeek = labWeek;
    this.labDay = labDay;
    this.labSession = labSession;
    this.labId = labId;
    this.proId = proId;
    this.tId = tId;
    this.courseId = courseId;
    this.labClass = labClass;
    this.labRemark = labRemark;
    this.expProname = expProname;
  }

  public String getExpProname() {
    return expProname;
  }

  public void setExpProname(String expProname) {
    this.expProname = expProname;
  }

  public int getLabWeek() {
    return labWeek;
  }

  public void setLabWeek(int labWeek) {
    this.labWeek = labWeek;
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

  public String getLabId() {
    return labId;
  }

  public void setLabId(String labId) {
    this.labId = labId;
  }

  public int getProId() {
    return proId;
  }

  public void setProId(int proId) {
    this.proId = proId;
  }

  public String gettId() {
    return tId;
  }

  public void settId(String tId) {
    this.tId = tId;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public String getLabClass() {
    return labClass;
  }

  public void setLabClass(String labClass) {
    this.labClass = labClass;
  }

  public String getLabRemark() {
    return labRemark;
  }

  public void setLabRemark(String labRemark) {
    this.labRemark = labRemark;
  }
}
