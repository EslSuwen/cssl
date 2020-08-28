package com.cqjtu.cssl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDateTime;

/**
 * 通知文件
 *
 * @author suwen
 * @since 2020-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "NoticeFile对象", description = "通知文件")
public class NoticeFile implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "通知文件编号")
  @TableId(value = "file_id", type = IdType.AUTO)
  private Integer fileId;

  @ApiModelProperty(value = "通知文件名")
  private String fileName;

  @ApiModelProperty(value = "通知发布人编号")
  private Integer tid;

  @ApiModelProperty(value = "通知文件发布时间")
  private String fileDate;

  @ApiModelProperty(value = "通知文件")
  private byte[] file;
}
