package com.haiming.services.concrete;

import com.haiming.dao.Course;
import com.haiming.dao.CourseDynamicSqlSupport;
import com.haiming.dao.CourseMapper;
import com.haiming.interfaces.ICourseManager;
import com.haiming.viewmodels.CoursesViewModel;
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
    public CoursesViewModel GetCourseList(int pageIndex, int pageSize) {
        List<Course> courses = courseMapper.select(c -> c.where().orderBy(CourseDynamicSqlSupport.id).limit(pageSize).offset(pageIndex));
        CoursesViewModel viewModel = new CoursesViewModel();
        viewModel.setPageIndex(pageIndex + pageSize);
        viewModel.setCourses(courses);
        return viewModel;
    }

    @Override
    public long CoursesSize() {
        return courseMapper.count(c -> c.where());
    }
}
