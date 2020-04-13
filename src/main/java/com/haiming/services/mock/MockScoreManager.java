package com.haiming.services.mock;

import com.haiming.dao.*;
import com.haiming.interfaces.IScoreManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("MockScoreManager")
public class MockScoreManager implements IScoreManager {

    private StudentCourseScoreFull score;

    public MockScoreManager(){
        score = new StudentCourseScoreFull();
        score.setCourseId(1);
        score.setStudentId(1);
        score.setScore(100);
        score.setId(1);
    }

    @Override
    public StudentCourseScoreFull CreateScore(Student student, Course course, int score) {
        this.score = new StudentCourseScoreFull();
        this.score.setId(1);
        this.score.setScore(score);
        this.score.setCourseId(course.getId());
        this.score.setStudentId(student.getId());
        return this.score;
    }

    @Override
    public StudentCourseScoreFull UpdateScore(int score_id, Student student, Course course, int score) {
        if(this.score.getId() == score_id){
            this.score.setStudentId(student.getId());
            this.score.setCourseId(course.getId());
            this.score.setScore(score);
            return this.score;
        }
        return null;
    }

    @Override
    public StudentCourseScoreFull GetScoreById(int score_id) {
        if(score_id == 1){
            return this.score;
        }
        return null;
    }

    @Override
    public List<StudentCourseScoreFull> GetScoresByStudentId(int student_id) {
        List<StudentCourseScoreFull> list = new ArrayList<StudentCourseScoreFull>();
        list.add(this.score);
        return list;
    }

    @Override
    public List<StudentCourseScoreFull> GetScoresByCourseId(int course_id) {
        List<StudentCourseScoreFull> list = new ArrayList<StudentCourseScoreFull>();
        list.add(this.score);
        return list;
    }
}
