package com.cqjtu.cssl.entity;

/**
 * 模板类
 *
 * @author Aplin
 * @date 2020/1/13 10:24 上午
 */
public class LabArrangeShow {
  // 实验室（中心）名称
  private String labCenName;
  // 开课周次
  private int labWeek;
  // 开课星期
  private int labDay;
  // 开课节次
  private String labSession;
  // 课程名称
  private String courseName;
  // 实验项目名称
  private String expProName;
  // 专业
  private String majorName;
  // 年级、班
  private String className;
  // 指导老师
  private String tname;
  // 实验室楼、房号
  private String labID;
  // 校区
  private String labCampus;
  // 备注
  private String labRemark;

  public LabArrangeShow() {}

  public LabArrangeShow(
      String labCenName,
      int labWeek,
      int labDay,
      String labSession,
      String courseName,
      String expProName,
      String majorName,
      String className,
      String tname,
      String labID,
      String labCampus,
      String labRemark) {
    this.labCenName = labCenName;
    this.labWeek = labWeek;
    this.labDay = labDay;
    this.labSession = labSession;
    this.courseName = courseName;
    this.expProName = expProName;
    this.majorName = majorName;
    this.className = className;
    this.tname = tname;
    this.labID = labID;
    this.labCampus = labCampus;
    this.labRemark = labRemark;
  }

  public String getLabCenName() {
    return labCenName;
  }

  public void setLabCenName(String labCenName) {
    this.labCenName = labCenName;
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

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getExpProName() {
    return expProName;
  }

  public void setExpProName(String expProName) {
    this.expProName = expProName;
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

  public String getTname() {
    return tname;
  }

  public void setTname(String tname) {
    this.tname = tname;
  }

  public String getLabID() {
    return labID;
  }

  public void setLabID(String labID) {
    this.labID = labID;
  }

  public String getLabCampus() {
    return labCampus;
  }

  public void setLabCampus(String labCampus) {
    this.labCampus = labCampus;
  }

  public String getLabRemark() {
    return labRemark;
  }

  public void setLabRemark(String labRemark) {
    this.labRemark = labRemark;
  }

  @Override
  public String toString() {
    return "LabArrangeShow{"
        + "labCenName='"
        + labCenName
        + '\''
        + ", labWeek="
        + labWeek
        + ", labDay="
        + labDay
        + ", labSession='"
        + labSession
        + '\''
        + ", courseName='"
        + courseName
        + '\''
        + ", expProName='"
        + expProName
        + '\''
        + ", majorName='"
        + majorName
        + '\''
        + ", className='"
        + className
        + '\''
        + ", tname='"
        + tname
        + '\''
        + ", labID='"
        + labID
        + '\''
        + ", labCampus='"
        + labCampus
        + '\''
        + ", labRemark='"
        + labRemark
        + '\''
        + '}';
  }
}
