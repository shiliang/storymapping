package com.nju.storymapping.service.impl;/*
 * @program:com.nju.storymapping.service.impl
 * @description:用户服务实现类
 * @author:shiliang
 * @create:2019-01-14 21:36
 * */

import com.nju.storymapping.entity.LoginTicket;
import com.nju.storymapping.entity.User;
import com.nju.storymapping.mapper.UserMapper;
import com.nju.storymapping.service.LoginTicketService;
import com.nju.storymapping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LoginTicketService loginTicketService;

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
    public User addUser(User user) {
        userMapper.addUser(user);
        return user;
    }

    @Override
    public String addLoginTicket(long userId) {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(userId);
        Date now = new Date();
        now.setTime(3600*24*160 + now.getTime());
        loginTicket.setExpired(now);
        loginTicket.setStatus(0);
        loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-",""));
        loginTicketService.addTicket(loginTicket);
        return loginTicket.getTicket();
    }

}
