/*
 * 实验室安排实体
 *
 * @author suwen
 * @since 2020-02-23
 */

export class Arrange {

  /** 实验室排课编号 */
  aid: number;

  /** 实验室编号 */
  labId: string;

  /** 项目ID */
  proId: number;

  /** 实验室校区 */
  campus: string;

  /** 申请状态 */
  status: number;

  /** 班级 */
  labClass: string;

  /** 课程编号 */
  courseId: string;

  /** 教职工号 */
  tid: string;

  /** 实验项目名称 */
  expProname: string;

  /** 备注 */
  labRemark: string;

  /** 排课时间 */
  arrangePeriod: Array<ArrangePeriod>;

  constructor() {
    this.aid = 0;
    this.labId = '';
    this.proId = 0;
    this.campus = '';
    this.status = 0;
    this.labClass = '';
    this.tid = '';
    this.courseId = '';
    this.expProname = '';
    this.labRemark = '';
    this.arrangePeriod = new Array<ArrangePeriod>();
  }
}

/**
 * 实验室安排上课时间实体
 *
 * @author suwen
 * @since 2020-02-23
 */
export class ArrangePeriod {

  /** 实验室排课编号 */
  aid: number;

  /** 开课周次 */
  labWeek: number;

  /** 开课星期 */
  labDay: number;

  /** 开课节次 */
  labSession: number;

  constructor() {
    this.aid = 0;
    this.labWeek = 0;
    this.labDay = 0;
    this.labSession = 0;
  }
}

/**
 * 课程表信息实体
 *
 * @author suwen
 * @since 2020-04-20
 */

export class Curriculum {

  /** 课程名 */
  cname: string;

  /** 班级 */
  labClass: string;

  /** 排课时间 */
  arrangePeriod: Array<ArrangePeriod>;

  constructor() {
    this.cname = '';
    this.labClass = '';
    this.arrangePeriod = new Array<ArrangePeriod>();
  }

}
