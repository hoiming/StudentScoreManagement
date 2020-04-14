package com.haiming.test.junit;

import com.haiming.controller.StudentCourseController;
import com.haiming.dao.*;
import com.haiming.services.concrete.ScoreManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.GreaterThan;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matcher.*;

@ExtendWith(MockitoExtension.class)
public class ScoreControllerTest {

    @InjectMocks
    StudentCourseController scoreController;

    @Mock
    ScoreManager scoreManager;

    @Test
    public void testGetScoreById(){
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(mockHttpServletRequest));
        StudentCourseScoreFull score = new StudentCourseScoreFull();
        score.setId(1);
        when(scoreManager.GetScoreById(1)).thenReturn(score);
        StudentCourseScoreFull full = scoreController.GetScoreRecord(1);
        assertThat(full.getId().equals(1));
    }

    @Test
    public void testGetScoreListByStudentId(){
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(mockHttpServletRequest));
        List<StudentCourseScoreFull> fullScoreList = new ArrayList<StudentCourseScoreFull>();
        StudentCourseScoreFull score = new StudentCourseScoreFull();
        score.setId(1);
        fullScoreList.add(score);
        when(scoreManager.GetScoresByStudentId(1)).thenReturn(fullScoreList);
        List<StudentCourseScoreFull> getFullScoreList = scoreController.GetScoreRecordListByStudentId(1);
        assertThat(getFullScoreList.size() == 1);
        assertThat(getFullScoreList.get(0).getId().equals(1));

    }

    // 从请求URL和返回值的层面单元测试controller
    @Test
    public void testGetStudentCourseScoreFullListByStudentId() throws Exception {
        //MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        //RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(mockHttpServletRequest));
        List<StudentCourseScoreFull> fullScoreList = new ArrayList<StudentCourseScoreFull>();
        StudentCourseScoreFull score = new StudentCourseScoreFull();
        score.setId(1);
        fullScoreList.add(score);
        when(scoreManager.GetScoresByStudentId(1)).thenReturn(fullScoreList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/scores/student/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(scoreController).build();
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()", is(1)));

    }

    @Test
    public void testInputScore() throws Exception {
        StudentCourseScore score = new StudentCourseScore();
        score.setStudentId(1);
        score.setCourseId(1);
        score.setScore(88);
        Student student = new Student();
        student.setId(1);
        Course course = new Course();
        course.setId(1);
        when(scoreManager.CreateScore(any(Student.class), any(Course.class), any(Integer.class))).thenReturn(score);
        RequestBuilder requestBuilder =  MockMvcRequestBuilders.post("/scores/input")
                                            .content("{\"studentId\" : 1, \"courseId\": 1, \"score\":88}")
                                            .contentType(MediaType.APPLICATION_JSON);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(scoreController).build();

        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.score", is(88)));

    }

    @Test
    public void testUpdateScore() throws Exception {
        StudentCourseScore score = new StudentCourseScore();
        score.setStudentId(1);
        score.setCourseId(1);
        score.setScore(88);
        Student student = new Student();
        student.setId(1);
        Course course = new Course();
        course.setId(1);
        when(scoreManager.UpdateScore(any(Integer.class),any(Student.class), any(Course.class), any(Integer.class)))
                .thenReturn(score);
        RequestBuilder requestBuilder =  MockMvcRequestBuilders.post("/scores/update")
                .content("{\"id\" : 1,\"studentId\" : 1, \"courseId\": 1, \"score\":88}")
                .contentType(MediaType.APPLICATION_JSON);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(scoreController).build();

        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.score", is(88)));

    }
}
