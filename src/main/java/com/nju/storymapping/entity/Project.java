package com.nju.storymapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Project {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "projectname")
    private String projectName;

    @ManyToOne
    private User user;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Plan> plans;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }
}
