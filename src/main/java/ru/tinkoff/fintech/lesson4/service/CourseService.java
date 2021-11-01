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

    public void save(Course course) {
        repository.save(course);
    }

    public Course findCourse(long courseId) {
        return repository.findById(courseId).orElseThrow();
    }

    public List<Course> findAll() {
        return repository.findAll();
    }

    public void deleteById(long courseId) {
        repository.deleteById(courseId);
    }

}
