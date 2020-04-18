package com.haiming.dao;

import javax.annotation.Generated;
import javax.validation.constraints.NotBlank;

public class StudentCourseScore {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1999498+08:00", comments="Source field: student_course_score.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.2009491+08:00", comments="Source field: student_course_score.course_id")
    @NotBlank
    private Integer courseId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.2009491+08:00", comments="Source field: student_course_score.student_id")
    @NotBlank
    private Integer studentId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.2009491+08:00", comments="Source field: student_course_score.score")
    @NotBlank
    private Integer score;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.2009491+08:00", comments="Source field: student_course_score.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.2009491+08:00", comments="Source field: student_course_score.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.2009491+08:00", comments="Source field: student_course_score.course_id")
    public Integer getCourseId() {
        return courseId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.2009491+08:00", comments="Source field: student_course_score.course_id")
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.2009491+08:00", comments="Source field: student_course_score.student_id")
    public Integer getStudentId() {
        return studentId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.2009491+08:00", comments="Source field: student_course_score.student_id")
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.2009491+08:00", comments="Source field: student_course_score.score")
    public Integer getScore() {
        return score;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.2009491+08:00", comments="Source field: student_course_score.score")
    public void setScore(Integer score) {
        this.score = score;
    }

    public String toString(){
        return "id: " + id + ", student_id: " + studentId + ", course_id: " + courseId;
    }
}