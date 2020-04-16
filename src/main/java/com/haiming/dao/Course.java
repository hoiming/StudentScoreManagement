package com.haiming.dao;

import javax.annotation.Generated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public class Course {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1979503+08:00", comments="Source field: course.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1979503+08:00", comments="Source field: course.coursename")
    @Max(80)
    @NotBlank
    private String coursename;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1979503+08:00", comments="Source field: course.teachername")
    @Max(45)
    @NotBlank
    private String teachername;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1979503+08:00", comments="Source field: course.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1979503+08:00", comments="Source field: course.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1979503+08:00", comments="Source field: course.coursename")
    public String getCoursename() {
        return coursename;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1979503+08:00", comments="Source field: course.coursename")
    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1979503+08:00", comments="Source field: course.teachername")
    public String getTeachername() {
        return teachername;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1979503+08:00", comments="Source field: course.teachername")
    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }
}