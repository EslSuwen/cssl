package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.entity.Curriculum;
import com.cqjtu.cssl.entity.Teacher;

import java.util.List;

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
   * @return 状态码
   */
  int updatePassword(String tid, String oldPw, String newPw);

  /**
   * 查询某周的课程安排
   *
   * @param tid 教职工号
   * @param week 周次
   * @return 课程安排
   * @author suwen
   * @date 2020/4/20 上午10:46
   */
  List<Curriculum> getCurriculum(String tid, String week);
}
