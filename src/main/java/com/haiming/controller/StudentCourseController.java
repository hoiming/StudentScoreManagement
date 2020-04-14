package com.haiming.controller;

import com.haiming.dao.StudentCourseScoreFull;
import com.haiming.interfaces.IScoreManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/scores")
@RestController
public class StudentCourseController {

    @Autowired
    @Qualifier("ConcreteScoreManager")
    private IScoreManager scoreManager;

    @GetMapping("/{score_id}")
    public StudentCourseScoreFull GetScoreRecord(@PathVariable Integer score_id){
        StudentCourseScoreFull fullScore = scoreManager.GetScoreById(score_id);
        return fullScore;
    }

    @GetMapping("/student/{student_id}")
    public List<StudentCourseScoreFull> GetScoreRecordListByStudentId(@PathVariable Integer student_id){
        List<StudentCourseScoreFull> list = scoreManager.GetScoresByStudentId(student_id);
        return list;
    }

    @GetMapping("/course/{course_id}")
    public List<StudentCourseScoreFull> GetScoreRecordListByCourseId(@PathVariable Integer course_id){
        List<StudentCourseScoreFull> list = scoreManager.GetScoresByCourseId(course_id);
        return list;
    }



}
