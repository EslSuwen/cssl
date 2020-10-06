package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.Course;
import com.cqjtu.cssl.entity.Teach;

import java.util.List;

/**
 * 授课 Mapper 接口
 *
 * @author suwen
 * @date 2020/2/6 3:30 下午
 */
public interface TeachMapper extends BaseMapper<Teach> {

    /**
     * 通过教师编号查找授课信息
     *
     * @param tid 教师编号
     * @return 授课信息
     * @author suwen
     * @date 2020/10/5 下午2:18
     */
    List<Teach> selectAll(String tid);

    /**
     * 通过教师编号查找可增加课程信息
     *
     * @param tid 教师编号
     * @return 课程
     * @author suwen
     * @date 2020/10/5 下午3:08
     */
    List<Course> selectAvailableCourse(String tid);

  /**
   * 通过教职工号查询出他的所教且过滤已经填写卡片信息的课程
   *
   * @param tid 教职工编号
   * @param term 学期
   * @return 授课信息列表
   * @author suwen
   * @date 2020/10/5 下午7:14
   */
  List<Teach> getCourseInfoByTid(String tid, String term);
}
