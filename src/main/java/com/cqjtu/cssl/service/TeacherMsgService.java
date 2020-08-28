package com.cqjtu.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cssl.entity.TeacherMsg;

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

  /**
   * 新增消息
   *
   * @param msg 消息
   * @return bool
   * @author suwen
   * @date 2020/8/26 下午5:30
   */
  Boolean addMsg(TeacherMsg msg);

  /**
   * 删除消息
   *
   * @param ino 消息编号
   * @return bool
   * @author suwen
   * @date 2020/8/26 下午5:31
   */
  Boolean removeMsg(Integer ino);

  /**
   * 删除消息
   *
   * @param msg 消息
   * @return bool
   * @author suwen
   * @date 2020/8/26 下午5:31
   */
  Boolean updateMsg(TeacherMsg msg);
}
