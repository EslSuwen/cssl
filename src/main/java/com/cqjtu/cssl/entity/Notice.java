package com.cqjtu.cssl.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDateTime;

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

  @ApiModelProperty(value = "通知编号")
  private Integer nid;

  @ApiModelProperty(value = "通知发布人编号")
  private String tid;

  @ApiModelProperty(value = "通知发布时间")
  private LocalDateTime noticeDate;

  @ApiModelProperty(value = "通知标题")
  private String noticeHead;

  @ApiModelProperty(value = "通知正文")
  private Blob noticeContent;
}
