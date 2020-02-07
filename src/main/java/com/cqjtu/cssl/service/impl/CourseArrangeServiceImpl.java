package com.cqjtu.cssl.service.impl;

import com.cqjtu.cssl.entity.CourseArrange;
import com.cqjtu.cssl.mapper.CourseArrangeMapper;
import com.cqjtu.cssl.service.CourseArrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程信息服务接口实现
 *
 * @author: Aplin
 * @time: 2020/1/13 11:04 上午
 */
@Service
public class CourseArrangeServiceImpl implements CourseArrangeService {
  @Autowired private CourseArrangeMapper courseArrangeMapper;

  @Override
  public List<CourseArrange> findALL(String tid, int labWeek) {
    return courseArrangeMapper.findALL(tid, labWeek);
  }
}
