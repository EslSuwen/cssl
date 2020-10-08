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

  @ApiModelProperty(value = "教职工名")
  @TableField(exist = false)
  private String tname;

  @ApiModelProperty(value = "课程名")
  @TableField(exist = false)
  private String courseName;
}
