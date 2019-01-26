package com.nju.storymapping.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "beginDate")
    private Date beginDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "descri")
    private String describe;

    @Column(name = "delivery")
    private Boolean delivery;

    @ManyToOne(fetch = FetchType.LAZY)
    private Plan fatherPlan;

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }

    public void setFatherPlan(Plan fatherPlan) {
        this.fatherPlan = fatherPlan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Plan getFatherPlan() {
        return fatherPlan;
    }

    public void setFatherProjectId(Plan fatherPlan) {
        this.fatherPlan = fatherPlan;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
