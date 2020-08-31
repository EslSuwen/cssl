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
 * 用户消息实体
 *
 * @author suwen
 * @since 2020-03-23
 */
@ApiModel(description = "用户消息实体")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TeacherMsg implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "消息编号", required = true)
  @TableId(value = "mid", type = IdType.AUTO)
  private Integer mid;

  @ApiModelProperty(value = "教师编号", position = 1, required = true)
  private String tid;

  @ApiModelProperty(value = "通知标题", position = 2, required = true)
  private String mtitle;

  @ApiModelProperty(value = "通知结果", position = 3, required = true)
  private Integer mresult;

  @ApiModelProperty(value = "消息创建时间", position = 4, required = true)
  private String mdate;

  @ApiModelProperty(value = "消息内容", position = 5, required = true)
  private String mtext;

  @ApiModelProperty(value = "消息状态", position = 6, required = true)
  private Integer mstatus;
}
