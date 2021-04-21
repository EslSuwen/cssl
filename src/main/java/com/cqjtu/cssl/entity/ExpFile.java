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

  @ApiModelProperty(value = "文件编号", required = true)
  @TableId(type = IdType.AUTO)
  private Long fileId;

  @ApiModelProperty(value = "项目编号", required = true)
  private Integer proId;

  @ApiModelProperty(value = "文件类型编号", required = true)
  private Integer fileType;

  @ApiModelProperty(value = "文件名", required = true)
  private String fileName;

  @ApiModelProperty(value = "文件路径", required = true)
  private String filePath;

  @ApiModelProperty(value = "文件类型名", required = true)
  @TableField(exist = false)
  private String typeName;
}
