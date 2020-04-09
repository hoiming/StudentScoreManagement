package com.haiming.services;

import com.haiming.dao.Student;
import com.haiming.interfaces.IStudentManager;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Scope("singleton")
public class MockStudentManager implements IStudentManager {
    private List<Student> studentList = new ArrayList<Student>();
    public MockStudentManager(){
        Student student = new Student();
        student.setId(10);
        student.setName("张三");
        student.setGender("M");
        student.setAddress("番禺区石碁镇");
        student.setTelephone("123123123");
        student.setBirthday(new Date());
        studentList.add(student);
    }
    @Override
    public int CreateStudent(Student student) {
        studentList.add(student);
        return 1;
    }

    @Override
    public int DeleteStudent(int id) {
        Optional<Student> student = studentList.stream().filter(c -> c.getId() == id).findFirst();
        if(student.isPresent()){
            studentList.remove(student);
            return 1;
        }
        return 0;
    }

    @Override
    public int UpdateStudent(Student student) {
        Optional<Student> studentOptional = studentList.stream()
                .filter(c -> c.getId() == student.getId()).findFirst();
        if(studentOptional.isPresent()){
            BeanUtils.copyProperties(student, studentOptional.get());
            return 1;
        }
        return 0;
    }

    @Override
    public Student GetStudent(int id) {
        Optional<Student> studentOptional = studentList.stream()
                .filter(c -> c.getId() == id).findFirst();
        return studentOptional.get();
    }

    @Override
    public List<Student> GetStudentList() {
        return studentList;
    }
}
