package ru.tinkoff.fintech.lesson4.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import ru.tinkoff.fintech.lesson4.dao.StudentRepository;
import ru.tinkoff.fintech.lesson4.model.Student;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public void save(Student student) {
        repository.save(student);
    }

    public Student findStudent(long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Student> findAll() {
        return repository.findAll();
    }
}