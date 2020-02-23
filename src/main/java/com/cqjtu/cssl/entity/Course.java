package com.cqjtu.cssl.entity;

import lombok.Data;

/**
 * 课程实体类
 *
 * @author Aplin suwen
 * @date 2020/1/13 10:31 上午
 */
@Data
public class Course {

  /** 课程编号 */
  private int courseID;
  /** 课程名字 */
  private String courseName;
}
