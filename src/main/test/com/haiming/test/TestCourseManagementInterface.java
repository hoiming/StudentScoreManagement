package com.haiming.test;

import com.haiming.dao.Course;
import com.haiming.interfaces.ICourseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class TestCourseManagementInterface extends AbstractTestNGSpringContextTests {

    @Autowired
    private ICourseManager courseManager;

    @Test(priority = 0)
    public void testCreateCourse(){
        Course course = new Course();
        course.setTeachername("孙微微");
        course.setCoursename("操作系统");
        course.setId(1);
        int rows = courseManager.CreateCourse(course);
        Assert.assertTrue(rows == 1);
    }

    @Test(priority = 1)
    public void testUpdateCourse(){
        Course course = courseManager.GetCourse(1);
        course.setCoursename("AAAAAAA");
        int rows = courseManager.UpdateCourse(course);
        Assert.assertTrue(rows == 1);
    }

    @Test(priority = 2)
    public void testGetCourse(){
        Course course = courseManager.GetCourse(1);
        Assert.assertNotNull(course);
    }

    @Test(priority = 3)
    public void testDeleteCourse(){
        int rows = courseManager.DeleteCourse(1);
        Assert.assertTrue(rows == 1);
    }
}
