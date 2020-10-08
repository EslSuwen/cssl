package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.Arrange;
import com.cqjtu.cssl.entity.ArrangePeriod;
import com.cqjtu.cssl.entity.Class;
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
  List<TeachingPlan> getTeachingPlanList();

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
  List<Class> getClassByGrade(Integer grade);

  /**
   * 根据班级编号获取时间安排
   *
   * @param classId 班级编号
   * @return 时间安排
   */
  List<ArrangePeriod> getArrangePeriodByClassId(Integer classId);

  /**
   * 根据时间安排编号获取课程信息
   *
   * @param aid 时间安排编号
   * @return 课程信息
   */
  List<Class> getClassByAid(Integer aid);

  /**
   * 根据项目编号获取课程信息
   *
   * @param proId 项目编号
   * @return 课程信息
   */
  List<Class> getClassByProId(Integer proId);

  /**
   * 根据时间安排编号获取课程名
   *
   * @param aid 时间安排编号
   * @return 课程名
   */
  String getClassNameByAid(Integer aid);

  /**
   * 根据项目编号获取课程名
   *
   * @param proId 项目编号
   * @return 课程名
   */
  String getClassNameByProId(Integer proId);
}
