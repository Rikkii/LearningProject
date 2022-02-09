package ru.tinkoff.fintech.lesson4.controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.fintech.lesson4.model.Course;
import ru.tinkoff.fintech.lesson4.service.CourseService;

import javax.annotation.security.RolesAllowed;

@RestController("/learning-project/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @RolesAllowed("ADMIN")
    @GetMapping(path = "/{courseId}")
    public Course getCourse (@PathVariable long courseId) {
        return courseService.findCourse(courseId);
    }
    @RolesAllowed("ADMIN")
    @PostMapping()
    public void addCourse (@RequestBody Course course) {
        courseService.save(course);
    }
    @RolesAllowed("ADMIN")
    @DeleteMapping(path = "/{courseId}")
    public void removeCourse(@PathVariable long courseId) {
        courseService.deleteById(courseId);
    }
}
