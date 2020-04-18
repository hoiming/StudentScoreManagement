package com.haiming.controller;

import com.haiming.dao.Course;
import com.haiming.interfaces.ICourseManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private Logger logger = LoggerFactory.getLogger(CourseController.class);

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
    public @ResponseBody Course CreateCourse(@RequestBody Course course, HttpServletResponse response){
        logger.debug("Requested object: " + course.toString());
        response.setStatus(201);
        return courseManager.CreateCourse(course);
    }

    @PostMapping("/update/{id}")
    public @ResponseBody void UpdateCourse(@PathVariable Integer id, @RequestBody Course course, HttpServletResponse response){
        Course fromDB = courseManager.GetCourse(id);
        if(fromDB == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        BeanUtils.copyProperties(course, fromDB);
        response.setStatus(200);
        courseManager.UpdateCourse(fromDB);
    }
}
