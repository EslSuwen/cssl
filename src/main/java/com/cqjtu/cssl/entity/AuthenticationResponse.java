package com.cqjtu.angularspringboot.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 验证请求返回模型
 *
 * @author suwen
 * @date 2020/2/26 下午12:19
 */
@ApiModel(description = "验证请求返回实体")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
  @ApiModelProperty(value = "验证[验证失败为空]", required = true)
  private String token;
}
