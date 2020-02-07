package com.cqjtu.cssl.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 教师授课信息服务接口
 *
 * @author: Aplin
 * @time: 2020/1/13 11:08 上午
 */
@Service
public interface TeachService {
  /**
   * 通过教职工号查询出他的所有教的课程
   *
   * @author: Aplin
   * @time: 2020/1/13 11:08 上午
   * @param tid 教职工
   * @return 所教课程
   */
  List<String> findCourseByTeacher(String tid);
}
