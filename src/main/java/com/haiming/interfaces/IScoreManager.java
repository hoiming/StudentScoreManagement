package com.haiming.interfaces;

import com.haiming.dao.Course;
import com.haiming.dao.Student;
import com.haiming.dao.StudentCourseScore;
import com.haiming.dao.StudentCourseScoreFull;

import java.util.List;

public interface IScoreManager {

    StudentCourseScore CreateScore(Student student, Course course, int score);

    StudentCourseScore UpdateScore(int score_id, Student student, Course course, int score);

    StudentCourseScoreFull GetScoreById(int score_id);

    List<StudentCourseScoreFull> GetScoresByStudentId(int student_id);

    List<StudentCourseScoreFull> GetScoresByCourseId(int course_id);
}
