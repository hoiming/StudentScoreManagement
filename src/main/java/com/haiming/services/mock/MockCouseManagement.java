package com.haiming.services.mock;

import com.haiming.dao.Course;
import com.haiming.interfaces.ICourseManager;
import com.haiming.viewmodels.CoursesViewModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("TestCourseManager")
public class MockCouseManagement implements ICourseManager {

    private List<Course> courseList = new ArrayList<Course>();

    @Override
    public Course CreateCourse(Course course) {
        course.setId(1);
        courseList.add(course);
        return course;
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

    @Override
    public CoursesViewModel GetCourseList(int pageIndex, int pageSize) {
        List<Course> sliced = courseList.subList(pageIndex, pageSize);
        CoursesViewModel viewModel = new CoursesViewModel();
        viewModel.setPageIndex(pageIndex + pageSize);
        viewModel.setCourses(sliced);
        return viewModel;
    }

    @Override
    public long CoursesSize() {
        return 0;
    }


}
