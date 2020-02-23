package com.cqjtu.cssl.entity;

import lombok.Data;

/**
 * 实验室安排实体类
 *
 * @author Aplin suwen
 * @date 2020/1/13 10:23 上午
 */
@Data
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
}
