package com.cqjtu.cssl.entity;

import lombok.Data;

/**
 * 班级实体类
 *
 * @author Aplin suwen
 * @date 2020/1/13 10:21 上午
 */
@Data
public class ClassGrade {

  // 班级名称
  private String className;
  // 专业ID
  private int majorID;
  // 班级人数
  private int classNum;
}
