package com.cqjtu.cssl.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 排课班级实体
 *
 * @author suwen
 * @since 2020-02-21
 */
@ApiModel(description = "排课班级实体")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ArrangeClass implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 实验室排课编号 */
  @ApiModelProperty(value = "项目编号", required = true)
  private Integer aid;

  /** 实验室编号 */
  @ApiModelProperty(value = "班级编号", required = true)
  private Integer classId;
}
