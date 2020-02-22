package com.cqjtu.cssl.mapper;

import com.cqjtu.cssl.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 课程映射接口
 *
 * @author Aplin
 * @date 2020/1/13 10:36 上午
 */
public interface CourseMapper {
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
   * @param courseID 课程对象ID
   */
  void deleteByID(int courseID);

  /**
   * 通过课程号修改一门课程
   *
   * @author Aplin
   * @date 2020/1/13 10:36 上午
   * @param course 新课程对象
   */
  void updateByID(Course course);

  /**
   * 通过课程号查询课程信息
   *
   * @author Aplin
   * @date 2020/1/13 10:36 上午
   * @param courseID 课程对象ID
   * @return Course
   */
  Course findByID(int courseID);

  /**
   * 查询所有的课程信息
   *
   * @author Aplin
   * @date 2020/1/13 10:36 上午
   * @return List<Course>
   */
  List<Course> findAll();
}
