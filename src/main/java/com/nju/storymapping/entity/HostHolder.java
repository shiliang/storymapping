package com.nju.storymapping.entity;

/*
    存放取出的用户信息便于上下文调用,用threadlocal进行线程隔离
 */

import org.springframework.stereotype.Component;

@Component
public class HostHolder {
    private static ThreadLocal<User> users = new ThreadLocal<User>();

    public User getUser() {
        return users.get();
    }

    public void setUser(User user) {
        users.set(user);
    }

    public void clear() {
        users.remove();
    }
}
