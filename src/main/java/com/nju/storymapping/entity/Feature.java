package com.nju.storymapping.entity;/*
 * @program:com.nju.storymapping.entity
 * @description:类型如Story,Task,Bug.....
 * @author:shiliang
 * @create:2019-01-23 21:13
 * */

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Feature {
    @Id
    @GeneratedValue
    private long id;
    //类型
    private String type;
    //颜色
    private String color;
    //类型来源
    private String type_source;
    //描述
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType_source() {
        return type_source;
    }

    public void setType_source(String type_source) {
        this.type_source = type_source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
