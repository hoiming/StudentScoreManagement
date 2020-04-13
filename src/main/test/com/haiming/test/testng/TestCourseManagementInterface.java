package com.haiming.test.testng;

import com.haiming.config.TestConfig;
import com.haiming.dao.Course;
import com.haiming.interfaces.ICourseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
@ContextConfiguration(classes = TestConfig.class)
public class TestCourseManagementInterface extends AbstractTestNGSpringContextTests {

    @Autowired
    @Qualifier("TestCourseManager")
    private ICourseManager courseManager;

    @Test(priority = 0)
    public void testCreateCourse(){
        Course course = new Course();
        course.setTeachername("孙微微");
        course.setCoursename("操作系统");
        course.setId(1);
        Course newCourse = courseManager.CreateCourse(course);
        Assert.assertNotNull(newCourse.getId());
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
