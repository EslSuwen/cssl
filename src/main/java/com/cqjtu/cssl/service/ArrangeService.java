package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.entity.Arrange;
import com.cqjtu.cssl.entity.TeachingPlan;

import java.util.List;

/**
 * 实验室安排服务类
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

  /**
   * 管理员审核实验室时间安排
   *
   * @param aid 安排编号
   * @param status 状态
   * @return 操作状态
   * @author suwen
   * @date 2020/5/11 上午9:49
   */
  // boolean auditArrange(Integer aid, Audit status);

  /**
   * 获取教学计划表
   *
   * @return java.util.List<教学计划表>
   * @author suwen
   * @date 2020/5/13 下午3:44
   */
  List<TeachingPlan> getTeachingPlanList();

  /**
   * 获取已申请的实验室安排信息
   *
   * @return 实验室时间安排列表
   * @author suwen
   * @date 2020/5/26 下午8:40
   */
  // List<ArrangeAudit> getAuditArrange();

  /**
   * 增加排课信息
   *
   * @param arrange 排课信息
   * @return MessageHelper
   * @author suwen
   * @date 2020/5/26 下午8:41
   */
  Boolean addArrange(Arrange arrange);

  /**
   * 通过课程编号查询实验室编号
   *
   * @param courseNo 课程编号
   * @param tid 教师编号
   * @return 实验室编号
   * @author suwen
   * @date 2020/2/23 下午1:32
   */
  String findLabByClsNo(String tid, Integer courseNo);
}
