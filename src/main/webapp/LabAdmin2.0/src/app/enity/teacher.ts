// 教师个人信息类
export class Teacher {
  // 教职工号 String tID tid
  tid: string;
  // 教师姓名 String tName tname
  tname: string;
  // 教师电话 String tPhone tphone
  tphone: string;
  // 教师QQ String tQQ tqq
  tqq: string;
  // 教师邮箱 String tEmail temail
  temail: string;
  // 密码 String tPassword tpassword
  tpassword: string;
  // 权限（是否为管理员） int tLimit tlimit
  tlimit: number;
}

/**
 * 用户消息实体
 */
export class TeacherMsg{

  mid: number;

  tid: string;

  mtitle: string;

  mdate: string;

  mtext: string;

  mstatus: number;

  mresult: number;

}

