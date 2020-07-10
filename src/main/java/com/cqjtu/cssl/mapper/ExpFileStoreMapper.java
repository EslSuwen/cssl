package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.ExpFileStore;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 项目文件储存 Mapper 接口
 *
 * @author suwen
 * @since 2020-07-07
 */
public interface ExpFileStoreMapper extends BaseMapper<ExpFileStore> {

  /**
   * 获取文件储存信息除文件
   *
   * @param proId 卡片编号
   * @return 件储存信息
   * @author suwen
   * @date 2020/7/8 下午1:38
   */
  @Select("SELECT no, pro_id, `name`, type_name FROM exp_file_store WHERE pro_id = #{param1};")
  List<ExpFileStore> getQuickFile(Integer proId);
}
