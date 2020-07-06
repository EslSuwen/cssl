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
 * (实验卡片)实验项目实体类
 *
 * @author suwen Aplin
 * @since 2020-02-27
 */
@ApiModel(description = "(实验卡片)实验项目实体")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProjectItem implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "实验项目id")
  @TableId(value = "ino", type = IdType.AUTO)
  private String ino;

  @ApiModelProperty(value = "实验项目编号", position = 1, required = true)
  private String iid;

  @ApiModelProperty(value = "项目(实验卡片)ID", position = 2, required = true)
  private Integer proId;

  @ApiModelProperty(value = "实验项目名称", position = 3, required = true)
  private String iname;

  @ApiModelProperty(value = "实验类型", position = 4, required = true)
  private String itype;

  @ApiModelProperty(value = "实验项目学时", position = 5, required = true)
  private Integer itime;

  @ApiModelProperty(value = "分组人数", position = 6, required = true)
  private Integer num;

  @ApiModelProperty(value = "实验目的", position = 7, required = true)
  private String intend;
}
