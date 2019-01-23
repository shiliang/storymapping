package com.nju.storymapping.entity;/*
 * @program:com.nju.storymapping.entity
 * @description:卡片的操作记录
 * @author:shiliang
 * @create:2019-01-23 20:38
 * */

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class OperationLog {
    @Id
    @GeneratedValue
    private long id;
    //对应的卡片id
    private long card_id;
    //操作的时间
    private Date op_date;
    //操作人
    private String op_name;
    //操作记录
    private String op_log;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCard_id() {
        return card_id;
    }

    public void setCard_id(long card_id) {
        this.card_id = card_id;
    }

    public Date getOp_date() {
        return op_date;
    }

    public void setOp_date(Date op_date) {
        this.op_date = op_date;
    }

    public String getOp_name() {
        return op_name;
    }

    public void setOp_name(String op_name) {
        this.op_name = op_name;
    }

    public String getOp_log() {
        return op_log;
    }

    public void setOp_log(String op_log) {
        this.op_log = op_log;
    }
}
