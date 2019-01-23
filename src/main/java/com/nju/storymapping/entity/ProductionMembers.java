package com.nju.storymapping.entity;/*
 * @program:com.nju.storymapping.entity
 * @description:产品成员
 * @author:shiliang
 * @create:2019-01-23 19:54
 * */

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ProductionMembers {
    @Id
    @GeneratedValue
    private long id;

    //用户id
    private long User_id;
    //权限，0为管理员，1为成员
    private int role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return User_id;
    }

    public void setUser_id(long user_id) {
        User_id = user_id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }


}
