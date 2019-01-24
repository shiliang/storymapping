//<<<<<<< Updated upstream
//package com.nju.storymapping.entity;/*
// * @program:com.nju.storymapping.entity
// * @description:卡片信息
// * @author:shiliang
// * @create:2019-01-23 20:16
// * */
//
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import java.util.Date;
//
//public class Card {
//    @Id
//    @GeneratedValue
//    private long id;
//    //所属项目id
//    private long project_id;
//    //编号
//    private int number;
//    //标题
//    private String title;
//    //类型
//    private String type;
//    //流程状态
//    private String process_status;
//    //负责人
//    private String responsible_person;
//    //创建时间
//    private Date createdate;
//    //优先级,0非常高，1高，2中，3低
//    private int priority;
//    //所属计划
//    private String plan;
//    //故事描述
//    private String story_description;
//    //验证标准
//    private String verify_criteria;
//
//
//
//=======
package com.nju.storymapping.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;   //标题

    //编号
    @Column(name = "number")
    private int number;

    @Column(name = "content")
    private String content; //内容

    @Column(name = "status")
    private String status;  //状态

    @Column(name = "type")
    private String type;

    @Column(name = "personInCharge")
    private String personInCharge;  //负责人

    @Column(name = "date")
    private Date date;  //日期

    @ManyToOne
    private Project belongProject; //所属计划

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge;
    }

    public Project getBelongProject() {
        return belongProject;
    }

    public void setBelongProject(Project belongProject) {
        this.belongProject = belongProject;
    }
//>>>>>>> Stashed changes
}
