package com.cqjtu.cssl.entity;

import com.cqjtu.cssl.constant.AuthorityName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Authority 用户权限
 *
 * @author suwen
 * @date 2020/2/24 下午1:34
 */
@ApiModel(description = "用户权限")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authority {
  @ApiModelProperty(value = "编号", required = true)
  private Long id;

  @ApiModelProperty(value = "权限", required = true)
  private AuthorityName name;
}
