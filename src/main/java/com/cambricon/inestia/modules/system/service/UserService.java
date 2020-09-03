package com.cambricon.inestia.modules.system.service;


import com.cambricon.inestia.modules.system.po.User;

import java.util.List;

public interface UserService {


    User findOne(Long userId);

    List<User> findAll();

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username);


}