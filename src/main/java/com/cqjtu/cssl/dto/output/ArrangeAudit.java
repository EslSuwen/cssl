package com.cqjtu.cssl.dto.output;

import com.cqjtu.cssl.entity.ArrangePeriod;
import lombok.Builder;
import lombok.Data;

/**
 * ArrangeAudit 审核用时间安排实体
 *
 * @author suwen
 * @date 2020/5/28 下午8:40
 */
@Data
@Builder
public class ArrangeAudit {

  /** 实验室排课编号 */
  private Integer aid;

  /** 实验室编号 */
  private String labId;

  /** 实验室名 */
  private String labName;

  /** 实验室校区 */
  private String campus;

  /** 班级 */
  private String labClass;

  /** 所属课程 */
  private String courseName;

  /** 任课教师名 */
  private String tname;

  /** 实验项目名称 */
  private String expProname;

  /** 备注 */
  private String labRemark;

  /** 排课时间 */
  private ArrangePeriod arrangePeriod;

  /** 排课周期 */
  private String period;
}
