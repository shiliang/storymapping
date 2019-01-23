package com.nju.storymapping.entity;/*
 * @program:com.nju.storymapping.entity
 * @description:卡片底下的评论
 * @author:shiliang
 * @create:2019-01-23 20:44
 * */

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Comment {
    @Id
    @GeneratedValue
    private long id;
    //对应的卡片id
    private long card_id;
    //评论的时间
    private Date comment_date;
    //评论人
    private String comment_author;

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

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    public String getComment_author() {
        return comment_author;
    }

    public void setComment_author(String comment_author) {
        this.comment_author = comment_author;
    }
}
