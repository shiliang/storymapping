package com.nju.storymapping.service.impl;/*
 * @program:com.nju.storymapping.service.impl
 * @description:用户服务实现类
 * @author:shiliang
 * @create:2019-01-14 21:36
 * */

import com.nju.storymapping.entity.User;
import com.nju.storymapping.mapper.UserMapper;
import com.nju.storymapping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public HashMap<String, String> register(String username, String password) {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public int addUser(User user) {
        int userId = userMapper.addUser(user);
        return userId;
    }

}
