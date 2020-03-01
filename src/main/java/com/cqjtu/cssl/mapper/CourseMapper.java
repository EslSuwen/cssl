package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.Course;

import java.util.List;

/**
 * 课程 Mapper 接口
 *
 * @author Aplin suwen
 * @date 2020/1/13 10:36 上午
 */
public interface CourseMapper extends BaseMapper<Course> {
  /**
   * 添加一门课程
   *
   * @author Aplin
   * @date 2020/1/13 10:36 上午
   * @param course 课程对象
   */
  void addCourse(Course course);
  /**
   * 通过课程号删除一门课程
   *
   * @author Aplin
   * @date 2020/1/13 10:36 上午
   * @param courseId 课程对象Id
   */
  void deleteById(int courseId);

  /**
   * 通过课程号查询课程信息
   *
   * @author Aplin
   * @date 2020/1/13 10:36 上午
   * @param courseId 课程对象Id
   * @return Course
   */
  Course findById(int courseId);

  /**
   * 查询所有的课程信息
   *
   * @author Aplin
   * @date 2020/1/13 10:36 上午
   * @return List<Course>
   */
  List<Course> findAll();
}
