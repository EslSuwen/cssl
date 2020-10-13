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
 * 通知信息表，通知由管理员发布。
 *
 * @author suwen
 * @since 2020-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Notice对象", description = "通知信息表，通知由管理员发布。")
public class Notice implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(type = IdType.AUTO)
  @ApiModelProperty(value = "通知编号")
  private Integer nid;

  @ApiModelProperty(value = "通知发布人编号")
  private String tid;

  @ApiModelProperty(value = "通知类型")
  private String noticeType;

  @ApiModelProperty(value = "通知发布时间")
  private String noticeDate;

  @ApiModelProperty(value = "通知标题")
  private String noticeHead;

  @ApiModelProperty(value = "通知正文")
  private String noticeContent;

  @TableField(exist = false)
  @ApiModelProperty(value = "通知发布人姓名")
  private String tname;
}
