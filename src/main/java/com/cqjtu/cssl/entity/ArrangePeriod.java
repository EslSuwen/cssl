package com.cqjtu.cssl.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 实验室安排上课时间实体
 *
 * @author suwen
 * @since 2020-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ArrangePeriod implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 实验室排课编号 */
  private Integer aid;

  /** 开课周次 */
  private Integer labWeek;

  /** 开课星期 */
  private Integer labDay;

  /** 开课节次 */
  private Integer labSession;

  /** 实验项目名称 */
  private String expProname;
}
