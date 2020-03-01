package com.cqjtu.cssl.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 授课实体类
 *
 * @author suwen Aplin
 * @since 2020-02-27
 */
@ApiModel(description = "授课实体")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Teach implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "教职工号", required = true)
  private String tid;

  @ApiModelProperty(value = "课程号", position = 1, required = true)
  private Integer courseId;

  @ApiModelProperty(value = "实验室申请权限", position = 2, required = true)
  private Integer applyLimit;

  /** 课程名 */
  @ApiModelProperty(value = "课程名", position = 3, required = true)
  @TableField(exist = false)
  private String courseName;

  /** 课程实验室申请状态 */
  @ApiModelProperty(value = "课程实验室申请状态", position = 4)
  @TableField(exist = false)
  private String status;

  /** 课程实验室编号 */
  @ApiModelProperty(value = "课程实验室编号", position = 5)
  @TableField(exist = false)
  private String labId;
}
