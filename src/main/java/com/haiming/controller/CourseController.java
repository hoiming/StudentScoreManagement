package com.haiming.controller;

import com.haiming.aspect.LoggingAspect;
import com.haiming.beans.CoursesProps;
import com.haiming.dao.Course;
import com.haiming.interfaces.ICourseManager;
import com.haiming.services.concrete.CourseMessagingService;
import com.haiming.viewmodels.CoursesViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    @Autowired
    private CourseMessagingService courseMessagingService;


    @GetMapping("")
    public @ResponseBody PagedModel<Course> CourseList(@RequestParam int pageIndex){
        CoursesViewModel viewModel = courseManager.GetCourseList(pageIndex, props.getPageSize());
        long totalElements = courseManager.CoursesSize();
        long size = props.getPageSize();
        PagedModel.PageMetadata pageMetadata =
                new PagedModel.PageMetadata(size, pageIndex, totalElements,
                        totalElements / size);
        PagedModel<Course> pagedModel = PagedModel.wrap(viewModel.getCourses(), pageMetadata);
        Link courseListLink = linkTo(CourseController.class).withRel("course_list");
        pagedModel.add(courseListLink);
        List<Link> linkList = viewModel.getCourses().stream().map(
                course -> linkTo(methodOn(CourseController.class)
                            .GetCourse(course.getId()))
                                .withRel("details")).collect(Collectors.toList());

        pagedModel.add(linkList);

        return pagedModel;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> GetCourse(@PathVariable Integer id){
        Course course = courseManager.GetCourse(id);
        if(course == null){
            return ResponseEntity.notFound().build();
        }
        courseMessagingService.sendCourse(course);
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
