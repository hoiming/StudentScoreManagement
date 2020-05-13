package com.haiming.controller;

import com.haiming.aspect.LoggingAspect;
import com.haiming.beans.CoursesProps;
import com.haiming.dao.Course;
import com.haiming.interfaces.ICourseManager;
import com.haiming.viewmodels.CoursesViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import org.springframework.hateoas.CollectionModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    @Qualifier("ConcreteCourseManager")
    private ICourseManager courseManager;

    @Autowired
    private LoggingAspect loggingAspect;

    @Autowired
    private CoursesProps props;


    @GetMapping("")
    public @ResponseBody PagedModel<Course> CourseList(@RequestParam int pageIndex){
        CoursesViewModel viewModel = courseManager.GetCourseList(pageIndex, props.getPageSize());
        long totalElements = courseManager.CoursesSize();
        long size = props.getPageSize();
        PagedModel.PageMetadata pageMetadata =
                new PagedModel.PageMetadata(size, pageIndex, totalElements,
                        totalElements / size);
        PagedModel<Course> pagedModel = PagedModel.wrap(viewModel.getCourses(), pageMetadata);
        for(Course course : viewModel.getCourses()){
            int id = course.getId();
            Link selfLink = linkTo(CourseController.class).slash(id).withSelfRel();
            course.add(selfLink);
        }

        return pagedModel;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> GetCourse(@PathVariable Integer id){
        Course course = courseManager.GetCourse(id);
        if(course == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(course);
    }

    @PostMapping("/create")
    public @ResponseBody Course CreateCourse(@RequestBody Course course, HttpServletResponse response){
        //logger.debug("Requested object: " + course.toString());
        logger.debug(loggingAspect.toString());
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
