package com.haiming.dao;

import static com.haiming.dao.ScoreDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface ScoreMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6745111+08:00", comments="Source Table: score")
    BasicColumn[] selectList = BasicColumn.columnList(id, courseId, studentId, score.score);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6735117+08:00", comments="Source Table: score")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6735117+08:00", comments="Source Table: score")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6735117+08:00", comments="Source Table: score")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Score> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6735117+08:00", comments="Source Table: score")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Score> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6735117+08:00", comments="Source Table: score")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ScoreResult")
    Optional<Score> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6745111+08:00", comments="Source Table: score")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ScoreResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.INTEGER),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER)
    })
    List<Score> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6745111+08:00", comments="Source Table: score")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6745111+08:00", comments="Source Table: score")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, score, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6745111+08:00", comments="Source Table: score")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, score, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6745111+08:00", comments="Source Table: score")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6745111+08:00", comments="Source Table: score")
    default int insert(Score record) {
        return MyBatis3Utils.insert(this::insert, record, score, c ->
            c.map(id).toProperty("id")
            .map(courseId).toProperty("courseId")
            .map(studentId).toProperty("studentId")
            .map(score.score).toProperty("score")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6745111+08:00", comments="Source Table: score")
    default int insertMultiple(Collection<Score> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, score, c ->
            c.map(id).toProperty("id")
            .map(courseId).toProperty("courseId")
            .map(studentId).toProperty("studentId")
            .map(score.score).toProperty("score")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6745111+08:00", comments="Source Table: score")
    default int insertSelective(Score record) {
        return MyBatis3Utils.insert(this::insert, record, score, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(courseId).toPropertyWhenPresent("courseId", record::getCourseId)
            .map(studentId).toPropertyWhenPresent("studentId", record::getStudentId)
            .map(score.score).toPropertyWhenPresent("score", record::getScore)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6745111+08:00", comments="Source Table: score")
    default Optional<Score> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, score, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6745111+08:00", comments="Source Table: score")
    default List<Score> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, score, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6745111+08:00", comments="Source Table: score")
    default List<Score> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, score, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6745111+08:00", comments="Source Table: score")
    default Optional<Score> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6745111+08:00", comments="Source Table: score")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, score, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6745111+08:00", comments="Source Table: score")
    static UpdateDSL<UpdateModel> updateAllColumns(Score record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(courseId).equalTo(record::getCourseId)
                .set(studentId).equalTo(record::getStudentId)
                .set(score.score).equalTo(record::getScore);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6745111+08:00", comments="Source Table: score")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Score record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(courseId).equalToWhenPresent(record::getCourseId)
                .set(studentId).equalToWhenPresent(record::getStudentId)
                .set(score.score).equalToWhenPresent(record::getScore);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6755105+08:00", comments="Source Table: score")
    default int updateByPrimaryKey(Score record) {
        return update(c ->
            c.set(courseId).equalTo(record::getCourseId)
            .set(studentId).equalTo(record::getStudentId)
            .set(score.score).equalTo(record::getScore)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-04T23:54:49.6755105+08:00", comments="Source Table: score")
    default int updateByPrimaryKeySelective(Score record) {
        return update(c ->
            c.set(courseId).equalToWhenPresent(record::getCourseId)
            .set(studentId).equalToWhenPresent(record::getStudentId)
            .set(score.score).equalToWhenPresent(record::getScore)
            .where(id, isEqualTo(record::getId))
        );
    }
}