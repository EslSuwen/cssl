package com.cqjtu.cssl.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
@EqualsAndHashCode(of = {"classId"})
@Accessors(chain = true)
public class Class implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId
  @ApiModelProperty(value = "班级编号")
  private Integer classId;

  @ApiModelProperty(value = "年级")
  private Integer grade;

  @ApiModelProperty(value = "班级名称", required = true)
  private String className;

  @ApiModelProperty(value = "专业Id", required = true)
  private Integer majorId;

  @ApiModelProperty(value = "班级人数", required = true)
  private Integer studentNum;
}
