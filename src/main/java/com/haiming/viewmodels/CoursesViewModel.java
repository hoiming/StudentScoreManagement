package com.haiming.viewmodels;

import com.haiming.dao.Course;

import java.util.List;

public class CoursesViewModel {

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    private int pageIndex;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    private List<Course> courses;


}
