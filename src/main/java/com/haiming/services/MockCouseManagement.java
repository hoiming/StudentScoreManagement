package com.haiming.services;

import com.haiming.dao.Course;
import com.haiming.interfaces.ICourseManager;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MockCouseManagement implements ICourseManager {

    private List<Course> courseList = new ArrayList<Course>();

    @Override
    public int CreateCourse(Course course) {
        courseList.add(course);
        return 1;
    }

    @Override
    public int DeleteCourse(int id) {
        Optional<Course> courseOptional = courseList.stream().filter(c -> c.getId() == id).findFirst();
        if(courseOptional.isPresent()){
            courseList.remove(courseOptional.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int UpdateCourse(Course course) {
        Optional<Course> courseOptional = courseList.stream().filter(c -> c.getId() == course.getId()).findFirst();
        if(courseOptional.isPresent()){
            BeanUtils.copyProperties(course, courseOptional.get());
            return 1;
        }
        return 0;
    }

    @Override
    public Course GetCourse(int id) {
        Optional<Course> courseOptional = courseList.stream().filter(c -> c.getId() == id).findFirst();
        if(courseOptional.isPresent()){
            return courseOptional.get();
        }
        return null;
    }
}
