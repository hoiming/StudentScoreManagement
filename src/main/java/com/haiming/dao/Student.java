package com.haiming.dao;

import java.util.Date;
import javax.annotation.Generated;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.170983+08:00", comments="Source field: student.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1739634+08:00", comments="Source field: student.name")
    @Size(max = 45)
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1739634+08:00", comments="Source field: student.gender")
    @Pattern(regexp = "M|F", message = "Only M or F, M for male, F for female")
    @Size(max = 1, min=1)
    private String gender;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1749629+08:00", comments="Source field: student.birthday")
    private Date birthday;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1749629+08:00", comments="Source field: student.telephone")
    @Size(max = 20)
    private String telephone;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1749629+08:00", comments="Source field: student.address")
    @Size(max = 200)
    private String address;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1739634+08:00", comments="Source field: student.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1739634+08:00", comments="Source field: student.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1739634+08:00", comments="Source field: student.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1739634+08:00", comments="Source field: student.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1749629+08:00", comments="Source field: student.gender")
    public String getGender() {
        return gender;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1749629+08:00", comments="Source field: student.gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1749629+08:00", comments="Source field: student.birthday")
    public Date getBirthday() {
        return birthday;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1749629+08:00", comments="Source field: student.birthday")
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1749629+08:00", comments="Source field: student.telephone")
    public String getTelephone() {
        return telephone;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1749629+08:00", comments="Source field: student.telephone")
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1749629+08:00", comments="Source field: student.address")
    public String getAddress() {
        return address;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1749629+08:00", comments="Source field: student.address")
    public void setAddress(String address) {
        this.address = address;
    }

    public String toString(){
        return "id: " + id + ", name: " + name + ", gender: " + gender + ", birthday: " + birthday
                + ", telephone: " + telephone + ", address: " + address;
    }
}