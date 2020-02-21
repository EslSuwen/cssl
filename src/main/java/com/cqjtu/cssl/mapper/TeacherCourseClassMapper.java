package com.cqjtu.cssl.mapper;

import com.cqjtu.cssl.entity.TeacherCourseClassHelper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 授课详情映射接口
 *
 * @author Aplin
 * @date 2020/1/13 10:40 上午
 */
@Mapper
public interface TeacherCourseClassMapper {
  /**
   * 查询所有的授课班级的具体信息
   *
   * @author Aplin
   * @date 2020/1/13 10:40 上午
   * @return List<com.cqjtu.cssl.entity.TeacherCourseClassHelper>
   */
  List<TeacherCourseClassHelper> findALL();
}
