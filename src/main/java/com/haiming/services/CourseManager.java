package com.haiming.services;

import com.haiming.dao.Course;
import com.haiming.dao.CourseMapper;
import com.haiming.interfaces.ICourseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("ConcreteCourseManager")
public class CourseManager implements ICourseManager {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Course CreateCourse(Course course) {
        int rows = courseMapper.insert(course);
        return course;
    }

    @Override
    public int DeleteCourse(int id) {
        return 0;
    }

    @Override
    public int UpdateCourse(Course course) {
        return courseMapper.updateByPrimaryKey(course);
    }

    @Override
    public Course GetCourse(int id) {
        return courseMapper.selectByPrimaryKey(id).orElse(null);
    }

    @Override
    public List<Course> GetCourseList() {
        return courseMapper.select(c -> c.where());
    }
}
