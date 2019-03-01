package com.nju.storymapping.service;


import com.nju.storymapping.entity.LoginTicket;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface LoginTicketService {
    void addTicket(LoginTicket ticket);
    LoginTicket selectByTicket(String ticket);
    void updateStatus(String ticket, int status);
    String getTicketByUserId(long userId);
}
