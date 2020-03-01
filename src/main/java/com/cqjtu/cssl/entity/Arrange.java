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

  /** 教职工号 */
  @ApiModelProperty(value = "教职工号", position = 3, required = true)
  private String tid;

  /** 课程号 */
  @ApiModelProperty(value = "课程号", position = 4, required = true)
  private Integer courseId;

  /** 班级 */
  @ApiModelProperty(value = "班级", position = 5, required = true)
  private String labClass;

  /** 备注 */
  @ApiModelProperty(value = "备注", position = 6, required = true)
  private String labRemark;

  /** 排课时间 */
  @ApiModelProperty(value = "排课时间", position = 7, required = true)
  @TableField(exist = false)
  private List<ArrangePeriod> arrangePeriod;
}
