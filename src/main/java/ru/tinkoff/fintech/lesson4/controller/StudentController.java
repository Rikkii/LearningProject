package ru.tinkoff.fintech.lesson4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.fintech.lesson4.dao.StudentRepository;
import ru.tinkoff.fintech.lesson4.model.Student;
import ru.tinkoff.fintech.lesson4.service.StudentService;

import java.util.HashMap;
import java.util.Map;


@RestController
public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }



    @GetMapping(
            path = "/getstudent/"
    )

    public Student getStudent (@RequestParam("id") long id){

        //StudentService studentService = new StudentService(repository);
        return repository.findById(id).orElseThrow();

    }

//        @PostMapping("/addStudent")
//        public void addStudent (@RequestBody Long id, Student student){
//        students.put(id, student);
//    }



}
