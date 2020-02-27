package com.cqjtu.cssl.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Message 类不需要往数据库里存放，不用标识为@Entity。只需建立数据模型类即可
 *
 * @author suwen
 * @date 2020/1/31 6:02 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "消息实体")
public class Message {

  @ApiModelProperty(value = "消息", required = true)
  private String msg;
}
