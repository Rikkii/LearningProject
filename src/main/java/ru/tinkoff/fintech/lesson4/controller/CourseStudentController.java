package ru.tinkoff.fintech.lesson4.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tinkoff.fintech.lesson4.model.Course;
import ru.tinkoff.fintech.lesson4.service.CourseStudentService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class CourseStudentController {
    private final CourseStudentService service;

    public CourseStudentController(CourseStudentService service) {
        this.service = service;
    }

    @PostMapping(path="/postStudentsToCourse",
            consumes = APPLICATION_JSON_VALUE
    )
    public void addStudentsToCourse (@RequestParam("id") long id, @RequestParam("course_id") long course_id) {
        service.addRow(id, course_id);

    }
}
