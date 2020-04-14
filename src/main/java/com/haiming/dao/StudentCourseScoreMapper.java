package com.haiming.dao;

import static com.haiming.dao.StudentCourseScoreDynamicSqlSupport.*;
import static com.haiming.dao.StudentDynamicSqlSupport.*;
import static com.haiming.dao.StudentDynamicSqlSupport.id;
import static com.haiming.dao.StudentDynamicSqlSupport.name;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.haiming.dao.StudentCourseScore;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import com.haiming.dao.StudentDynamicSqlSupport;
import com.haiming.dao.CourseDynamicSqlSupport;

@Mapper
public interface StudentCourseScoreMapper {
    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2019481+08:00", comments = "Source Table: student_course_score")
    BasicColumn[] selectList = BasicColumn.columnList(id, courseId, studentId, score);

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2019481+08:00", comments = "Source Table: student_course_score")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2019481+08:00", comments = "Source Table: student_course_score")
    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2019481+08:00", comments = "Source Table: student_course_score")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "record.id")
    int insert(InsertStatementProvider<StudentCourseScore> insertStatement);

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2019481+08:00", comments = "Source Table: student_course_score")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<StudentCourseScore> multipleInsertStatement);

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2019481+08:00", comments = "Source Table: student_course_score")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("StudentCourseScoreResult")
    Optional<StudentCourseScore> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "StudentCourseScoreFullResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "course_id", property = "courseId", jdbcType = JdbcType.INTEGER),
            @Result(column = "student_id", property = "studentId", jdbcType = JdbcType.INTEGER),
            @Result(column = "score", property = "score", jdbcType = JdbcType.INTEGER),
            @Result(column = "coursename", property = "courseName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "teachername", property = "teacherName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "studentName", property = "studentName", jdbcType = JdbcType.VARCHAR)
    })
    Optional<StudentCourseScoreFull> selectOneFullById(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("StudentCourseScoreFullResult")
    List<StudentCourseScoreFull> SelectListByStudentId(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("StudentCourseScoreFullResult")
    List<StudentCourseScoreFull> SelectListByCourseId(SelectStatementProvider selectStatement);

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2019481+08:00", comments = "Source Table: student_course_score")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "StudentCourseScoreResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "course_id", property = "courseId", jdbcType = JdbcType.INTEGER),
            @Result(column = "student_id", property = "studentId", jdbcType = JdbcType.INTEGER),
            @Result(column = "score", property = "score", jdbcType = JdbcType.INTEGER)
    })
    List<StudentCourseScore> selectMany(SelectStatementProvider selectStatement);

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2019481+08:00", comments = "Source Table: student_course_score")
    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2019481+08:00", comments = "Source Table: student_course_score")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, studentCourseScore, completer);
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2019481+08:00", comments = "Source Table: student_course_score")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, studentCourseScore, completer);
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2019481+08:00", comments = "Source Table: student_course_score")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2019481+08:00", comments = "Source Table: student_course_score")
    @Options(useGeneratedKeys = true, keyProperty = "record.id")
    default int insert(StudentCourseScore record) {
        return MyBatis3Utils.insert(this::insert, record, studentCourseScore, c ->
                c.map(id).toProperty("id")
                        .map(courseId).toProperty("courseId")
                        .map(studentId).toProperty("studentId")
                        .map(score).toProperty("score")
        );
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2019481+08:00", comments = "Source Table: student_course_score")
    default int insertMultiple(Collection<StudentCourseScore> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, studentCourseScore, c ->
                c.map(id).toProperty("id")
                        .map(courseId).toProperty("courseId")
                        .map(studentId).toProperty("studentId")
                        .map(score).toProperty("score")
        );
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2019481+08:00", comments = "Source Table: student_course_score")
    default int insertSelective(StudentCourseScore record) {
        return MyBatis3Utils.insert(this::insert, record, studentCourseScore, c ->
                c.map(id).toPropertyWhenPresent("id", record::getId)
                        .map(courseId).toPropertyWhenPresent("courseId", record::getCourseId)
                        .map(studentId).toPropertyWhenPresent("studentId", record::getStudentId)
                        .map(score).toPropertyWhenPresent("score", record::getScore)
        );
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2019481+08:00", comments = "Source Table: student_course_score")
    default Optional<StudentCourseScore> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, studentCourseScore, completer);
    }


    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2029469+08:00", comments = "Source Table: student_course_score")
    default List<StudentCourseScore> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, studentCourseScore, completer);
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2029469+08:00", comments = "Source Table: student_course_score")
    default List<StudentCourseScore> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, studentCourseScore, completer);
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2029469+08:00", comments = "Source Table: student_course_score")
    default Optional<StudentCourseScore> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2029469+08:00", comments = "Source Table: student_course_score")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, studentCourseScore, completer);
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2029469+08:00", comments = "Source Table: student_course_score")
    static UpdateDSL<UpdateModel> updateAllColumns(StudentCourseScore record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(courseId).equalTo(record::getCourseId)
                .set(studentId).equalTo(record::getStudentId)
                .set(score).equalTo(record::getScore);
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2029469+08:00", comments = "Source Table: student_course_score")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(StudentCourseScore record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(courseId).equalToWhenPresent(record::getCourseId)
                .set(studentId).equalToWhenPresent(record::getStudentId)
                .set(score).equalToWhenPresent(record::getScore);
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2029469+08:00", comments = "Source Table: student_course_score")
    default int updateByPrimaryKey(StudentCourseScore record) {
        return update(c ->
                c.set(courseId).equalTo(record::getCourseId)
                        .set(studentId).equalTo(record::getStudentId)
                        .set(score).equalTo(record::getScore)
                        .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2020-04-05T17:56:51.2029469+08:00", comments = "Source Table: student_course_score")
    default int updateByPrimaryKeySelective(StudentCourseScore record) {
        return update(c ->
                c.set(courseId).equalToWhenPresent(record::getCourseId)
                        .set(studentId).equalToWhenPresent(record::getStudentId)
                        .set(score).equalToWhenPresent(record::getScore)
                        .where(id, isEqualTo(record::getId))
        );
    }
}