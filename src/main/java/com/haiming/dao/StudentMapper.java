package com.haiming.dao;

import static com.haiming.dao.StudentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.haiming.dao.Student;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

import org.apache.ibatis.annotations.*;
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
public interface StudentMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1909543+08:00", comments="Source Table: student")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, gender, birthday, telephone, address);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1809596+08:00", comments="Source Table: student")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1819599+08:00", comments="Source Table: student")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.182959+08:00", comments="Source Table: student")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys = true, keyProperty = "record.id")
    int insert(InsertStatementProvider<Student> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.182959+08:00", comments="Source Table: student")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Student> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1839587+08:00", comments="Source Table: student")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("StudentResult")
    Optional<Student> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1839587+08:00", comments="Source Table: student")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="StudentResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.CHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="telephone", property="telephone", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR)
    })
    List<Student> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1859575+08:00", comments="Source Table: student")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1859575+08:00", comments="Source Table: student")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, student, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1869567+08:00", comments="Source Table: student")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, student, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1869567+08:00", comments="Source Table: student")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1869567+08:00", comments="Source Table: student")
    @Options(useGeneratedKeys = true, keyProperty = "record.id")
    default int insert(Student record) {
        return MyBatis3Utils.insert(this::insert, record, student, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(gender).toProperty("gender")
            .map(birthday).toProperty("birthday")
            .map(telephone).toProperty("telephone")
            .map(address).toProperty("address")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1889563+08:00", comments="Source Table: student")
    default int insertMultiple(Collection<Student> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, student, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(gender).toProperty("gender")
            .map(birthday).toProperty("birthday")
            .map(telephone).toProperty("telephone")
            .map(address).toProperty("address")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1889563+08:00", comments="Source Table: student")
    default int insertSelective(Student record) {
        return MyBatis3Utils.insert(this::insert, record, student, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(gender).toPropertyWhenPresent("gender", record::getGender)
            .map(birthday).toPropertyWhenPresent("birthday", record::getBirthday)
            .map(telephone).toPropertyWhenPresent("telephone", record::getTelephone)
            .map(address).toPropertyWhenPresent("address", record::getAddress)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1919536+08:00", comments="Source Table: student")
    default Optional<Student> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, student, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1919536+08:00", comments="Source Table: student")
    default List<Student> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, student, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1929534+08:00", comments="Source Table: student")
    default List<Student> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, student, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1929534+08:00", comments="Source Table: student")
    default Optional<Student> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1939529+08:00", comments="Source Table: student")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, student, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1939529+08:00", comments="Source Table: student")
    static UpdateDSL<UpdateModel> updateAllColumns(Student record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(gender).equalTo(record::getGender)
                .set(birthday).equalTo(record::getBirthday)
                .set(telephone).equalTo(record::getTelephone)
                .set(address).equalTo(record::getAddress);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1949521+08:00", comments="Source Table: student")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Student record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(gender).equalToWhenPresent(record::getGender)
                .set(birthday).equalToWhenPresent(record::getBirthday)
                .set(telephone).equalToWhenPresent(record::getTelephone)
                .set(address).equalToWhenPresent(record::getAddress);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1959517+08:00", comments="Source Table: student")
    default int updateByPrimaryKey(Student record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(gender).equalTo(record::getGender)
            .set(birthday).equalTo(record::getBirthday)
            .set(telephone).equalTo(record::getTelephone)
            .set(address).equalTo(record::getAddress)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-05T17:56:51.1959517+08:00", comments="Source Table: student")
    default int updateByPrimaryKeySelective(Student record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(gender).equalToWhenPresent(record::getGender)
            .set(birthday).equalToWhenPresent(record::getBirthday)
            .set(telephone).equalToWhenPresent(record::getTelephone)
            .set(address).equalToWhenPresent(record::getAddress)
            .where(id, isEqualTo(record::getId))
        );
    }
}