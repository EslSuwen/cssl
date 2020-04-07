package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.entity.Teacher;

/**
 * 教师信息服务接口
 *
 * @author Aplin suwen
 * @date 2020/1/13 11:09 上午
 */
public interface TeacherService extends IService<Teacher> {

  /**
   * 通过教职工号修改密码
   *
   * @author Aplin suwen
   * @date 2020/4/1 20:14 下午
   * @param tid 教职工号
   * @param oldPw 旧密码
   * @param newPw 新密码
   */
  int updatePassword(String tid, String oldPw, String newPw);

}
