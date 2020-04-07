package com.cqjtu.cssl.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 教师授课班级实体类
 *
 * @author suwen Aplin
 * @since 2020-02-27
 */
@ApiModel(description = "教师授课班级实体")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Teachclass implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "教师编号", required = true)
  private String tid;

  @ApiModelProperty(value = "课程编号", position = 1, required = true)
  private Integer courseId;

  @ApiModelProperty(value = "班级名", position = 2, required = true)
  private String className;

  @ApiModelProperty(value = "专业编号", position = 3, required = true)
  private Integer majorId;
}
