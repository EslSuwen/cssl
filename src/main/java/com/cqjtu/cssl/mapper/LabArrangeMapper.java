package com.cqjtu.cssl.mapper;

import com.cqjtu.cssl.entity.LabArrange;
import com.cqjtu.cssl.entity.LabArrangeShow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 实验室安排映射接口
 *
 * @author: Aplin
 * @time: 2020/1/13 10:37 上午
 */
@Mapper
public interface LabArrangeMapper {

  /**
   * 添加实验室安排信息
   *
   * @author: Aplin
   * @time: 2020/1/13 10:37 上午
   * @param labArrange
   */
  void addLabArrange(LabArrange labArrange);

  /**
   * 查找所有排课信息
   *
   * @author: Aplin
   * @time: 2020/1/13 10:37 上午
   * @return
   */
  List<LabArrangeShow> findAll();
  /**
   * 查询某个老师的实验室安排
   *
   * @author: Aplin
   * @time: 2020/1/13 10:37 上午
   * @param tid
   * @return
   */
  List<LabArrangeShow> findByTid(String tid);

  /**
   * 查询某一周的实验室安排
   *
   * @author: Aplin
   * @time: 2020/1/13 10:37 上午
   * @param labWeek
   * @return
   */
  List<LabArrangeShow> findByLabWeek(int labWeek);

  /**
   * 查询某一周的某一天的实验室安排
   *
   * @author: Aplin
   * @time: 2020/1/13 10:37 上午
   * @param labWeek
   * @param labDay
   * @return
   */
  List<LabArrangeShow> findByLabWeekAndDay(int labWeek, int labDay);
}
