package com.haiming.test.testng;

import com.haiming.config.TestConfig;
import com.haiming.dao.Course;
import com.haiming.dao.Student;
import com.haiming.dao.StudentCourseScore;
import com.haiming.interfaces.ICourseManager;
import com.haiming.interfaces.IScoreManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@ContextConfiguration(classes = TestConfig.class)
public class TestScoreManagerInterface extends AbstractTestNGSpringContextTests {

    @Autowired
    @Qualifier("MockScoreManager")
    private IScoreManager scoreManager;

    @Test(priority = 0)
    public void testCreateScore(){
        Student student = new Student();
        student.setId(1);
        Course course = new Course();
        course.setId(1);
        StudentCourseScore score = scoreManager.CreateScore(student, course, 99);
        Assert.assertEquals(score.getScore(), Integer.valueOf(99));
    }

    @Test(priority = 1)
    public void testUpdateScore(){
        Student student = new Student();
        student.setId(1);
        Course course = new Course();
        course.setId(1);
        StudentCourseScore score = scoreManager.UpdateScore(1, student, course, 80);
        Assert.assertEquals(score.getScore(), Integer.valueOf(80));
    }
}
