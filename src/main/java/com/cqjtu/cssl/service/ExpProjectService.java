package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.entity.ExpProject;

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
  boolean isCardExist(String tid, Integer cid);

  /**
   * 根据老师编号和课程号查找对应卡片
   *
   * @author suwen
   * @date 2020/2/6 3:57 下午
   * @param tid 老师编号
   * @param cid 课程号
   */
  ExpProject getExpByTidCid(String tid, Integer cid);

  /**
   * 根据老师编号和课程号查找对应卡片
   *
   * @return 实验资料
   * @author suwen
   * @date 2020/5/26 5:57 下午
   * @param tid 老师编号
   * @param term 学期
   */
  List<ExpProject> getExpByTid(String tid, String term);

  /**
   * 获取待审核项目卡片数据
   *
   * @return java.lang.Iterable<com.cqjtu.cssl.entity.Project>
   * @author suwen
   * @date 2020/5/10 11:14 上午
   *     <p>List<ExpProject> getAuditProjects();
   */

  /**
   * 审核项目卡片
   *
   * @param proId 卡片id
   * @param Audit 审核状态
   * @return 状态
   * @author suwen
   * @date 2020/5/10 上午11:42
   *     <p>boolean auditProject(String proId, Audit Audit);
   */

  /**
   * 项目卡片增加
   *
   * @param expProject 项目卡片
   * @return int 状态码
   * @author suwen
   * @date 2020/2/6 2:51 下午
   */
  boolean addProject(ExpProject expProject) throws Exception;

  /**
   * 获得存在学期列表
   *
   * @return 学期列表
   * @author suwen
   * @date 2020/6/1 下午10:06
   */
  List<String> getTermList();

  /**
   * 重用以往卡片信息
   *
   * @param tid 教师编号
   * @param courseId 课程编号
   * @return 卡片信息
   * @author suwen
   * @date 2020/7/1 下午4:55
   */
  ExpProject reuseCard(String tid, String courseId);

  /**
   * 更新卡片信息
   *
   * @param expProject 卡片信息
   * @return 成功（true）/ 失败 （false）
   * @author suwen
   * @date 2020/7/5 下午3:33
   */
  Boolean updateExp(ExpProject expProject);

  /**
   * 删除项目卡片
   *
   * @param proId 卡片编号
   * @return 成功（true）/ 失败 （false）
   * @author suwen
   * @date 2020/7/6 上午9:32
   */
  Boolean deleteExp(int proId);
}
