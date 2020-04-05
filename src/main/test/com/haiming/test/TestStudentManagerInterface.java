package com.haiming.test;

import com.haiming.dao.Student;
import com.haiming.interfaces.IStudentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class TestStudentManagerInterface extends AbstractTestNGSpringContextTests {

    @Autowired
    IStudentManager studentManager;

    @Test
    public void testInsertStudent(){
        Student student = new Student();
        student.setId(1);
        student.setName("foobar");
        student.setTelephone("2342342334");
        student.setAddress("广州市天河区");
        student.setGender("M");
        int rows = studentManager.CreateStudent(student);
        Assert.assertTrue(rows == 1);
    }
}
