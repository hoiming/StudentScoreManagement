package com.haiming.controller;

import com.haiming.interfaces.IScoreManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentCourseController {

    @Autowired
    //@Qualifier("asdf")
    private IScoreManager scoreManager;


}
