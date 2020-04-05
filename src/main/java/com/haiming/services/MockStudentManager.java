package com.haiming.services;

import com.haiming.dao.Student;
import com.haiming.interfaces.IStudentManager;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MockStudentManager implements IStudentManager {
    private List<Student> studentList = new ArrayList<Student>();
    public MockStudentManager(){

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
}
