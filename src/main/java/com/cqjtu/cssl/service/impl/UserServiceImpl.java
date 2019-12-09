package com.cqjtu.cssl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cqjtu.cssl.entity.User;
import com.cqjtu.cssl.mapper.UserMapper;
import com.cqjtu.cssl.service.UserService;


@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper ;

    @Override
    public User get(String userNo) {

        User user = null;
        user=userMapper.selectByPrimaryKey(userNo);
        return user;

    }

    @Override
    public void addUser(User user) {

        userMapper.insert(user);

    }

}