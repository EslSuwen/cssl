package com.cqjtu.cssl.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 实验室信息实体类
 *
 * @author suwen Aplin
 * @since 2020-02-27
 */
@ApiModel(description = "实验室信息实体")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LabInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "实验室编号", required = true)
  @TableId
  private String labId;

  @ApiModelProperty(value = "实验室负责人ID", position = 1, required = true)
  private String tid;

  @ApiModelProperty(value = "实验室类型ID", position = 2, required = true)
  private Integer typeId;

  @ApiModelProperty(value = "实验室名称", position = 3, required = true)
  private String labName;

  @ApiModelProperty(value = "校区", position = 4, required = true)
  private String labCampus;

  @ApiModelProperty(value = "人数容量", position = 5, required = true)
  private Integer labCap;

  @ApiModelProperty(value = "实验室面积", position = 6, required = true)
  private BigDecimal labArea;
}
