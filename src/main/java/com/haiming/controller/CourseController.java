package com.haiming.controller;

import com.haiming.dao.Course;
import com.haiming.interfaces.ICourseManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    @Qualifier("ConcreteCourseManager")
    private ICourseManager courseManager;

    @GetMapping("")
    public @ResponseBody List<Course> CourseList(){
        return courseManager.GetCourseList();
    }

    @GetMapping("/{id}")
    public @ResponseBody Course GetCourse(@PathVariable Integer id){
        return courseManager.GetCourse(id);
    }

    @PostMapping("/create")
    public @ResponseBody Course CreateCourse(@RequestBody Course course){
        return courseManager.CreateCourse(course);
    }

    @PostMapping("/update")
    public @ResponseBody void UpdateCourse(@RequestBody Course course, HttpServletResponse response){
        Course fromDB = courseManager.GetCourse(course.getId());
        if(fromDB == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        BeanUtils.copyProperties(course, fromDB);
        courseManager.UpdateCourse(fromDB);
    }
}
