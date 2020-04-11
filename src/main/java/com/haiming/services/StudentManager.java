package com.haiming.services;

import com.haiming.dao.Student;
import com.haiming.dao.StudentDynamicSqlSupport;
import com.haiming.dao.StudentMapper;
import com.haiming.interfaces.IStudentManager;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ConcreteStudentManager")
public class StudentManager implements IStudentManager {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student CreateStudent(Student student)
    {
        StudentDynamicSqlSupport.Student studentTable = new StudentDynamicSqlSupport.Student();
        InsertStatementProvider<Student> insertStatementProvider = SqlBuilder.insert(student).into(studentTable)
                .map(studentTable.id).toProperty("id")
                .map(studentTable.name).toProperty("name")
                .map(studentTable.gender).toProperty("gender")
                .map(studentTable.birthday).toProperty("birthday")
                .map(studentTable.telephone).toProperty("telephone")
                .map(studentTable.address).toProperty("address")
                .build()
                .render(RenderingStrategies.MYBATIS3);
        int rows = studentMapper.insert(insertStatementProvider);
        return student;
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
