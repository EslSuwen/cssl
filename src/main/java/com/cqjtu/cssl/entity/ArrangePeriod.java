package com.cqjtu.cssl.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 实验室安排上课时间实体
 *
 * @author suwen
 * @since 2020-02-21
 */
@ApiModel(description = "实验室安排上课时间")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ArrangePeriod implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 实验室排课编号 */
  @ApiModelProperty(value = "实验室排课编号", required = true)
  private Integer aid;

  /** 开课周次 */
  @ApiModelProperty(value = "开课周次", position = 1, required = true)
  private Integer labWeek;

  /** 开课星期 */
  @ApiModelProperty(value = "开课星期", position = 2, required = true)
  private Integer labDay;

  /** 开课节次 */
  @ApiModelProperty(value = "开课节次", position = 3, required = true)
  private Integer labSession;

}
