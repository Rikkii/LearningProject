package ru.tinkoff.fintech.lesson4.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.fintech.lesson4.model.Course;
import ru.tinkoff.fintech.lesson4.model.Student;
import ru.tinkoff.fintech.lesson4.service.CourseService;
import ru.tinkoff.fintech.lesson4.service.StudentService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@RestController
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(
            path = "/getCourse",
            produces = APPLICATION_JSON_VALUE
    )
    public Course getCourse (@RequestParam("course_id") long course_id) {

        List<Course> courses = courseService.findAll();
        for (var course: courses) {
            if (course.getCourse_id()==course_id) {
                return course;
            }

        }
        return null;
    }

    @PostMapping(path="/postCourse",
            consumes = APPLICATION_JSON_VALUE
    )
    public void addCourse (@RequestBody Course course) {
        courseService.save1(course);
    }

    @DeleteMapping(path="/deleteCourse")
    public void removeCourse(@RequestParam("course_id") long course_id) {
        courseService.deleteById(course_id);
    }
}
