package com.haiming.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class StudentCourseScoreDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.2009491+08:00", comments="Source Table: student_course_score")
    public static final StudentCourseScore studentCourseScore = new StudentCourseScore();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.2009491+08:00", comments="Source field: student_course_score.id")
    public static final SqlColumn<Integer> id = studentCourseScore.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.2009491+08:00", comments="Source field: student_course_score.course_id")
    public static final SqlColumn<Integer> courseId = studentCourseScore.courseId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.2009491+08:00", comments="Source field: student_course_score.student_id")
    public static final SqlColumn<Integer> studentId = studentCourseScore.studentId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.2019481+08:00", comments="Source field: student_course_score.score")
    public static final SqlColumn<Integer> score = studentCourseScore.score;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.2009491+08:00", comments="Source Table: student_course_score")
    public static final class StudentCourseScore extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> courseId = column("course_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> studentId = column("student_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> score = column("score", JDBCType.INTEGER);

        public StudentCourseScore() {
            super("student_course_score");
        }
    }
}