package com.cqjtu.cssl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.cqjtu.cssl.constant.Audit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 项目(实验卡片)
 *
 * @author suwen
 * @since 2020-10-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "ExpProject对象", description = "项目(实验卡片)")
public class ExpProject implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "项目编号")
  @TableId(value = "pro_id", type = IdType.AUTO)
  private Integer proId;

  @ApiModelProperty(value = "实验课程名")
  private String expCname;

  @ApiModelProperty(value = "实验设备名")
  private String expEqname;

  @ApiModelProperty(value = "设备数量")
  private Integer eqnum;

  @ApiModelProperty(value = "实验总学时")
  private Integer expTime;

  @ApiModelProperty(value = "实验教材")
  private String book;

  @ApiModelProperty(value = "实验所用软件")
  private String software;

  @ApiModelProperty(value = "授课教师编号")
  private String expTid;

  @ApiModelProperty(value = "申请实验室状态")
  private Audit labStatus;

  @ApiModelProperty(value = "消耗材料名称")
  private String conName;

  @ApiModelProperty(value = "消耗材料数量")
  private Integer conNum;

  @ApiModelProperty(value = "课程编号")
  private Integer courseId;

  @ApiModelProperty(value = "学期")
  private String term;

  @ApiModelProperty(value = "实验课程名")
  @TableField(exist = false)
  private String courseName;
}
