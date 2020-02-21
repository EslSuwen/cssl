package com.cqjtu.cssl.mapper;

import com.cqjtu.cssl.entity.LabArrange;
import com.cqjtu.cssl.entity.LabArrangeShow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 实验室安排映射接口
 *
 * @author Aplin
 * @date 2020/1/13 10:37 上午
 */
@Mapper
public interface LabArrangeMapper {

  /**
   * 添加实验室安排信息
   *
   * @author Aplin
   * @date 2020/1/13 10:37 上午
   * @param labArrange 实验室安排信息
   */
  void addLabArrange(LabArrange labArrange);

  /**
   * 查找所有排课信息
   *
   * @author Aplin
   * @date 2020/1/13 10:37 上午
   * @return List<com.cqjtu.cssl.entity.LabArrangeShow> 排课信息列表
   */
  List<LabArrangeShow> findAll();
  /**
   * 查询某个老师的实验室安排
   *
   * @author Aplin
   * @date 2020/1/13 10:37 上午
   * @param tid 老师编号
   * @return List<com.cqjtu.cssl.entity.LabArrangeShow> 排课信息列表
   */
  List<LabArrangeShow> findByTid(String tid);

  /**
   * 查询某一周的实验室安排
   *
   * @author Aplin
   * @date 2020/1/13 10:37 上午
   * @param labWeek 周
   * @return List<com.cqjtu.cssl.entity.LabArrangeShow> 排课信息列表
   */
  List<LabArrangeShow> findByLabWeek(int labWeek);

  /**
   * 查询某一周的某一天的实验室安排
   *
   * @author Aplin
   * @date 2020/1/13 10:37 上午
   * @param labWeek 周
   * @param labDay 天
   * @return List<com.cqjtu.cssl.entity.LabArrangeShow> 排课信息列表
   */
  List<LabArrangeShow> findByLabWeekAndDay(int labWeek, int labDay);
}
