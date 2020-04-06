package com.haiming.interfaces;

import com.haiming.dao.Course;
import com.haiming.dao.Student;

public interface IScoreManager {

    int CreateScore(Student student, Course course, int score);

    int UpdateScore(Student student, Course course, int score);


}
