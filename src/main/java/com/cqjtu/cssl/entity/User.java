package com.cqjtu.cssl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体
 *
 * @author suwen
 * @date 2020/2/6 3:19 下午
 */
@Data
public class User implements Serializable {

  @TableId(value = "aid", type = IdType.AUTO)
  private String userNo;

  private String userName;

  private String userPwd;
}
