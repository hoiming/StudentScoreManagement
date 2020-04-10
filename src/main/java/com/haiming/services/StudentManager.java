package com.haiming.services;

import com.haiming.dao.Student;
import com.haiming.dao.StudentMapper;
import com.haiming.interfaces.IStudentManager;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ConcreteStudentManager")
public class StudentManager implements IStudentManager {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int CreateStudent(Student student) {
        return 0;
    }

    @Override
    public int DeleteStudent(int id) {
        return 0;
    }

    @Override
    public int UpdateStudent(Student student) {
        return 0;
    }

    @Override
    public Student GetStudent(int id) {
        return null;
    }

    @Override
    public List<Student> GetStudentList() {

        List<Student> studentList = studentMapper.selectMany(new SelectStatementProvider() {
            @Override
            public Map<String, Object> getParameters() {
                return null;
            }

            @Override
            public String getSelectStatement() {
                return "Select * from student";
            }
        });
        return studentList;
    }
}
