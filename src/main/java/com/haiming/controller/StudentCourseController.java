package com.haiming.controller;

import com.haiming.dao.Course;
import com.haiming.dao.Student;
import com.haiming.dao.StudentCourseScore;
import com.haiming.dao.StudentCourseScoreFull;
import com.haiming.interfaces.IScoreManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/scores")
@RestController
public class StudentCourseController {

    private Logger logger = LoggerFactory.getLogger(StudentCourseController.class);

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

    @PostMapping("/input")
    public StudentCourseScore InputScore(@RequestBody StudentCourseScore score, HttpServletResponse response){
        Student student = new Student();
        student.setId(score.getStudentId());
        Course course = new Course();
        course.setId(score.getCourseId());
        logger.debug("Requested object: " + score);
        StudentCourseScore createdScore = scoreManager.CreateScore(student, course, score.getScore());
        if(createdScore == null){
            response.setStatus(400);
        }else
        response.setStatus(201);
        return createdScore;
    }

    @PostMapping("/update/{id}")
    public StudentCourseScore UpdateScore(@PathVariable Integer id, @RequestBody StudentCourseScore score, HttpServletResponse response){
        if(score.getId() == null)
            return null;
        Student student = new Student();
        student.setId(score.getStudentId());
        Course course = new Course();
        course.setId(score.getCourseId());
        StudentCourseScore updatedScore = scoreManager.UpdateScore(id, student, course, score.getScore());
        if(updatedScore == null){
            response.setStatus(400);
        }else
            response.setStatus(200);
        return updatedScore;
    }

}
