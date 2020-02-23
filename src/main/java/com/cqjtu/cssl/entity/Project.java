package com.cqjtu.cssl.entity;

import lombok.Data;

/**
 * 项目实体
 *
 * @author suwen
 * @date 2020/2/6 3:18 下午
 */
@Data
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
}
