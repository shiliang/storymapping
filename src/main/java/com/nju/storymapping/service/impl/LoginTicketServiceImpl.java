package com.nju.storymapping.service.impl;

import com.nju.storymapping.entity.LoginTicket;
import com.nju.storymapping.mapper.LoginTicketMapper;
import com.nju.storymapping.service.LoginTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginTicketServiceImpl implements LoginTicketService {

    @Autowired
    private LoginTicketMapper loginTicketMapper;


    @Override
    public void addTicket(LoginTicket ticket) {
        loginTicketMapper.addTicket(ticket);
    }

    @Override
    public LoginTicket selectByTicket(String ticket) {
        return loginTicketMapper.selectByTicket(ticket);
    }

    @Override
    public void updateStatus(String ticket, int status) {
        loginTicketMapper.updateStatus(ticket,status);
    }

    @Override
    public String getTicketByUserId(long userId) {
        return loginTicketMapper.getTicketByUserId(userId);

    }
}
