package com.cqjtu.cssl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 项目(实验卡片)文件储存实体类
 *
 * @author suwen
 * @since 2020-07-07
 */
@ApiModel(description = "项目文件储存")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpFileStore implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "标识编号", required = true)
  @TableId(value = "no", type = IdType.AUTO)
  private Integer no;

  @ApiModelProperty(value = "项目文件类型名", required = true)
  private String typeName;

  @ApiModelProperty(value = "文件名", required = true)
  private String name;

  @ApiModelProperty(value = "文件路径", required = true)
  private String filePath;

  @ApiModelProperty(value = "项目ID", required = true)
  @TableField(exist = false)
  private Integer proId;

  @ApiModelProperty(value = "班级编号", required = true)
  @TableField(exist = false)
  private Integer classId;
}
