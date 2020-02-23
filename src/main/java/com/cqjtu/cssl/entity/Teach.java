package com.cqjtu.cssl.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * 授课实体类
 *
 * @author Aplin suwen
 * @date 2020/1/13 10:27 上午
 */
@Data
public class Teach {
  // 教职工号
  private String tid;
  // 课程号
  private int courseID;
  // 实验室申请权限
  private int applyLimit;

  /** 课程名 */
  @TableField(exist = false)
  private String courseName;

  /** 课程实验室申请状态 */
  @TableField(exist = false)
  private String status;

  /** 课程实验室编号 */
  @TableField(exist = false)
  private String labId;
}
