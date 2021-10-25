package ru.tinkoff.fintech.lesson4.dao;

import org.apache.ibatis.annotations.Mapper;
import ru.tinkoff.fintech.lesson4.model.Course;
import ru.tinkoff.fintech.lesson4.model.Student;

import java.util.List;
@Mapper
public interface CourseStudentRepository {
    int addStudent(long id, long course_id);
    int courseForOld();

}
