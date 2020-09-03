package com.cambricon.inestia.modules.system.service.impl;

import com.cambricon.inestia.modules.system.mapper.UserMapper;
import com.cambricon.inestia.modules.system.po.User;
import com.cambricon.inestia.modules.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findOne(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public User findByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        userMapper.selectOne(user);
        return userMapper.selectOne(user);
    }

}
