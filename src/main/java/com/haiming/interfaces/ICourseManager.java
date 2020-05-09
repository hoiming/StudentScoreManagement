package com.haiming.interfaces;

import com.haiming.dao.Course;
import com.haiming.viewmodels.CoursesViewModel;

import java.util.List;

public interface ICourseManager {

    Course CreateCourse(Course course);

    int DeleteCourse(int id);

    int UpdateCourse(Course course);

    Course GetCourse(int id);

    CoursesViewModel GetCourseList(int pageIndex, int pageSize);
}
