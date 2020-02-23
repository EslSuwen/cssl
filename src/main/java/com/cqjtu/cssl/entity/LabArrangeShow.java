package com.cqjtu.cssl.entity;

import lombok.Data;

/**
 * 模板类
 *
 * @author Aplin suwen
 * @date 2020/1/13 10:24 上午
 */
@Data
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
}
