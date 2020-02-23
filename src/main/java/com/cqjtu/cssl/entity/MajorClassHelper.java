package com.cqjtu.cssl.entity;

import lombok.Data;

/**
 * 专业班级查询辅助类
 *
 * @author Aplin suwen
 * @date 2020/1/13 10:26 上午
 */
@Data
public class MajorClassHelper {
  // 专业名称
  private String majorName;
  // 班级名称
  private String className;
  // 班级人数
  private int classNum;
}
