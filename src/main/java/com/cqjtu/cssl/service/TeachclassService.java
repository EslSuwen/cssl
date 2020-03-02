package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.entity.Teachclass;
import com.cqjtu.cssl.entity.TeacherCourseClassHelper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 教师授课班级信息服务接口
 *
 * @author Aplin suwen
 * @date 2020/1/13 11:08 上午
 */
public interface TeachclassService extends IService<Teachclass> {
  /**
   * 通过教职工号和课程号查询对应的班级
   *
   * @author Aplin
   * @date 2020/1/13 11:08 上午
   * @param tid 教职工号
   * @param courseId 课程号
   * @return List<java.lang.String> 班级名列表
   */
  List<String> findByTidAndCourseId(String tid, int courseId);

  /**
   * 查询所有的教师班级的授课信息
   *
   * @author Aplin
   * @date 2020/1/13 11:08 上午
   * @return List<com.cqjtu.cssl.entity.TeacherCourseClassHelper> 授课信息列表
   */
  List<TeacherCourseClassHelper> findAll();
}
