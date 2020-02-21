package com.cqjtu.cssl.service;

import com.cqjtu.cssl.entity.CourseArrange;

import java.util.List;

/**
 * 课程信息服务接口
 *
 * @author Aplin
 * @date 2020/1/13 11:04 上午
 */
public interface CourseArrangeService {
  /**
   * 查询第几周某个老师的课程安排
   *
   * @author Aplin
   * @date 2020/1/13 11:04 上午
   * @param tid 教职工号
   * @param labWeek 周次
   * @return List<com.cqjtu.cssl.entity.CourseArrange>
   */
  List<CourseArrange> findALL(String tid, int labWeek);
}
