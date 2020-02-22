package com.cqjtu.cssl.mapper;

import com.cqjtu.cssl.entity.ClassGrade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 班级映射接口
 *
 * @author Aplin
 * @date 2020/1/13 10:34 上午
 */
public interface ClassMapper {
  /**
   * 添加一个班级信息
   *
   * @author Aplin
   * @date 2020/1/13 10:34 上午
   * @param classGrade 班级对象
   */
  void addClass(ClassGrade classGrade);

  /**
   * 通过班级名和专业ID删除一个班级
   *
   * @author Aplin
   * @date 2020/1/13 10:34 上午
   * @param className 班级名
   * @param majorID 专业ID
   */
  void deleteClass(String className, int majorID);

  /**
   * 通过班级名和专业ID修改一个班级
   *
   * @author: Aplin
   * @time: 2020/1/13 10:34 上午
   * @param className 班级名
   * @param majorID 专业ID
   * @param classGrade 新班级对象
   */
  void updateClass(String className, int majorID, ClassGrade classGrade);

  /**
   * 通过班级名和专业ID查询一个班级
   *
   * @author Aplin
   * @date 2020/1/13 10:34 上午
   * @param className 班级名
   * @param majorID 专业ID
   * @return ClassGrade对象
   */
  ClassGrade findOneClass(String className, int majorID);

  /**
   * 查询所有的班级
   *
   * @author Aplin
   * @date 2020/1/13 10:34 上午
   * @return ClassGrade对象集合
   */
  List<ClassGrade> findAllClass();

  /**
   * 通过专业ID查询该专业下的所有班级
   *
   * @author Aplin
   * @date 2020/1/13 10:34 上午
   * @param majorID 专业ID
   * @return ClassGrade对象集合
   */
  List<ClassGrade> findClassByMajor(int majorID);
}
