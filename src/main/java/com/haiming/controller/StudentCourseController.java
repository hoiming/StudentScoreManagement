package com.haiming.controller;

import com.haiming.dao.StudentCourseScoreFull;
import com.haiming.interfaces.IScoreManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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


}
