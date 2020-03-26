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
  boolean isCardExist(String tid,String cid );

  /**
   * 根据老师编号和课程号查找对应卡片
   *
   * @author suwen
   * @date 2020/2/6 3:57 下午
   * @param tid 老师编号
   * @param cid 课程号
   */
  ExpProject getExpByTidCid(String tid,String cid );

}
