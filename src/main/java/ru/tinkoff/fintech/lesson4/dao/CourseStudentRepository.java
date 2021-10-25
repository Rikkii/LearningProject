package ru.tinkoff.fintech.lesson4.dao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseStudentRepository {
    int addRow(long id, long course_id);
    int courseForOld();
}
