package ru.tinkoff.fintech.lesson4.service;
import org.springframework.stereotype.Service;
import ru.tinkoff.fintech.lesson4.dao.CourseStudentRepository;

@Service
public class CourseStudentService {
    private final CourseStudentRepository repository;

    public CourseStudentService(CourseStudentRepository repository) {
        this.repository = repository;
    }

    public void addRow(long id, long courseId) {
        repository.addRow(id, courseId);
    }
}
