package com.cqjtu.cssl.service;

import com.cqjtu.cssl.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {

    /**
     * 获取一条用户数据
     *
     * @param  userNo
     * @return User
     *
     */
    User get(String userNo);


    /**
     * 新增一条用户数据
     *
     * @param  user
     * @return User
     *
     */
    void addUser(User user);

}

