package ru.tinkoff.fintech.lesson4.service;
import java.util.List;
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
        return repository.findById(id);
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public void updateById(Student student, long id) { repository.update(student, id); }
}
