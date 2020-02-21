package com.cqjtu.cssl.service;

import com.cqjtu.cssl.entity.Teach;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 教师授课信息服务接口
 *
 * @author Aplin
 * @date 2020/1/13 11:08 上午
 */
@Service
public interface TeachService {
  /**
   * 通过教职工号查询出他的所有教的课程
   *
   * @author Aplin
   * @date 2020/1/13 11:08 上午
   * @param tid 教职工
   * @return 所教课程
   */
  List<String> findCourseByTeacher(String tid);

  /**
   * 通过教职工号查询出他的所有教的课程
   *
   * @author suwen
   * @date 2020/2/20 上午11:57
   * @param tid 教职工
   * @return List<com.cqjtu.cssl.entity.Teach> 授课信息列表
   */
  List<Teach> getCourseInfoByTid(String tid);
}
