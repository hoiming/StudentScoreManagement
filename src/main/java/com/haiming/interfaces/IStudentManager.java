package com.haiming.interfaces;

import com.haiming.dao.Student;

import java.util.List;

public interface IStudentManager {

    int CreateStudent(Student student);

    int DeleteStudent(int id);

    int UpdateStudent(Student student);

    Student GetStudent(int id);

    List<Student> GetStudentList();
}
