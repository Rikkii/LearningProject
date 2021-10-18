package ru.tinkoff.fintech.lesson4.dao;

import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.*;
import ru.tinkoff.fintech.lesson4.model.Student;

@Mapper
public interface StudentRepository {

    void save1(Student student);

    List<Student> findAll();

    @Select("SELECT id, name1, age FROM students")
    @Results(value = {
        @Result(column = "id", property = "id"),
        @Result(column = "name1", property = "name1"),
        @Result(property = "age", column = "age"),
        @Result(property = "timeStart", column = "timeStart"),
            @Result(property = "timeEnd", column = "timeEnd"),
            @Result(property = "course", column = "course")


    })
    Optional<Student> findById(long id);

    @Delete("DELETE FROM students WHERE id = #{id}")
    int deleteById(long id);
    @Insert("INSERT INTO students(id, name1, age, timeStart, timeEnd, course) " +
            " VALUES (#{id}, #{name1}, #{age}, #{timeStart} #{timeEnd} #{course})")
    int insert(Student student);
    @Update("Update students set name1=#{name1}, " +
            " age=#{age}, timeStart=#{timeStart}, timeEnd=#{timeEnd}, course=#{course} where id=#{id}")
    int update(Student student);


}
