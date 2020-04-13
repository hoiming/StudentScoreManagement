package com.haiming.interfaces;

import com.haiming.dao.Course;
import com.haiming.dao.Student;
import com.haiming.dao.StudentCourseScore;

public interface IScoreManager {

    StudentCourseScore CreateScore(Student student, Course course, int score);

    StudentCourseScore UpdateScore(int score_id, Student student, Course course, int score);


}
