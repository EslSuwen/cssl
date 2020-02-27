package com.cqjtu.cssl.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 专业实体类
 *
 * @author suwen Aplin
 * @since 2020-02-27
 */
@ApiModel(description = "专业实体")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Major implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "专业ID", position = 1, required = true)
  private Integer majorId;

  @ApiModelProperty(value = "专业名称", position = 1, required = true)
  private String majorName;
}
