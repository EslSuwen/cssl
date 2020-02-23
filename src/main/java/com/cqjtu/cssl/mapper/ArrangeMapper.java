package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.Arrange;
import org.apache.ibatis.annotations.Select;

/**
 * 实验室安排 Mapper 接口
 *
 * @author suwen
 * @since 2020-02-21
 */
public interface ArrangeMapper extends BaseMapper<Arrange> {

  /**
   * 通过课程编号查询实验室编号
   *
   * @param courseNo 课程编号
   * @return 实验室编号
   * @author suwen
   * @date 2020/2/23 下午1:32
   */
  @Select("select lab_id from arrange where course_Id = #{courseNo}")
  String findLabByClsNo(Integer courseNo);
}
