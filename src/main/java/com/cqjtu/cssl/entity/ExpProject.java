package com.cqjtu.cssl.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 项目(实验卡片)实体类
 *
 * @author suwen Aplin
 * @since 2020-02-27
 */
@ApiModel(description = "项目实体")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ExpProject implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "项目ID", required = true)
  private Integer proId;

  @ApiModelProperty(value = "实验室（中心）名称", position = 1, required = true)
  private String labCenName;

  @ApiModelProperty(value = "实验课程名", position = 2, required = true)
  private String expCname;

  @ApiModelProperty(value = "实验设备名", position = 3, required = true)
  private String expEqname;

  @ApiModelProperty(value = "设备数量", position = 4, required = true)
  private Integer eqnum;

  @ApiModelProperty(value = "面向专业", position = 5, required = true)
  private String expMajor;

  @ApiModelProperty(value = "学生类别", position = 6, required = true)
  private String ssort;

  @ApiModelProperty(value = "实验总学时", position = 7, required = true)
  private Integer expTime;

  @ApiModelProperty(value = "实验教材", position = 8, required = true)
  private String book;

  @ApiModelProperty(value = "实验所用软件", position = 9, required = true)
  private String software;

  @ApiModelProperty(value = "教职工号", position = 10, required = true)
  private String expTid;

  @ApiModelProperty(value = "课程名", position = 11, required = true)
  private String cname;

  @ApiModelProperty(value = "课程编号", position = 12, required = true)
  private String courseId;

  @ApiModelProperty(value = "消耗材料名称", position = 13)
  private String conName;

  @ApiModelProperty(value = "消耗材料数量", position = 14)
  private Integer conNum;
}
