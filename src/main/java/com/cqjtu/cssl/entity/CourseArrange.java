package com.cqjtu.cssl.entity;

import lombok.Data;

/**
 * 实验室安排实体类
 *
 * @author Aplin suwen
 * @date 2020/1/13 10:23 上午
 */
@Data
public class CourseArrange {
  // 开课星期
  private int labDay;
  // 开课节次
  private String labSession;
  // 课程名称
  private String courseName;
  // 实验室楼、房号
  private String labID;
}
