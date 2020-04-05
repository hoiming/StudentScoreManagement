package com.haiming.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ScoreDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6735117+08:00", comments="Source Table: score")
    public static final Score score = new Score();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6735117+08:00", comments="Source field: score.id")
    public static final SqlColumn<Integer> id = score.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6735117+08:00", comments="Source field: score.course_id")
    public static final SqlColumn<Integer> courseId = score.courseId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6735117+08:00", comments="Source field: score.student_id")
    public static final SqlColumn<Integer> studentId = score.studentId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6735117+08:00", comments="Source Table: score")
    public static final class Score extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> courseId = column("course_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> studentId = column("student_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> score = column("score", JDBCType.INTEGER);

        public Score() {
            super("score");
        }
    }
}