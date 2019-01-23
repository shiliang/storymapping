package com.nju.storymapping.entity;/*
 * @program:com.nju.storymapping.entity
 * @description:卡片信息
 * @author:shiliang
 * @create:2019-01-23 20:16
 * */

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Card {
    @Id
    @GeneratedValue
    private long id;
    //所属项目id
    private long project_id;
    //编号
    private int number;
    //标题
    private String title;
    //类型
    private String type;
    //流程状态
    private String process_status;
    //负责人
    private String responsible_person;
    //创建时间
    private Date createdate;
    //优先级,0非常高，1高，2中，3低
    private int priority;
    //所属计划
    private String plan;
    //故事描述
    private String story_description;
    //验证标准
    private String verify_criteria;



}
