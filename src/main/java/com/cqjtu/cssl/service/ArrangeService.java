package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.dto.Result;
import com.cqjtu.cssl.entity.Arrange;
import com.cqjtu.cssl.entity.Class;
import com.cqjtu.cssl.dto.output.TeachingPlan;
import org.springframework.http.ResponseEntity;

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
   * 获取教学计划表
   *
   * @return java.util.List<教学计划表>
   * @author suwen
   * @date 2020/5/13 下午3:44
   */
  List<TeachingPlan> getTeachingPlanList();


  /**
   * 增加排课信息
   *
   * @param arrange 排课信息
   * @return MessageHelper
   * @author suwen
   * @date 2020/5/26 下午8:41
   */
  boolean addArrange(Arrange arrange);

  /**
   * 通过年级获取班级名单
   *
   * @param grade 年级
   * @return 班级名单
   * @author suwen
   * @date 2020/5/13 下午4:40
   */
  List<Class> getClassByGrade(Integer grade);

  /**
   * 排课时间增加冲突检测
   *
   * @param arrange 排课信息
   * @return 冲突
   */
  ResponseEntity<Result> ifAddArrange(Arrange arrange);
}
