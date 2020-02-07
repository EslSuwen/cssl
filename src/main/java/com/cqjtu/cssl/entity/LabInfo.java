package com.cqjtu.cssl.entity;

/**
 * 实验室信息实体类
 *
 * @author: Aplin
 * @time: 2020/1/13 10:25 上午
 */
public class LabInfo {
  // 实验室编号
  String labId;
  // 实验室负责人ID
  String tId;
  // 实验室类型ID
  int typeId;
  // 实验室名称
  String labName;
  // 校区
  String labCampus;
  // 人数容量
  int labCap;
  // 实验室面积
  double labArea;

  public LabInfo() {}

  public LabInfo(
      String labId,
      String tId,
      int typeId,
      String labName,
      String labCampus,
      int labCap,
      double labArea) {
    this.labId = labId;
    this.tId = tId;
    this.typeId = typeId;
    this.labName = labName;
    this.labCampus = labCampus;
    this.labCap = labCap;
    this.labArea = labArea;
  }

  @Override
  public String toString() {
    return "LabInfo{"
        + "labId="
        + labId
        + ", tId="
        + tId
        + ", typeId="
        + typeId
        + ", labName="
        + labName
        + ", labCampus='"
        + labCampus
        + ", labCap="
        + labCap
        + ", labArea="
        + labArea
        + '}';
  }

  public String getLabId() {
    return labId;
  }

  public void setLabId(String labId) {
    this.labId = labId;
  }

  public String gettId() {
    return tId;
  }

  public void settId(String tId) {
    this.tId = tId;
  }

  public int getTypeId() {
    return typeId;
  }

  public void setTypeId(int typeId) {
    this.typeId = typeId;
  }

  public String getLabName() {
    return labName;
  }

  public void setLabName(String labName) {
    this.labName = labName;
  }

  public String getLabCampus() {
    return labCampus;
  }

  public void setLabCampus(String labCampus) {
    this.labCampus = labCampus;
  }

  public int getLabCap() {
    return labCap;
  }

  public void setLabCap(int labCap) {
    this.labCap = labCap;
  }

  public double getLabArea() {
    return labArea;
  }

  public void setLabArea(double labArea) {
    this.labArea = labArea;
  }
}
