package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.constant.Audit;
import com.cqjtu.cssl.entity.ExpProject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 项目卡片信息服务接口
 *
 * @author Aplin suwen
 * @date 2020/2/6 3:57 下午
 */
public interface ExpProjectService extends IService<ExpProject> {

  /**
   * 根据老师编号和课程号判断是否已存在对应卡片
   *
   * @author suwen
   * @date 2020/2/6 3:57 下午
   * @param tid 老师编号
   * @param cid 课程号
   */
  boolean isCardExist(String tid, String cid);

  /**
   * 根据老师编号和课程号查找对应卡片
   *
   * @author suwen
   * @date 2020/2/6 3:57 下午
   * @param tid 老师编号
   * @param cid 课程号
   */
  ExpProject getExpByTidCid(String tid, String cid);

  /**
   * 根据老师编号和课程号查找对应卡片
   *
   * @author suwen
   * @date 2020/5/26 5:57 下午
   * @param tid 老师编号
   */
  List<ExpProject> getExpByTid(String tid);

  /**
   * 获取待审核项目卡片数据
   *
   * @return java.lang.Iterable<com.cqjtu.cssl.entity.Project>
   * @author suwen
   * @date 2020/5/10 11:14 上午
   */
  @GetMapping(value = "/getAuditProject")
   List<ExpProject> getAuditProjects();

  /**
   * 审核项目卡片
   *
   * @param proId 卡片id
   * @param Audit 审核状态
   * @return 状态
   * @author suwen
   * @date 2020/5/10 上午11:42
   */
  boolean auditProject(String proId, Audit Audit);

  /**
   * 项目卡片增加
   *
   * @param expProject  项目卡片
   * @return int 状态码
   * @author suwen
   * @date 2020/2/6 2:51 下午
   */
  boolean addProject(ExpProject expProject) throws Exception;

}
