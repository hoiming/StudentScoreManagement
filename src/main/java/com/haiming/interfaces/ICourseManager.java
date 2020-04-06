package com.haiming.interfaces;

import com.haiming.dao.Course;

public interface ICourseManager {

    int CreateCourse(Course course);

    int DeleteCourse(int id);

    int UpdateCourse(Course course);

    Course GetCourse(int id);
}
