package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.Teach;

import java.util.List;

/**
 * 授课 Mapper 接口
 *
 * @author Aplin suwen
 * @date 2020/2/6 3:30 下午
 */
public interface TeachMapper extends BaseMapper<Teach> {
  /**
   * 添加授课信息
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @param teach 授课信息
   */
  void addTeach(Teach teach);

  /**
   * 通过教职工号和课程号删除授课信息
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @param tid 教职工号
   * @param courseId 课程号
   */
  void deleteById(String tid, int courseId);

  /**
   * 通过教职工号和课程查询授课信息
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @param tid 教职工号
   * @param courseId 课程号
   * @return Teach对象
   */
  Teach findById(String tid, int courseId);

  /**
   * 通过教职工号查询该老师的所有授课信息
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @param tid 教职工号
   * @return Teach集合
   */
  List<Teach> findByTid(String tid);

  /**
   * 查询所有的授课信息
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @return Teach集合
   */
  List<Teach> findAll();

  /**
   * 通过教师Id+课程名查询课程Id
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @param tid 教师Id
   * @param courseName 课程名
   * @return int 课程Id
   */
  int findId(String tid, String courseName);
}
