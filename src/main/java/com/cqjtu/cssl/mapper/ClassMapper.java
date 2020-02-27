package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.Class;

import java.util.List;

/**
 * 班级 Mapper 接口
 *
 * @author Aplin suwen
 * @date 2020/1/13 10:34 上午
 */
public interface ClassMapper extends BaseMapper<Class> {
  /**
   * 添加一个班级信息
   *
   * @author Aplin
   * @date 2020/1/13 10:34 上午
   * @param aClass 班级对象
   */
  void addClass(Class aClass);

  /**
   * 通过班级名和专业Id删除一个班级
   *
   * @author Aplin
   * @date 2020/1/13 10:34 上午
   * @param className 班级名
   * @param majorId 专业Id
   */
  void deleteClass(String className, int majorId);

  /**
   * 通过班级名和专业Id修改一个班级
   *
   * @author Aplin
   * @date 2020/1/13 10:34 上午
   * @param className 班级名
   * @param majorId 专业Id
   * @param aClass 新班级对象
   */
  void updateClass(String className, int majorId, Class aClass);

  /**
   * 通过班级名和专业Id查询一个班级
   *
   * @author Aplin
   * @date 2020/1/13 10:34 上午
   * @param className 班级名
   * @param majorId 专业Id
   * @return ClassGrade对象
   */
  Class findOneClass(String className, int majorId);

  /**
   * 查询所有的班级
   *
   * @author Aplin
   * @date 2020/1/13 10:34 上午
   * @return ClassGrade对象集合
   */
  List<Class> findAllClass();

  /**
   * 通过专业Id查询该专业下的所有班级
   *
   * @author Aplin
   * @date 2020/1/13 10:34 上午
   * @param majorId 专业Id
   * @return ClassGrade对象集合
   */
  List<Class> findClassByMajor(int majorId);
}
