package com.cqjtu.cssl.entity;

import lombok.Data;

/**
 * 授课班级实体类
 *
 * @author Aplin suwen
 * @date 2020/1/13 10:27 上午
 */
@Data
public class TeachClass {
  // 教职工号
  private String tid;
  // 课程号
  private int courseID;
  // 班级名称
  private String className;
  // 专业号
  private int majorID;
}
