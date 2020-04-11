package com.haiming.controller;

import com.haiming.dao.Student;
import com.haiming.interfaces.IStudentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    @Qualifier("ConcreteStudentManager")
    private IStudentManager studentManager;

    @GetMapping("/students")
    public List<Student> list(){
        return studentManager.GetStudentList();
    }

    @PostMapping("/students/create")
    public Student CreateStudent(@RequestBody Student student){
        return studentManager.CreateStudent(student);
    }
}
