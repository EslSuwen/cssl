package com.cqjtu.cssl.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 教师实体类
 *
 * @author suwen Aplin
 * @since 2020-02-27
 */
@ApiModel(description = "教师实体")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Teacher implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "教职工号", required = true)
  private String tid;

  @ApiModelProperty(value = "教师姓名", position = 1, required = true)
  private String tname;

  @ApiModelProperty(value = "教师电话", position = 2, required = true)
  private String tphone;

  @ApiModelProperty(value = "教师QQ", position = 3)
  private String tqq;

  @ApiModelProperty(value = "教师邮箱", position = 4, required = true)
  private String temail;

  @ApiModelProperty(value = "密码", position = 5, required = true)
  private String tpassword;

  @ApiModelProperty(value = "权限(是否为管理员)", position = 6, required = true)
  private Boolean tlimit;

  @ApiModelProperty(value = "用户权限列表", position = 7)
  @TableField(exist = false)
  private List<Authority> authorities;
}
