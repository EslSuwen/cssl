package com.cqjtu.cssl.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 实验室安排实体类
 *
 * @author Aplin suwen
 * @date 2020/1/13 10:23 上午
 */
@ApiModel(description = "课程实体类")
@Data
public class CourseArrange implements Serializable {

  @ApiModelProperty(value = "开课星期", required = true)
  private int labDay;

  @ApiModelProperty(value = "开课节次", position = 1, required = true)
  private String labSession;

  @ApiModelProperty(value = "课程名称", position = 2, required = true)
  private String courseName;

  @ApiModelProperty(value = "实验室楼、房号", position = 3, required = true)
  private String labId;
}
