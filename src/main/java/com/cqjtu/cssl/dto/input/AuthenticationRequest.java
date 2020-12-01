package com.cqjtu.cssl.dto.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 验证请求接收模型
 *
 * @author suwen
 * @date 2020/2/26 下午12:20
 */
@Data
@ApiModel(description = "验证请求接收实体")
public class AuthenticationRequest {

  @ApiModelProperty(value = "用户账号", required = true)
  @NotBlank(message = "账号不能为空")
  private String userNo;

  @ApiModelProperty(value = "用户密码", required = true)
  @NotBlank(message = "密码不能为空")
  private String password;
}
