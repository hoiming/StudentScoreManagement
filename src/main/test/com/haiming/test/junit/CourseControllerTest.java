package com.haiming.test.junit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haiming.controller.CourseController;
import com.haiming.dao.Course;
import com.haiming.interfaces.ICourseManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class CourseControllerTest {

    @Mock
    ICourseManager courseManager;

    @InjectMocks
    CourseController courseController;


    @Test
    public void testCreateCourseShouldSucceed() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();
        Course course = new Course();
        course.setId(1);
        course.setCoursename("ABC");
        course.setTeachername("AAAA");
        ObjectMapper mapper = new ObjectMapper();
        when(courseManager.CreateCourse(any(Course.class))).thenReturn(course);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/courses/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(course));
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)));
    }

    @Test
    public void testUpdateCourseSucceed() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();
        Course course = new Course();
        course.setId(1);
        course.setCoursename("ABC");
        course.setTeachername("AAAA");
        ObjectMapper mapper = new ObjectMapper();
        when(courseManager.UpdateCourse(any(Course.class))).thenReturn(1);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/courses/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(course));
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)));
    }
}
