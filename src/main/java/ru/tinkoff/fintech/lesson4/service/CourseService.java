package ru.tinkoff.fintech.lesson4.service;
import org.springframework.stereotype.Service;
import ru.tinkoff.fintech.lesson4.dao.CourseRepository;
import ru.tinkoff.fintech.lesson4.model.Course;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public void save1(Course course) {
        repository.save1(course);
    }

    public Course findCourse(long course_id) {
        return repository.findById(course_id).orElseThrow();
    }

    public List<Course> findAll() {
        return repository.findAll();
    }

}
