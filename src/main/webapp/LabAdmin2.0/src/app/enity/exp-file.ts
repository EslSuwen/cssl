/**
 * 实验卡片文件关联实体
 *
 * @author suwen
 * @since 2020-07-8
 */
export class ExpFile {

  /** 卡片编号 */
  proId: number;

  /** 考勤名单 */
  attend: number;

  /** 实验任务书 */
  task: number;

  /** 实验成绩 */
  grade: number;

  /** 评分标准表 */
  scheme: number;

  /** 实验报告 */
  report: number;

  constructor() {
    this.proId = 0;
    this.attend = 0;
    this.task = 0;
    this.grade = 0;
    this.scheme = 0;
    this.report = 0;
  }
}
