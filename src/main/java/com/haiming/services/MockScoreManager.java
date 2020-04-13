package com.haiming.services;

import com.haiming.dao.Course;
import com.haiming.dao.Student;
import com.haiming.dao.StudentCourseScore;
import com.haiming.dao.StudentCourseScoreMapper;
import com.haiming.interfaces.IScoreManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("MockScoreManager")
public class MockScoreManager implements IScoreManager {

    private StudentCourseScore score;

    public MockScoreManager(){
        score = new StudentCourseScore();
        score.setCourseId(1);
        score.setStudentId(1);
        score.setScore(100);
        score.setId(1);
    }

    @Override
    public StudentCourseScore CreateScore(Student student, Course course, int score) {
        this.score = new StudentCourseScore();
        this.score.setId(1);
        this.score.setScore(score);
        this.score.setCourseId(course.getId());
        this.score.setStudentId(student.getId());
        return this.score;
    }

    @Override
    public StudentCourseScore UpdateScore(int score_id, Student student, Course course, int score) {
        if(this.score.getId() == score_id){
            this.score.setStudentId(student.getId());
            this.score.setCourseId(course.getId());
            this.score.setScore(score);
            return this.score;
        }
        return null;
    }
}
