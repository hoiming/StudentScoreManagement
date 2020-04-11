package com.haiming.controller;

import com.haiming.dao.Student;
import com.haiming.interfaces.IStudentManager;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    @Qualifier("ConcreteStudentManager")
    private IStudentManager studentManager;

    @GetMapping("/students")
    public @ResponseBody List<Student> list(){
        return studentManager.GetStudentList();
    }

    @PostMapping("/students/create")
    public @ResponseBody Student CreateStudent(@RequestBody Student student){
        return studentManager.CreateStudent(student);
    }

    @GetMapping("/students/{id}")
    public @ResponseBody Student GetStudent(@PathVariable("id") Integer id, HttpServletResponse response) throws NotFoundException {
        Student student = studentManager.GetStudent(id);
        if(student == null){
             response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return student;
    }

    @PostMapping("/students/update")
    public @ResponseBody void UpdateStudent(@RequestBody Student student, HttpServletResponse response){
        Student fromDB = studentManager.GetStudent(student.getId());
        if(student == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return ;
        }
        BeanUtils.copyProperties(student, fromDB);
        studentManager.UpdateStudent(fromDB);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
