package com.cqjtu.cssl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
public class ArrangeClass implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 实验室排课编号 */
  @ApiModelProperty(value = "项目编号", required = true)
  private Integer proId;

  /** 实验室编号 */
  @ApiModelProperty(value = "班级编号", required = true)
  private Integer classId;
}
