package com.cqjtu.cssl.service;

import com.cqjtu.cssl.entity.TeacherMsg;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 用户信息服务类
 *
 * @author suwen
 * @since 2020-03-23
 */
public interface TeacherMsgService extends IService<TeacherMsg> {

  /**
   * 根据教师 id 获取消息
   *
   * @param tid 老师编号
   * @author suwen
   * @date 2020/3/23 17:28 下午
   * @return 授课信息列表
   */
  List<TeacherMsg> getMsgListByTid(String tid);
}
