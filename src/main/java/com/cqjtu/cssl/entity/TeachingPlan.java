package com.cqjtu.cssl.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * TeachingPlan 教学计划执行表
 *
 * @author suwen
 * @date 2020/5/13 下午2:27
 */
@ApiModel(description = "教学计划执行表实体")
@Data
public class TeachingPlan implements Serializable {
  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "实验室名称", position = 3, required = true)
  private String labName;

  @ApiModelProperty(value = "面向专业", position = 5, required = true)
  private String expMajor;

  @ApiModelProperty(value = "班级", position = 5, required = true)
  private String labClass;

  @ApiModelProperty(value = "实验课程名", position = 2, required = true)
  private String expCname;

  @ApiModelProperty(value = "课程编号", position = 12, required = true)
  private String courseId;

  @ApiModelProperty(value = "实验总学时", position = 7, required = true)
  private Integer expTime;

  @ApiModelProperty(value = "课程起始周", position = 7, required = true)
  private String coursePeriod;

  @ApiModelProperty(value = "开课学院", position = 2, required = true)
  private String courseCollege;

  @ApiModelProperty(value = "实验室校区", position = 3, required = true)
  private String campus;

  @ApiModelProperty(value = "任课教师姓名", position = 1, required = true)
  private String tname;

  @ApiModelProperty(value = "课程类型", position = 2, required = true)
  private String courseType;

  @ApiModelProperty(value = "备注", position = 9, required = true)
  private String labRemark;
}
