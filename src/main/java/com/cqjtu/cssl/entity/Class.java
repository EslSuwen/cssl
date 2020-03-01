package com.cqjtu.cssl.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 班级实体类
 *
 * @author suwen Aplin
 * @since 2020-02-27
 */
@ApiModel(description = "班级实体")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Class implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "班级名称", required = true)
  private String className;

  @ApiModelProperty(value = "专业ID", position = 1, required = true)
  private Integer majorId;

  @ApiModelProperty(value = "班级人数", position = 2, required = true)
  private Integer classNum;
}
