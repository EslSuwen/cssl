package com.cqjtu.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cssl.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户 mapper
 *
 * @author suwen
 * @date 2020/2/6 3:29 下午
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

  /**
   * 根据用户名查询用户
   *
   * @author suwen
   * @date 2020/2/6 3:25 下午
   * @param username 用户名
   * @return com.cqjtu.cssl.entity.User
   */
  @Select("select * from users where username = #{username}")
  User selectByUserName(String username);

  /**
   * 查询所有用户数据
   *
   * @author suwen
   * @date 2020/2/20 5:14 下午
   * @return List<com.cqjtu.cssl.entity.User>
   */
  @Select("select * from users")
  List<User> loadAll();
}
