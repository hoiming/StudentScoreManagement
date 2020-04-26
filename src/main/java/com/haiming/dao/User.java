package com.haiming.dao;

import javax.annotation.Generated;

public class User {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-26T17:01:38.382+08:00", comments="Source field: user.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-26T17:01:38.385+08:00", comments="Source field: user.username")
    private String username;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-26T17:01:38.385+08:00", comments="Source field: user.password")
    private String password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-26T17:01:38.385+08:00", comments="Source field: user.authorities")
    private String authorities;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-26T17:01:38.385+08:00", comments="Source field: user.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-26T17:01:38.385+08:00", comments="Source field: user.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-26T17:01:38.385+08:00", comments="Source field: user.username")
    public String getUsername() {
        return username;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-26T17:01:38.385+08:00", comments="Source field: user.username")
    public void setUsername(String username) {
        this.username = username;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-26T17:01:38.385+08:00", comments="Source field: user.password")
    public String getPassword() {
        return password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-26T17:01:38.385+08:00", comments="Source field: user.password")
    public void setPassword(String password) {
        this.password = password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-26T17:01:38.386+08:00", comments="Source field: user.authorities")
    public String getAuthorities() {
        return authorities;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-26T17:01:38.386+08:00", comments="Source field: user.authorities")
    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}