package com.haiming.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CourseDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1979503+08:00", comments="Source Table: course")
    public static final Course course = new Course();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1989501+08:00", comments="Source field: course.id")
    public static final SqlColumn<Integer> id = course.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1989501+08:00", comments="Source field: course.coursename")
    public static final SqlColumn<String> coursename = course.coursename;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1989501+08:00", comments="Source field: course.teachername")
    public static final SqlColumn<String> teachername = course.teachername;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1979503+08:00", comments="Source Table: course")
    public static final class Course extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> coursename = column("coursename", JDBCType.VARCHAR);

        public final SqlColumn<String> teachername = column("teachername", JDBCType.VARCHAR);

        public Course() {
            super("course");
        }
    }
}