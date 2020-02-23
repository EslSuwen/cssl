package com.cqjtu.cssl.entity;

import lombok.Data;

/**
 * 教师课程班级查询辅助类
 *
 * @author Aplin suwen
 * @date 2020/1/13 10:28 上午
 */
@Data
public class TeacherCourseClassHelper {
  // 教师姓名
  private String tName;
  // 课程名
  private String courseName;
  // 专业名称
  private String majorName;
  // 班级名称
  private String className;
}
