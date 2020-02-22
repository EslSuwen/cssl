package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.entity.Arrange;

import java.util.List;

/**
 * 实验室安排 服务类
 *
 * @author suwen
 * @since 2020-02-21
 */
public interface ArrangeService extends IService<Arrange> {

  /**
   * 查询某个老师的实验室安排
   *
   * @param tid 教师编号
   * @return List<Arrange> 实验室安排列表
   * @author suwen
   * @date 2020/2/22 11:05 上午
   */
  List<Arrange> findByTid(String tid);
}
