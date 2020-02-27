package com.cqjtu.cssl.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 实验室类型实体类
 *
 * @author suwen
 * @since 2020-02-27
 */
@ApiModel(description = "实验室类型实体")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LabType implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "实验室类型编号", required = true)
  private Integer typeId;

  @ApiModelProperty(value = "实验室类型名称", position = 1, required = true)
  private String typeName;
}
