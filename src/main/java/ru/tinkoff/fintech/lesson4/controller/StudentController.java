package ru.tinkoff.fintech.lesson4.controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.fintech.lesson4.model.Student;
import ru.tinkoff.fintech.lesson4.service.StudentService;

import javax.annotation.security.RolesAllowed;

@RestController()
@RequestMapping("/learning-project/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RolesAllowed("USER")
    @GetMapping (path = "/{id}")
    public Student getStudent (@PathVariable long id) {
        return studentService.findStudent(id);
        }

    @RolesAllowed("ADMIN")
    @PostMapping ()
    public void addStudent (@RequestBody Student student) {
        studentService.save(student);
    }

    @RolesAllowed("ADMIN")
    @DeleteMapping(path = "/{id}")
    public void removeStudent(@PathVariable long id) {
        studentService.deleteById(id);
    }

    @RolesAllowed("ADMIN")
    @PutMapping(path = "/{id}")
    public void updateStudent (@RequestBody Student student, @PathVariable long id) {
        studentService.updateById(student, id);
    }

}
