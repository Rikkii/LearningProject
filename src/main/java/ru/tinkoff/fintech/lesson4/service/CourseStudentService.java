package ru.tinkoff.fintech.lesson4.service;

import org.springframework.stereotype.Service;
import ru.tinkoff.fintech.lesson4.dao.CourseStudentRepository;
import ru.tinkoff.fintech.lesson4.model.Student;

@Service
public class CourseStudentService {
    private final CourseStudentRepository repository;


    public CourseStudentService(CourseStudentRepository repository) {
        this.repository = repository;
    }
    public void addStudent(long id, long course_id) {
        repository.addStudent(id, course_id);
    }




}
