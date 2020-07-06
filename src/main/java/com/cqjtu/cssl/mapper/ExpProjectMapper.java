package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.ExpProject;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 项目(实验卡片) Mapper 接口
 *
 * @author Aplin suwen
 * @date 2020/2/6 3:30 下午
 */
public interface ExpProjectMapper extends BaseMapper<ExpProject> {

  /**
   * 获得存在学期
   *
   * @return 学期列表
   * @author suwen
   * @date 2020/6/1 下午10:12
   */
  @Select("SELECT DISTINCT term FROM exp_project;")
  List<String> getTermList();
}
