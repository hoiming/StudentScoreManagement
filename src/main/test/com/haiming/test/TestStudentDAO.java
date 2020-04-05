package com.haiming.test;

import com.haiming.dao.Student;
import com.haiming.dao.StudentDynamicSqlSupport;
import com.haiming.dao.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.mybatis.dynamic.sql.SqlBuilder;
import com.haiming.dao.StudentMapper;
import static com.haiming.dao.StudentDynamicSqlSupport.*;

public class TestStudentDAO {
    private SqlSession sqlSession;
    private ApplicationContext context;
    @BeforeMethod
    public void setUp(){
        context = new ClassPathXmlApplicationContext("spring-config.xml");
        sqlSession = context.getBean("sqlSession", SqlSession.class);
    }

    @Test
    public void testInsertStudentToDB() throws ParseException {
        Student record = new Student();
        record.setName("梁海明");
        record.setGender("M");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        record.setBirthday(simpleDateFormat.parse("1989-08-15"));
        record.setAddress("长坦路7巷4号");
        record.setTelephone("15626001565");
        StudentDynamicSqlSupport.Student studentTable = new StudentDynamicSqlSupport.Student();
        InsertStatementProvider<Student> insertStatement =
                SqlBuilder.insert(record).into(studentTable)
                .map(id).toProperty("id")
                .map(name).toProperty("name")
                .map(address).toProperty("address")
                .map(gender).toProperty("gender")
                .map(birthday).toProperty("birthday")
                .map(telephone).toProperty("telephone")
                .build()
                .render(RenderingStrategy.MYBATIS3);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int rows = mapper.insert(insertStatement);
        Assert.assertEquals(rows, 1, "Should insert one row into database.");
    }
}
