package com.haiming.controller;

import com.haiming.dao.Student;
import com.haiming.interfaces.IStudentManager;
import org.apache.ibatis.javassist.NotFoundException;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
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
    public @ResponseBody Student CreateStudent( @RequestBody @Valid Student student, HttpServletResponse response){
        response.setStatus(201);
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

    @PostMapping("/students/update/{id}")
    public @ResponseBody void UpdateStudent(@Valid @RequestBody Student student, @PathVariable Integer id, HttpServletResponse response){
        Student fromDB = studentManager.GetStudent(id);
        if(student == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return ;
        }
        BeanUtils.copyProperties(student, fromDB);
        studentManager.UpdateStudent(fromDB);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
