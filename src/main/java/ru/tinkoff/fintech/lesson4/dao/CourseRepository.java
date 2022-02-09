package ru.tinkoff.fintech.lesson4.dao;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.tinkoff.fintech.lesson4.model.Course;
import java.util.List;
import java.util.Optional;

@Mapper
public interface CourseRepository {
    void save(Course course);

    List<Course> findAll();
    @Delete("DELETE FROM courses WHERE courseId = #{courseId}")
    int deleteById(long courseId);

    @Select("SELECT courseId, name, description, requiredGrade FROM courses where courseId = #{courseId} ")

    Course findById(long courseId);
}
