package com.cqjtu.cssl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 实验室安排实体
 *
 * @author suwen
 * @since 2020-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Arrange implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 实验室排课编号 */
  @TableId(value = "aid", type = IdType.AUTO)
  private Integer aid;

  /** 实验室编号 */
  private String labId;

  /** 项目ID */
  private Integer proId;

  /** 教职工号 */
  private String tid;

  /** 课程号 */
  private Integer courseId;

  /** 班级 */
  private String labClass;

  /** 备注 */
  private String labRemark;

  /** 排课时间 */
  @TableField(exist = false)
  private List<ArrangePeriod> arrangePeriod;
}
