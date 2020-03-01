package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.Teachclass;

import java.util.List;

/**
 * 授课班级 Mapper 接口
 *
 * @author suwen
 * @date 2020/2/6 3:30 下午
 */
public interface TeachclassMapper extends BaseMapper<Teachclass> {

  /**
   * 添加授课班级信息
   *
   * @author Aplin
   * @date 2020/1/13 10:39 上午
   * @param teachClass 授课班级对象
   */
  void addTeachClass(Teachclass teachClass);

  /**
   * 删除授课班级信息
   *
   * @author Aplin
   * @date 2020/1/13 10:39 上午
   * @param teachClass 授课班级对象
   */
  void deleteTeachClass(Teachclass teachClass);

  /**
   * 修改授课班级信息
   *
   * @author Aplin
   * @date 2020/1/13 10:39 上午
   * @param oldTeachclass 旧的授课班级对象
   * @param newTeachclass 新的授课班级对象
   */
  void updateTeachClass(Teachclass oldTeachclass, Teachclass newTeachclass);

  /**
   * 查询所有的授课班级信息
   *
   * @author Aplin
   * @date 2020/1/13 10:39 上午
   * @return 授课班级对象集合
   */
  List<Teachclass> findAll();

  /**
   * 通过教职工号和课程号查询对应的授课信息
   *
   * @author Aplin
   * @date 2020/1/13 10:39 上午
   * @param tid 教职工号
   * @param course 课程号
   * @return 授课班级对象集合
   */
  List<Teachclass> findByTidAndCourseId(String tid, int course);
}
