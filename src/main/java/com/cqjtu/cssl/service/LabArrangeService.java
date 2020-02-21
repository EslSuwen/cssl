package com.cqjtu.cssl.service;

import com.cqjtu.cssl.entity.LabArrangeShow;

import java.util.List;

/**
 * 实验室安排服务接口
 *
 * @author Aplin
 * @date 2020/1/13 11:05 上午
 */
public interface LabArrangeService {
  /**
   * 查询某个老师的实验室安排
   *
   * @author Aplin
   * @date 2020/1/13 11:05 上午
   * @param tid 教师编号
   * @return List<LabArrancom.cqjtu.cssl.entity.LabArrangeShowgeShow> 实验室安排列表
   */
  List<LabArrangeShow> findByTid(String tid);

  /**
   * 查询某周的实验室安排
   *
   * @author Aplin
   * @date 2020/1/13 11:05 上午
   * @param labWeek 周次
   * @return List<LabArrancom.cqjtu.cssl.entity.LabArrangeShowgeShow> 实验室安排列表
   */
  List<LabArrangeShow> findByWeek(int labWeek);

  /**
   * 查询所有的实验室安排
   *
   * @author Aplin
   * @date 2020/1/13 11:05 上午
   * @return List<LabArrancom.cqjtu.cssl.entity.LabArrangeShowgeShow> 实验室安排列表
   */
  List<LabArrangeShow> findAll();

  /**
   * 添加实验室安排
   *
   * @author Aplin
   * @date 2020/1/13 11:05 上午
   * @param labArrangeShow 实验室安排信息
   */
  void addLabArrange(String tid, int proId, LabArrangeShow labArrangeShow);
}
