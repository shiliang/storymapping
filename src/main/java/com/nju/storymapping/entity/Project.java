package com.nju.storymapping.entity;/*
 * @program:com.nju.storymapping.entity
 * @description:项目详情
 * @author:shiliang
 * @create:2019-01-23 20:10
 * */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private long id;
    //项目名称
    private String project_name;
    //项目标识
    private String project_identity;
    //项目描述
    private String project_description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_identity() {
        return project_identity;
    }

    public void setProject_identity(String project_identity) {
        this.project_identity = project_identity;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }
}
