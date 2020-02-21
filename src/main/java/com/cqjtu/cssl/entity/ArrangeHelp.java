package com.cqjtu.cssl.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 实验室安排辅助实体
 *
 * @author suwen
 * @date 2020/2/21 下午4:58
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ArrangeHelp extends Arrange {

  /** 排课时间 */
  private List<ArrangePeriod> arrangePeriod;
}
