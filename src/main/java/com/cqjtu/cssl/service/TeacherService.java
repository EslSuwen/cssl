package com.cqjtu.cssl.service;

import com.cqjtu.cssl.entity.Teacher;

/**
 * 教师信息服务接口
 *
 * @author Aplin
 * @date 2020/1/13 11:09 上午
 */
public interface TeacherService {
  /**
   * 通过教职工号查找老师个人信息
   *
   * @author Aplin
   * @date 2020/1/13 11:09 上午
   * @param tid 教职工号
   * @return 老师信息
   */
  Teacher findByTid(String tid);

  /**
   * 通过教职工号修改密码
   *
   * @author Aplin
   * @date 2020/1/13 11:09 上午
   * @param tid 教职工号
   * @param password 新密码
   */
  void updatePassword(String tid, String password);

  /**
   * 通过教职工号修改个人信息
   *
   * @author Aplin
   * @date 2020/1/13 11:09 上午
   * @param tid 教职工号
   * @param teacher 教师信息
   */
  void updateTeacher(String tid, Teacher teacher);

  /**
   * 通过教职工号查询密码
   *
   * @author Aplin
   * @date 2020/1/13 11:09 上午
   * @param tid 教职工号
   * @return java.lang.String 密码
   */
  String findPassword(String tid);
}
