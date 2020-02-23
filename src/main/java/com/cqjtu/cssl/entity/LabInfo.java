package com.cqjtu.cssl.entity;

import lombok.Data;

/**
 * 实验室信息实体类
 *
 * @author Aplin suwen
 * @date 2020/1/13 10:25 上午
 */
@Data
public class LabInfo {
  // 实验室编号
  String labId;
  // 实验室负责人ID
  String tId;
  // 实验室类型ID
  int typeId;
  // 实验室名称
  String labName;
  // 校区
  String labCampus;
  // 人数容量
  int labCap;
  // 实验室面积
  double labArea;
}
