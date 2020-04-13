package com.haiming.test.testng;

import com.haiming.config.AppConfig;
import com.haiming.config.TestConfig;
import com.haiming.dao.Student;
import com.haiming.interfaces.IStudentManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

/**
 * 整合TestNG和Spring测试，需要配置componentscan，把Mock的类注解为Service
 * 告诉testcase spring的配置文件在哪里
 * testcase类需要继承AbstractTestNGSpringContextTests
 * 可以通过priority指定testcase之间的执行顺序
 */
@Test
@ContextConfiguration(classes = TestConfig.class)
//@ComponentScan(basePackages = {"com.haiming.services"})
public class TestStudentManagerInterface extends AbstractTestNGSpringContextTests {

    @Autowired
    @Qualifier("MockStudentManager")
    IStudentManager studentManager;

    @Test(priority = 0)
    public void testInsertStudent() {
        Student student = new Student();
        student.setId(1);
        student.setName("foobar");
        student.setTelephone("2342342334");
        student.setAddress("广州市天河区");
        student.setGender("M");
        Student createdStudent = studentManager.CreateStudent(student);
        Assert.assertNotNull(createdStudent.getId());
    }

    @Test(priority = 1)
    public void testUpdateStudent() {
        Student student = studentManager.GetStudent(1);
        String name = RandomStringUtils.randomAlphabetic(10);
        student.setName(name);
        int rows = studentManager.UpdateStudent(student);
        Assert.assertTrue(rows == 1);
        student = studentManager.GetStudent(1);
        Assert.assertEquals(name, student.getName());
    }

    @Test(priority = 2)
    public void testGetStudent() {
        Student student = studentManager.GetStudent(1);
        Assert.assertNotNull(student);
    }

    @Test(priority = 3)
    public void testGetStudentList() {
        List<Student> studentList = studentManager.GetStudentList();
        Assert.assertNotNull(studentList);
        Assert.assertTrue(studentList.size() >= 0);
    }

    @Test(priority = 4)
    public void testDeleteStudent() {
        int rows = studentManager.DeleteStudent(1);
        Assert.assertTrue(rows == 1);
    }
}
