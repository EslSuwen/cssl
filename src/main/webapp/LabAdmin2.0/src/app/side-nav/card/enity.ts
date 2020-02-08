/* 请求服务地址：
http://localhost:8090/cssl/project/
 class Project 项目 */
export class Exp {
  // 项目ID
  proId: number;
  // 实验室（中心）名称
  labCenName: string;
  // 实验课程名
  expCname: string;
  // 实验设备名
  expEqname: string;
  // 设备数量
  eqNum: number;
  // 面向专业
  expMajor: string;
  // 学生类别
  sSort: string;
  // 实验总学时
  expTime: number;
  // 实验教材
  book: string;
  // 实验所用软件
  sSorsoftWaret: string;
  // 教职工号
  tId: string;
  // 课程名
  cName: string;
  // 消耗材料名称
  conName: string;
  // 消耗材料数量
  conNum: number;

  constructor() {
    this.proId = 0;
    this.labCenName = 'init';
    this.expCname = 'init';
    this.expEqname = 'init';
    this.eqNum = 0;
    this.expMajor = 'init';
    this.sSort = 'init';
    this.expTime = 0;
    this.book = 'init';
    this.sSorsoftWaret = 'init';
    this.tId = 'init';
    this.cName = 'init';
    this.conName = 'init';
    this.conNum = 0;
  }
}

// class ProjectItem 实验项目
// http://localhost:8090/cssl/projectItem/
export class ProjectItem {
  // 实验项目编号
  iId: string;
  // 项目ID
  proId: string;
  // 实验项目名称
  iName: string;
  // 实验类型
  iType: string;
  // 实验项目学时
  iTime: number;
  // 必修或选修
  cType: String;
  // 分组人数
  num: number;
  // 实验目的
  intend: string;

  constructor() {
    this.iId = 'init';
    this.proId = 'init';
    this.iName = 'init';
    this.iType = 'init';
    this.iTime = 0;
    this.cType = 'init';
    this.num = 0;
    this.intend = 'init';

  }
}

// 教室个人信息类
export class Teacher {
  // 教职工号 String tID tid
  tID: string;
  // 教师姓名 String tName tname
  tName: string;
  // 教师电话 String tPhone tphone
  tPhone: string;
  // 教师QQ String tQQ tqq
  tQQ: string;
  // 教师邮箱 String tEmail temail
  tEmail: string;
  // 密码 String tPassword tpassword
  tPassword: string;
  // 权限（是否为管理员） int tLimit tlimit
  tLimit: number;
}

