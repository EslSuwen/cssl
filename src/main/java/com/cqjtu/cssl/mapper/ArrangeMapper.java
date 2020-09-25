package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.Arrange;
import com.cqjtu.cssl.entity.TeachingPlan;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 实验室安排 Mapper 接口
 *
 * @author suwen
 * @since 2020-02-21
 */
public interface ArrangeMapper extends BaseMapper<Arrange> {

  /**
   * 通过课程编号查询实验室编号
   *
   * @param courseNo 课程编号
   * @param tid 教师编号
   * @return 实验室编号
   * @author suwen
   * @date 2020/2/23 下午1:32
   */
  @Select("select lab_id from arrange where tid = #{param1} and course_Id = #{param2}")
  String findLabByClsNo(String tid, Integer courseNo);

  /**
   * 获取教学计划表
   *
   * @return java.util.List<教学计划表>
   * @author suwen
   * @date 2020/5/13 下午3:33
   */
  List<TeachingPlan> getTeachingPlanList(String term);

  /**
   * 根据课程编号查询课程起止周
   *
   * @param proId 项目卡片编号
   * @return 课程起止周
   * @author suwen
   * @date 2020/5/13 下午4:40
   */
  String getCoursePeriodByProId(Integer proId);

  /**
   * 通过年级获取班级名单
   *
   * @param grade 年级
   * @return 班级名单
   * @author suwen
   * @date 2020/5/13 下午4:40
   */
  List<String> getClassByGrade(String grade);
}
