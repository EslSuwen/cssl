package com.cqjtu.cssl.entity;

import lombok.Data;

/**
 * 实验项目实体
 *
 * @author suwen
 * @date 2020/2/6 3:19 下午
 */
@Data
public class ProjectItem {
  // 实验项目编号
  private String iId;
  // 项目ID
  private int proId;
  // 实验项目名称
  private String iName;
  // 实验类型
  private String iType;
  // 实验项目学时
  private int iTime;
  // 必修或选修
  private String cType;
  // 分组人数
  private int num;
  // 实验目的
  private String intend;
}
