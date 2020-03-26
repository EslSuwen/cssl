/**
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

  /** 教职工号 */
  tid: string;

  /** 课程号 */
  courseId: number;

  /** 班级 */
  labClass: string;

  /** 备注 */
  labRemark: string;

  /** 排课时间 */
  arrangePeriod: Array<ArrangePeriod>;

  constructor() {
    this.aid = 0;
    this.labId = '';
    this.proId = 0;
    this.tid = '';
    this.courseId = 0;
    this.labClass = '';
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

  /** 实验项目名称 */
  expProname: string;

  constructor() {
    this.aid = 0;
    this.labWeek = 0;
    this.labDay = 0;
    this.labSession = 0;
    this.expProname = '';
  }
}
