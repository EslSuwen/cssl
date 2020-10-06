package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.entity.Course;
import com.cqjtu.cssl.entity.Teach;

import java.util.List;

/**
 * 教师授课信息服务接口
 *
 * @author Aplin suwen
 * @date 2020/1/13 11:08 上午
 */
public interface TeachService extends IService<Teach> {
  /**
   * 通过教职工号查询出他的所有教的课程
   *
   * @author Aplin
   * @date 2020/1/13 11:08 上午
   * @param tid 教职工
   * @return 所教课程
   */
  List<Teach> getTeachByTid(String tid);

  /**
   * 通过教职工号查询出他的所教且过滤已经填写卡片信息的课程
   *
   * @author suwen
   * @date 2020/2/20 上午11:57
   * @param tid 教职工编号
   * @param term 学期
   * @return List<com.cqjtu.cssl.entity.Teach> 授课信息列表
   */
  List<Teach> getCourseInfoByTid(String tid, String term);

  /**
   * 通过教师编号查找可增加课程信息
   *
   * @param tid 教师编号
   * @return 课程
   * @author suwen
   * @date 2020/10/5 下午3:08
   */
  List<Course> selectAvailableCourse(String tid);
}
