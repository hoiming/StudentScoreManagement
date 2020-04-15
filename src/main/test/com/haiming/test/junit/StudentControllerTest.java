package com.haiming.test.junit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haiming.config.AppConfig;
import com.haiming.controller.StudentController;
import com.haiming.dao.Course;
import com.haiming.dao.Student;
import com.haiming.interfaces.IStudentManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @InjectMocks
    StudentController studentController;

    @Mock
    IStudentManager studentManager;

    @Test
    public void testAddStudent(){
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(mockHttpServletRequest));
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        when(studentManager.CreateStudent(any(Student.class))).thenReturn(student);
        Student responseStudent = studentController.CreateStudent(student, mockHttpServletResponse);
        assertThat(responseStudent.getName().equals("张三"));
    }

    @Test
    public void testAddCorrectStudentInURL() throws Exception {
        Student student = new Student();
        student.setId(1);
        when(studentManager.CreateStudent(any(Student.class))).thenReturn(student);
        RequestBuilder requestBuilder =  MockMvcRequestBuilders.post("/students/create")
                .content("{\"name\": \"来自POSTMAN\",\n" +
                        "\t\"gender\": \"M\",\n" +
                        "\t\"birthday\": \"1990-06-24\",\n" +
                        "\t\"telephone\": \"16575154567\",\n" +
                        "\t\"address\": \"南沙区东涌墟1号\"}")
                .contentType(MediaType.APPLICATION_JSON);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();

        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)));
    }

    @Test
    public void testAddMalformedStudentInURL() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Student student = new Student();
        student.setId(1);
        student.setBirthday(simpleDateFormat.parse("1990-06-24"));
        student.setTelephone("16575154567");
        student.setAddress("南沙区东涌墟1号");
        student.setGender("A");
        when(studentManager.CreateStudent(any(Student.class))).thenReturn(student);
        ObjectMapper mapper = new ObjectMapper();

        RequestBuilder requestBuilder =  MockMvcRequestBuilders.post("/students/create")
                .content(mapper.writeValueAsString(student))
                .contentType(MediaType.APPLICATION_JSON);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();

        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)));
    }

    @Test
    public void testUpdateStudentWithCorrectBody() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Student student = new Student();
        student.setId(1);
        student.setBirthday(simpleDateFormat.parse("1990-06-24"));
        student.setTelephone("16575154567");
        student.setAddress("南沙区东涌墟1号");
        student.setGender("M");
        when(studentManager.UpdateStudent(any(Student.class))).thenReturn(1);
        when(studentManager.GetStudent(1)).thenReturn(student);
        ObjectMapper mapper = new ObjectMapper();

        RequestBuilder requestBuilder =  MockMvcRequestBuilders.post("/students/update/1")
                .content(mapper.writeValueAsString(student))
                .contentType(MediaType.APPLICATION_JSON);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();

        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
