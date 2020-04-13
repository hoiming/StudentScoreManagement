package com.haiming.test.junit;

import com.haiming.controller.StudentController;
import com.haiming.dao.Student;
import com.haiming.interfaces.IStudentManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @InjectMocks
    StudentController studentController;

    @Mock
    IStudentManager studentManager;

    @Test
    public void testAddStudent(){
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(mockHttpServletRequest));
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        when(studentManager.CreateStudent(any(Student.class))).thenReturn(student);
        Student responseStudent = studentController.CreateStudent(student);
        assertThat(responseStudent.getName().equals("张三"));
    }
}
