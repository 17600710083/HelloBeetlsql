package com.liutong.entity;

import io.swagger.models.auth.In;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class User {
    private Integer id ;
    private Integer age ;
    private String name ;
    private Date createDate ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
