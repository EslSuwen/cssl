package com.cqjtu.cssl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 实验室安排实体
 *
 * @author suwen
 * @since 2020-02-21
 */
@ApiModel(description = "实验室安排实体")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Arrange implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 实验室排课编号 */
  @ApiModelProperty(value = "实验室排课编号")
  @TableId(value = "aid", type = IdType.AUTO)
  private Integer aid;

  /** 实验室编号 */
  @ApiModelProperty(value = "实验室编号", position = 1, required = true)
  private String labId;

  /** 项目ID */
  @ApiModelProperty(value = "项目ID", position = 2, required = true)
  private Integer proId;

  /** 实验室校区 */
  @ApiModelProperty(value = "实验室校区", position = 3, required = true)
  private String campus;

  /** 申请状态 */
  @ApiModelProperty(value = "申请状态", position = 4, required = true)
  private Integer status;

  /** 班级 */
  @ApiModelProperty(value = "班级", position = 5, required = true)
  private String labClass;

  @ApiModelProperty(value = "课程编号", position = 6, required = true)
  private String courseId;

  @ApiModelProperty(value = "教职工号", position = 7, required = true)
  private String tid;

  /** 实验项目名称 */
  @ApiModelProperty(value = "实验项目名称", position = 8)
  private String expProname;

  /** 备注 */
  @ApiModelProperty(value = "备注", position = 9, required = true)
  private String labRemark;

  /** 排课时间 */
  @ApiModelProperty(value = "排课时间", position = 10, required = true)
  @TableField(exist = false)
  private List<ArrangePeriod> arrangePeriod;
}
