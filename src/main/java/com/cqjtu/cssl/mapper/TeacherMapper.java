package com.cqjtu.cssl.mapper;

import com.cqjtu.cssl.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 教师映射接口
 *
 * @author Aplin
 * @date 2020/1/13 10:45 上午
 */
public interface TeacherMapper {
  /**
   * 添加教师信息
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @param teacher 教师信息
   */
  void addTeacher(Teacher teacher);

  /**
   * 通过教职工号查询教师信息
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @param tid 教职工号
   * @return 教师信息
   */
  Teacher findById(String tid);

  /**
   * 通过教职工号修改教师信息
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @param teacher 教师信息
   */
  void updateById(Teacher teacher);

  /**
   * 查询所有的教师信息
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @return List<com.cqjtu.cssl.entity.Teacher> 教师信息列表
   */
  List<Teacher> findAll();

  /**
   * 通过教职工号删除教师信息
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @param tid 教职工号
   */
  void deleteById(String tid);

  /**
   * 通过教职工号查询密码
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @param tid 教职工号
   * @return java.lang.String 密码
   */
  String findPassword(String tid);

  /**
   * 通过教职工号修改密码
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @param tid 教职工号
   * @param password 新密码
   */
  void updatePassword(String tid, String password);
}
