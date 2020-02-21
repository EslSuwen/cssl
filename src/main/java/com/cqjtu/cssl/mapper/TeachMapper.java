package com.cqjtu.cssl.mapper;

import com.cqjtu.cssl.entity.Teach;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 授课映射接口
 *
 * @author Aplin
 * @date 2020/1/13 10:45 上午
 */
@Mapper
public interface TeachMapper {
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
   * @param courseID 课程号
   */
  void deleteByID(String tid, int courseID);

  /**
   * 通过教职工号和课程修改授课信息
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @param teach 新的授课信息
   */
  void updateByID(Teach teach);

  /**
   * 通过教职工号和课程查询授课信息
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @param tid 教职工号
   * @param courseID 课程号
   * @return Teach对象
   */
  Teach findByID(String tid, int courseID);

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
   * 通过教师ID+课程名查询课程ID
   *
   * @author Aplin
   * @date 2020/1/13 10:45 上午
   * @param tid 教师ID
   * @param courseName 课程名
   * @return int 课程ID
   */
  int findID(String tid, String courseName);
}
