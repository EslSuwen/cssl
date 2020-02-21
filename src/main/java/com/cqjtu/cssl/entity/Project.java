package com.cqjtu.cssl.entity;

/**
 * 项目实体
 *
 * @author suwen
 * @date 2020/2/6 3:18 下午
 */
public class Project {
  // 项目ID
  private int proId;
  // 实验室（中心）名称
  private String labCenName;
  // 实验课程名
  private String expCname;
  // 实验设备名
  private String expEqname;
  // 设备数量
  private int eqNum;
  // 面向专业
  private String expMajor;
  // 学生类别
  private String sSort;
  // 实验总学时
  private int expTime;
  // 实验教材
  private String book;
  // 实验所用软件
  private String softWare;
  // 教职工号
  private String tId;
  // 课程名
  private String cName;
  // 消耗材料名称
  private String conName;
  // 消耗材料数量
  private int conNum;

  public String getConName() {
    return conName;
  }

  public void setConName(String conName) {
    this.conName = conName;
  }

  public int getConNum() {
    return conNum;
  }

  public void setConNum(int conNum) {
    this.conNum = conNum;
  }

  public Project(
      int proId,
      String labCenName,
      String expCname,
      String expEqname,
      int eqNum,
      String expMajor,
      String sSort,
      int expTime,
      String book,
      String softWare,
      String tId,
      String cName,
      String conName,
      int conNum) {
    this.proId = proId;
    this.labCenName = labCenName;
    this.expCname = expCname;
    this.expEqname = expEqname;
    this.eqNum = eqNum;
    this.expMajor = expMajor;
    this.sSort = sSort;
    this.expTime = expTime;
    this.book = book;
    this.softWare = softWare;
    this.tId = tId;
    this.cName = cName;
    this.conName = conName;
    this.conNum = conNum;
  }

  public String getCourseName() {
    return cName;
  }

  public void setCourseName(String courseName) {
    this.cName = courseName;
  }

  public String gettId() {
    return tId;
  }

  public void settId(String tId) {
    this.tId = tId;
  }

  public Project() {}

  public int getProId() {
    return proId;
  }

  public void setProId(int proId) {
    this.proId = proId;
  }

  public String getLabCenName() {
    return labCenName;
  }

  public void setLabCenName(String labCenName) {
    this.labCenName = labCenName;
  }

  public String getExpCname() {
    return expCname;
  }

  public void setExpCame(String expCname) {
    this.expCname = expCname;
  }

  public String getExpEqname() {
    return expEqname;
  }

  public void setExpEqname(String expEqname) {
    this.expEqname = expEqname;
  }

  public int getEqNum() {
    return eqNum;
  }

  public void setEqNum(int eqNum) {
    this.eqNum = eqNum;
  }

  public String getExpMajor() {
    return expMajor;
  }

  public void setExpMajor(String expMajor) {
    this.expMajor = expMajor;
  }

  public String getsSort() {
    return sSort;
  }

  public void setsSort(String sSort) {
    this.sSort = sSort;
  }

  public int getExpTime() {
    return expTime;
  }

  public void setExpTime(int expTime) {
    this.expTime = expTime;
  }

  public String getBook() {
    return book;
  }

  public void setBook(String book) {
    this.book = book;
  }

  public String getSofrWare() {
    return softWare;
  }

  public void setSofrWare(String softWare) {
    this.softWare = softWare;
  }

  @Override
  public String toString() {
    return "Project{"
        + "proId="
        + proId
        + ", labCenName='"
        + labCenName
        + '\''
        + ", expCname='"
        + expCname
        + '\''
        + ", expEqname='"
        + expEqname
        + '\''
        + ", eqNum="
        + eqNum
        + ", expMajor='"
        + expMajor
        + '\''
        + ", sSort='"
        + sSort
        + '\''
        + ", expTime="
        + expTime
        + ", book='"
        + book
        + '\''
        + ", softWare='"
        + softWare
        + '\''
        + ", tId='"
        + tId
        + '\''
        + ", cName='"
        + cName
        + '\''
        + ", conName='"
        + conName
        + '\''
        + ", conNum="
        + conNum
        + '}';
  }
}
