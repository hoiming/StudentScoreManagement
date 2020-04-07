package com.haiming.test;

import com.haiming.dao.*;
import com.haiming.dao.Student;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.where.condition.IsEqualTo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.mybatis.dynamic.sql.SqlBuilder;
import com.haiming.dao.StudentMapper;

import  com.haiming.dao.StudentDynamicSqlSupport;
import static org.mybatis.dynamic.sql.SqlBuilder.equalTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.haiming.dao.CourseDynamicSqlSupport;
import com.haiming.dao.StudentCourseScoreDynamicSqlSupport;

public class TestDAOCRUD {
    private SqlSession sqlSession;
    private ApplicationContext context;
    @BeforeMethod
    public void setUp(){
        context = new ClassPathXmlApplicationContext("spring-config.xml");
        sqlSession = context.getBean("sqlSession", SqlSession.class);
    }

    //@Test
    public void testInsertStudentToDB() throws ParseException {
        Student record = new Student();
        record.setName("梁海明" + RandomStringUtils.randomAlphabetic(5));
        record.setGender("M");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        record.setBirthday(simpleDateFormat.parse("1989-08-15"));
        record.setAddress("长坦路7巷4号");
        record.setTelephone("15626001565");
        StudentDynamicSqlSupport.Student studentTable = new StudentDynamicSqlSupport.Student();
        InsertStatementProvider<Student> insertStatement =
                SqlBuilder.insert(record).into(studentTable)
                .map(StudentDynamicSqlSupport.id).toProperty("id")
                .map(StudentDynamicSqlSupport.name).toProperty("name")
                .map(StudentDynamicSqlSupport.address).toProperty("address")
                .map(StudentDynamicSqlSupport.gender).toProperty("gender")
                .map(StudentDynamicSqlSupport.birthday).toProperty("birthday")
                .map(StudentDynamicSqlSupport.telephone).toProperty("telephone")
                .build()
                .render(RenderingStrategies.MYBATIS3);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int rows = mapper.insert(insertStatement);
        Assert.assertEquals(rows, 1, "Should insert one row into database.");
    }

    //@Test
    public void insertCouseIntoDB(){
        Course record = new Course();
        record.setCoursename("计算机组成原理" + RandomStringUtils.randomAlphabetic(5));
        record.setTeachername("黄老师");
        CourseDynamicSqlSupport.Course courseTable = new CourseDynamicSqlSupport.Course();
        InsertStatementProvider<Course> insertStatement = SqlBuilder.insert(record).into(courseTable)
                .map(CourseDynamicSqlSupport.id).toProperty("id")
                .map(CourseDynamicSqlSupport.coursename).toProperty("coursename")
                .map(CourseDynamicSqlSupport.teachername).toProperty("teachername")
                .build()
                .render(RenderingStrategies.MYBATIS3);
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        int rows = mapper.insert(insertStatement);
        Assert.assertEquals(rows, 1, "Should insert one row into database.");
    }

    //@Test
    public void testInsertScoreIntoDB(){
        StudentCourseScore record = new StudentCourseScore();
        record.setCourseId(2);
        record.setStudentId(2);
        record.setScore(100);
        StudentCourseScoreDynamicSqlSupport.StudentCourseScore scoreTable = new StudentCourseScoreDynamicSqlSupport.StudentCourseScore();
        InsertStatementProvider<StudentCourseScore> insertStatement = SqlBuilder.insert(record).into(scoreTable)
                .map(StudentCourseScoreDynamicSqlSupport.id).toProperty("id")
                .map(StudentCourseScoreDynamicSqlSupport.courseId).toProperty("courseId")
                .map(StudentCourseScoreDynamicSqlSupport.studentId).toProperty("studentId")
                .map(StudentCourseScoreDynamicSqlSupport.score).toProperty("score")
                .build()
                .render(RenderingStrategies.MYBATIS3);
        StudentCourseScoreMapper mapper = sqlSession.getMapper(StudentCourseScoreMapper.class);
        int rows = mapper.insert(insertStatement);
        Assert.assertEquals(rows, 1, "Should insert one row into Score table");
    }

    //@Test
    public void testDeleteStudent(){
        StudentDynamicSqlSupport.Student studentTable = new StudentDynamicSqlSupport.Student();
        DeleteStatementProvider deleteStatementProvider = SqlBuilder.deleteFrom(studentTable)
                .where(StudentDynamicSqlSupport.id, isEqualTo(6))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int rows = mapper.deleteByPrimaryKey(6);
        Assert.assertTrue(rows > 0);
    }

    //@Test
    public void testSelectStudent(){
        StudentDynamicSqlSupport.Student studentTable = new StudentDynamicSqlSupport.Student();
        SelectStatementProvider selectStatementProvider =
                SqlBuilder.select(StudentDynamicSqlSupport.id, StudentDynamicSqlSupport.address,
                        StudentDynamicSqlSupport.birthday, StudentDynamicSqlSupport.gender,
                        StudentDynamicSqlSupport.telephone, StudentDynamicSqlSupport.name)
                    .from(studentTable)
                    .where(StudentDynamicSqlSupport.id, isEqualTo(5))
                    .build().render(RenderingStrategies.MYBATIS3);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Optional<Student> student = mapper.selectOne(selectStatementProvider);
        Assert.assertEquals(student.get().getName(), "梁海明SWSCT");

    }

    @Test
    public void testSelectStudentCourseScoreUsingJoin(){
            CourseDynamicSqlSupport.Course courseTable = new CourseDynamicSqlSupport.Course();
            StudentCourseScoreDynamicSqlSupport.StudentCourseScore scsTable = new StudentCourseScoreDynamicSqlSupport.StudentCourseScore();
            SelectStatementProvider selectStatementProvider =
                    SqlBuilder.select(StudentCourseScoreDynamicSqlSupport.id, StudentCourseScoreDynamicSqlSupport.courseId,
                            StudentCourseScoreDynamicSqlSupport.studentId, CourseDynamicSqlSupport.coursename, CourseDynamicSqlSupport.teachername,
                            StudentCourseScoreDynamicSqlSupport.score)
                            .from(courseTable)
                            .join(scsTable).on(CourseDynamicSqlSupport.id, equalTo(scsTable.courseId))
                            .where(CourseDynamicSqlSupport.id, isEqualTo(5))
                            .build().render(RenderingStrategies.MYBATIS3);

            StudentCourseScoreMapper mapper = sqlSession.getMapper(StudentCourseScoreMapper.class);
            Optional<StudentCourseScoreFull> full = mapper.selectOneFullById(selectStatementProvider);
            Assert.assertNotNull(full.get());

    }
}
