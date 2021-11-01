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
    void save1(Course course);

    List<Course> findAll();
    @Delete("DELETE FROM courses WHERE course_id = #{course_id}")
    int deleteById(long course_id);

    @Select("SELECT course_id, name2, description FROM courses")
    @Results(value = {
            @Result(column = "course_id", property = "course_id"),
            @Result(column = "name2", property = "name2"),
            @Result(property = "description", column = "description")
    })

    Optional<Course> findById(long  course_id);
}
