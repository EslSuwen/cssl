package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.entity.Class;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 班级服务接口
 *
 * @author Aplin suwen
 * @date 2020/1/13 11:04 上午
 */
@Service
public interface ClassService extends IService<Class> {
  /**
   * 添加班级信息
   *
   * @author Aplin
   * @date 2020/1/13 11:04 上午
   * @param aClass 班级信息
   */
  void addClass(Class aClass);

  /**
   * 删除班级信息
   *
   * @author Aplin
   * @date 2020/1/13 11:04 上午
   * @param className 班级名称
   * @param majorId 专业Id
   */
  void deleteClass(String className, int majorId);

  /**
   * 修改班级信息
   *
   * @author Aplin
   * @date 2020/1/13 11:04 上午
   * @param className 班级名称
   * @param majorId 专业Id
   * @param aClass 新班级对象
   */
  void updateClass(String className, int majorId, Class aClass);

  /**
   * 查询一个班级信息
   *
   * @author Aplin
   * @date 2020/1/13 11:04 上午
   * @param className 班级名称
   * @param majorId 专业Id
   * @return com.cqjtu.cssl.entity.ClassGrade 班级信息
   */
  Class findOneClass(String className, int majorId);

  /**
   * 查询所有的班级信息
   *
   * @author Aplin
   * @date 2020/1/13 11:04 上午
   * @return List<com.cqjtu.cssl.entity.ClassGrade> 班级信息列表
   */
  List<Class> findAllClass();

  /**
   * 查询专业下的所有班级信息
   *
   * @author Aplin
   * @date 2020/1/13 11:04 上午
   * @param majorId 专业Id
   * @return List<com.cqjtu.cssl.entity.ClassGrade> 班级信息列表
   */
  List<Class> findClassByMajor(int majorId);
}
