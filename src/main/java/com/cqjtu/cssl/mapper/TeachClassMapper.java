package com.cqjtu.cssl.mapper;

import com.cqjtu.cssl.entity.TeachClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 授课班级映射接口
 *
 * @author Aplin
 * @date 2020/1/13 10:39 上午
 */
public interface TeachClassMapper {
  /**
   * 添加授课班级信息
   *
   * @author Aplin
   * @date 2020/1/13 10:39 上午
   * @param teachClass 授课班级对象
   */
  void addTeachClass(TeachClass teachClass);

  /**
   * 删除授课班级信息
   *
   * @author Aplin
   * @date 2020/1/13 10:39 上午
   * @param teachClass 授课班级对象
   */
  void deleteTeachClass(TeachClass teachClass);

  /**
   * 修改授课班级信息
   *
   * @author Aplin
   * @date 2020/1/13 10:39 上午
   * @param oldTeachClass 旧的授课班级对象
   * @param newTeachClass 新的授课班级对象
   */
  void updateTeachClass(TeachClass oldTeachClass, TeachClass newTeachClass);

  /**
   * 查询所有的授课班级信息
   *
   * @author Aplin
   * @date 2020/1/13 10:39 上午
   * @return 授课班级对象集合
   */
  List<TeachClass> findAll();

  /**
   * 通过教职工号和课程号查询对应的授课信息
   *
   * @author Aplin
   * @date 2020/1/13 10:39 上午
   * @param tid 教职工号
   * @param course 课程号
   * @return 授课班级对象集合
   */
  List<TeachClass> findByTidAndCourseID(String tid, int course);
}
