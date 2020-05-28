package com.cqjtu.cssl.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * Audit 审核状态枚举
 *
 * @author suwen
 * @date 2020/5/26 下午4:20
 */
public enum Audit {

  /** 未申请 */
  UNCHECK(-1),
  /** 审核中 */
  AUDITING(2),
  /** 审核通过 */
  PASS(1),
  /** 审核不通过 */
  FAIL(0);

  /** 状态值 */
  @EnumValue private final int status;

  Audit(int status) {
    this.status = status;
  }
}
