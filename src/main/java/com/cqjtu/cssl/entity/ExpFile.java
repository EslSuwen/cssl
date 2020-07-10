package com.cqjtu.cssl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 项目(实验卡片)文件关联实体类
 *
 * @author suwen
 * @since 2020-07-07
 */
@ApiModel(description = "项目文件关联")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ExpFile implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "项目ID", required = true)
  @TableId(value = "pro_id", type = IdType.INPUT)
  private Integer proId;

  @ApiModelProperty(value = "考勤名单", required = true)
  private Integer attend;

  @ApiModelProperty(value = "实验任务书", required = true)
  private Integer task;

  @ApiModelProperty(value = "实验成绩", required = true)
  private Integer grade;

  @ApiModelProperty(value = "评分标准表", required = true)
  private Integer scheme;

  @ApiModelProperty(value = "实验报告", required = true)
  private Integer report;

  @ApiModelProperty(value = "文件列表")
  @TableField(exist = false)
  private List<ExpFileStore> files;
}
