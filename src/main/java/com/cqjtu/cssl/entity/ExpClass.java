package com.cqjtu.cssl.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 项目班级
 *
 * @author suwen
 * @since 2020-10-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "ExpClass对象", description = "项目班级")
public class ExpClass implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "项目编号")
  private Integer proId;

  @ApiModelProperty(value = "班级编号")
  private Integer classId;
}
