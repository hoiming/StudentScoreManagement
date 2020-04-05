package com.haiming.dao;

import javax.annotation.Generated;

public class Score {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6725128+08:00", comments="Source field: score.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6725128+08:00", comments="Source field: score.course_id")
    private Integer courseId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6735117+08:00", comments="Source field: score.student_id")
    private Integer studentId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6735117+08:00", comments="Source field: score.score")
    private Integer score;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6725128+08:00", comments="Source field: score.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6725128+08:00", comments="Source field: score.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6725128+08:00", comments="Source field: score.course_id")
    public Integer getCourseId() {
        return courseId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6735117+08:00", comments="Source field: score.course_id")
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6735117+08:00", comments="Source field: score.student_id")
    public Integer getStudentId() {
        return studentId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6735117+08:00", comments="Source field: score.student_id")
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6735117+08:00", comments="Source field: score.score")
    public Integer getScore() {
        return score;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6735117+08:00", comments="Source field: score.score")
    public void setScore(Integer score) {
        this.score = score;
    }
}