package ru.tinkoff.fintech.lesson4.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.tinkoff.fintech.lesson4.model.Student;

@Mapper
public interface StudentRepository {

    void save(Student student);

    List<Student> findAll();

    @Select("SELECT id, name, age FROM students")
    @Results(value = {
        @Result(column = "id", property = "id"),
        @Result(column = "name", property = "name"),
        @Result(property = "age", column = "age"),
        @Result(property = "timeStart", column = "timeStart"),
            @Result(property = "timeEnd", column = "timeEnd"),
            @Result(property = "course", column = "course")


    })
    Optional<Student> findById(long id);
}
