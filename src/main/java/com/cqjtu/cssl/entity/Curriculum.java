package com.cqjtu.cssl.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Curriculum 课程表信息
 *
 * @author suwen
 * @date 2020/4/20 上午10:32
 */
@ApiModel(description = "课程表信息实体")
@Data
public class Curriculum {

  @ApiModelProperty(value = "课程名", required = true)
  private String cname;

  @ApiModelProperty(value = "班级", position = 1, required = true)
  private String labClass;

  @ApiModelProperty(value = "实验室编号", position = 2, required = true)
  private String labId;

  @ApiModelProperty(value = "实验室校区", position = 3, required = true)
  private String campus;

  @ApiModelProperty(value = "时间安排", position = 4, required = true)
  private ArrangePeriod arrangePeriod;
}
