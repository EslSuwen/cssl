package com.cqjtu.cssl.mapper;

import com.cqjtu.cssl.entity.CourseArrange;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 课程安排映射接口
 *
 * @author Aplin
 * @date 2020/1/13 10:36 上午
 */
public interface CourseArrangeMapper {
  /**
   * 查询第几周某个老师的课程安排
   *
   * @author Aplin
   * @date 2020/1/13 10:36 上午
   * @param tid 教职工号
   * @param labWeek 周次
   * @return List<com.cqjtu.cssl.entity.CourseArrange>
   */
  List<CourseArrange> findALL(String tid, int labWeek);
}
