package com.haiming.services.concrete;

import com.haiming.dao.*;
import com.haiming.interfaces.IScoreManager;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.where.condition.IsEqualTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.haiming.dao.StudentCourseScoreDynamicSqlSupport.score;
import static com.haiming.dao.StudentCourseScoreDynamicSqlSupport.studentCourseScore;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import java.util.List;
import java.util.Optional;

@Service("ConcreteScoreManager")
public class ScoreManager implements IScoreManager {

    @Autowired
    private StudentCourseScoreMapper mapper;

    @Override
    public StudentCourseScore CreateScore(Student student, Course course, int score) {
        long count = mapper.count(s -> s.where(studentCourseScore.studentId, isEqualTo(student.getId()))
                .and(studentCourseScore.courseId, isEqualTo(course.getId())));
        if(count > 0){
            return null;
        }

        StudentCourseScore st_score = new StudentCourseScore();
        st_score.setScore(score);
        st_score.setStudentId(student.getId());
        st_score.setCourseId(course.getId());
        mapper.insert(st_score);
        return st_score;
    }

    @Override
    public StudentCourseScore UpdateScore(int score_id, Student student, Course course, int score) {
        long count = mapper.count(s -> s.where(studentCourseScore.studentId, isEqualTo(student.getId()))
                .and(studentCourseScore.courseId, isEqualTo(course.getId())));
        if(count > 0){
            return null;
        }
        StudentCourseScore st_score = new StudentCourseScore();
        st_score.setId(score_id);
        st_score.setCourseId(course.getId());
        st_score.setStudentId(student.getId());
        mapper.updateByPrimaryKey(st_score);
        return st_score;
    }

    @Override
    public StudentCourseScoreFull GetScoreById(int score_id) {
        SelectStatementProvider selectStatementProvider = SqlBuilder.select(studentCourseScore.id, studentCourseScore.courseId,
                studentCourseScore.studentId, CourseDynamicSqlSupport.coursename, CourseDynamicSqlSupport.teachername,
                studentCourseScore.score, StudentDynamicSqlSupport.name.as("studentName"))
                .from(CourseDynamicSqlSupport.course)
                .join(studentCourseScore).on(CourseDynamicSqlSupport.id, equalTo(studentCourseScore.courseId))
                .join(StudentDynamicSqlSupport.student).on(studentCourseScore.studentId, equalTo(StudentDynamicSqlSupport.id))
                .where(studentCourseScore.id, isEqualTo(score_id))
                .build().render(RenderingStrategies.MYBATIS3);
        Optional<StudentCourseScoreFull> fullScore = mapper.selectOneFullById(selectStatementProvider);
        return fullScore.orElse(null);
    }

    @Override
    public List<StudentCourseScoreFull> GetScoresByStudentId(int student_id) {
        SelectStatementProvider selectStatementProvider = SqlBuilder.select(studentCourseScore.id, studentCourseScore.courseId,
                studentCourseScore.studentId, CourseDynamicSqlSupport.coursename, CourseDynamicSqlSupport.teachername,
                studentCourseScore.score, StudentDynamicSqlSupport.name.as("studentName"))
                .from(CourseDynamicSqlSupport.course)
                .join(studentCourseScore).on(CourseDynamicSqlSupport.id, equalTo(studentCourseScore.courseId))
                .join(StudentDynamicSqlSupport.student).on(studentCourseScore.studentId, equalTo(StudentDynamicSqlSupport.id))
                .where(studentCourseScore.studentId, isEqualTo(student_id))
                .build().render(RenderingStrategies.MYBATIS3);
        List<StudentCourseScoreFull> fullScoreList = mapper.SelectListByStudentId(selectStatementProvider);
        return fullScoreList;
    }

    @Override
    public List<StudentCourseScoreFull> GetScoresByCourseId(int course_id) {
        SelectStatementProvider selectStatementProvider = SqlBuilder.select(studentCourseScore.id, studentCourseScore.courseId,
                studentCourseScore.studentId, CourseDynamicSqlSupport.coursename, CourseDynamicSqlSupport.teachername,
                studentCourseScore.score, StudentDynamicSqlSupport.name.as("studentName"))
                .from(CourseDynamicSqlSupport.course)
                .join(studentCourseScore).on(CourseDynamicSqlSupport.id, equalTo(studentCourseScore.courseId))
                .join(StudentDynamicSqlSupport.student).on(studentCourseScore.studentId, equalTo(StudentDynamicSqlSupport.id))
                .where(studentCourseScore.courseId, isEqualTo(course_id))
                .build().render(RenderingStrategies.MYBATIS3);
        List<StudentCourseScoreFull> fullScoreList = mapper.SelectListByCourseId(selectStatementProvider);
        return fullScoreList;
    }
}
