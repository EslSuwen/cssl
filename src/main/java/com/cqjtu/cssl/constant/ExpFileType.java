package com.cqjtu.cssl.constant;

/**
 * ExpFileType 实验文件类型常量
 *
 * @author suwen
 * @date 2020/11/2 13:24
 */
public enum ExpFileType {

  /** 考勤名单 */
  attend(0, "考勤名单"),

  /** 实验任务书 */
  task(1, "实验任务书"),

  /** 实验成绩 */
  grade(2, "实验成绩"),

  /** 实验报告 */
  report(3, "实验报告"),

  /** 评分标准表 */
  scheme(4, "评分标准表");

  /** 类型编号 */
  private final Integer typeId;

  /** 类型名称 */
  private final String typeName;

  ExpFileType(Integer typeId, String typeName) {
    this.typeId = typeId;
    this.typeName = typeName;
  }

  public static String convertName(Integer typeId) {
    for (ExpFileType each : ExpFileType.values()) {
      if (each.typeId.equals(typeId)) {
        return each.typeName;
      }
    }
    throw new IllegalArgumentException("输入错误的类型编号！");
  }
}
