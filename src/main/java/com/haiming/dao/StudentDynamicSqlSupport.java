package com.haiming.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class StudentDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1789603+08:00", comments="Source Table: student")
    public static final Student student = new Student();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1799599+08:00", comments="Source field: student.id")
    public static final SqlColumn<Integer> id = student.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1799599+08:00", comments="Source field: student.name")
    public static final SqlColumn<String> name = student.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1799599+08:00", comments="Source field: student.gender")
    public static final SqlColumn<String> gender = student.gender;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1799599+08:00", comments="Source field: student.birthday")
    public static final SqlColumn<Date> birthday = student.birthday;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1799599+08:00", comments="Source field: student.telephone")
    public static final SqlColumn<String> telephone = student.telephone;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1809596+08:00", comments="Source field: student.address")
    public static final SqlColumn<String> address = student.address;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1789603+08:00", comments="Source Table: student")
    public static final class Student extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> gender = column("gender", JDBCType.CHAR);

        public final SqlColumn<Date> birthday = column("birthday", JDBCType.DATE);

        public final SqlColumn<String> telephone = column("telephone", JDBCType.VARCHAR);

        public final SqlColumn<String> address = column("address", JDBCType.VARCHAR);

        public Student() {
            super("student");
        }
    }
}