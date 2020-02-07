package com.cqjtu.cssl.service;

import com.cqjtu.cssl.entity.ClassGrade;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 班级服务接口
 *
 * @author: Aplin
 * @time: 2020/1/13 11:04 上午
 */
@Service
public interface ClassService {
  /**
   * 添加班级信息
   *
   * @author: Aplin
   * @time: 2020/1/13 11:04 上午
   * @param classGrade 班级信息
   */
  void addClass(ClassGrade classGrade);

  /**
   * 删除班级信息
   *
   * @author: Aplin
   * @time: 2020/1/13 11:04 上午
   * @param className 班级名称
   * @param majorID 专业ID
   */
  void deleteClass(String className, int majorID);

  /**
   * 修改班级信息
   *
   * @author: Aplin
   * @time: 2020/1/13 11:04 上午
   * @param className 班级名称
   * @param majorID 专业ID
   * @param classGrade 新班级对象
   */
  void updateClass(String className, int majorID, ClassGrade classGrade);

  /**
   * 查询一个班级信息
   *
   * @author: Aplin
   * @time: 2020/1/13 11:04 上午
   * @param className 班级名称
   * @param majorID 专业ID
   * @return com.cqjtu.cssl.entity.ClassGrade 班级信息
   */
  ClassGrade findOneClass(String className, int majorID);

  /**
   * 查询所有的班级信息
   *
   * @author: Aplin
   * @time: 2020/1/13 11:04 上午
   * @return List<com.cqjtu.cssl.entity.ClassGrade> 班级信息列表
   */
  List<ClassGrade> findAllClass();

  /**
   * 查询专业下的所有班级信息
   *
   * @author: Aplin
   * @time: 2020/1/13 11:04 上午
   * @param majorID 专业ID
   * @return List<com.cqjtu.cssl.entity.ClassGrade> 班级信息列表
   */
  List<ClassGrade> findClassByMajor(int majorID);
}
