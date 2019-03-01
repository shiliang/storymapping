package com.nju.storymapping.interceptor;

import com.nju.storymapping.entity.HostHolder;
import com.nju.storymapping.entity.LoginTicket;
import com.nju.storymapping.entity.User;
import com.nju.storymapping.service.LoginTicketService;
import com.nju.storymapping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/*
    处理用户的访问请求
 */

@Component
public class PassportInterceptor implements HandlerInterceptor {
    @Autowired
    private LoginTicketService loginTicketService;

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ticket = null;
        String cookies = request.getHeader("Cookie");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("ticket")) {
                    ticket = cookie.getValue();
                    break;
                }
            }
        }

        if (ticket != null) {
            //ticket唯一
            LoginTicket loginTicket = loginTicketService.selectByTicket(ticket);
            //判断ticket是否有效
            if (loginTicket == null ||
                    loginTicket.getExpired().before(new Date()) || loginTicket.getStatus() != 0) {
                return true;
            }

            User user = userService.getUserById((int)loginTicket.getUserId());
            //注入用户信息
            hostHolder.setUser(user);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && hostHolder.getUser() != null) {
            modelAndView.addObject("user", hostHolder.getUser());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        hostHolder.clear();
    }
}
