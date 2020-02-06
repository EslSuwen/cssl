package com.cqjtu.cssl.mapper;

import com.cqjtu.cssl.entity.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * 用户 mapper
 *
 * @author: suwen
 * @time: 2020/2/6 3:29 下午
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

  /**
   * 根据用户名查询用户
   *
   * @author: suwen
   * @time: 2020/2/6 3:25 下午
   * @param username 用户名
   * @return: com.cqjtu.cssl.entity.User
   */
  @Select("select * from users where username = #{username}")
  User selectByUserName(String username);
}
