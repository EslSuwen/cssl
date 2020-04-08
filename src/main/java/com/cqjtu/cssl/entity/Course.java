package com.cqjtu.cssl.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 课程实体类
 *
 * @author suwen Aplin
 * @since 2020-02-27
 */
@ApiModel(description = "课程实体类")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Course implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "课程编号", required = true)
  @TableId
  private Integer courseId;

  @ApiModelProperty(value = "课程名字", position = 1, required = true)
  private String courseName;
}
