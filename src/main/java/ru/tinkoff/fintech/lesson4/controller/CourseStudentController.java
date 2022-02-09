package ru.tinkoff.fintech.lesson4.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.fintech.lesson4.model.Course;
import ru.tinkoff.fintech.lesson4.model.Student;
import ru.tinkoff.fintech.lesson4.service.CourseService;
import ru.tinkoff.fintech.lesson4.service.CourseStudentService;
import ru.tinkoff.fintech.lesson4.service.StudentService;

@RestController
public class CourseStudentController {
    private final CourseStudentService service;
    private final StudentService studentService;
    private final CourseService courseService;


    public CourseStudentController(CourseStudentService service, StudentService studentService, CourseService courseService) {
        this.service = service;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @PostMapping(path="/postStudentToCourse")
    public void addStudentsToCourse (@RequestParam("id") long id, @RequestParam("courseId") long courseId) {

        Student studentCertainId=studentService.findStudent(id);
        Course courseCertainId = courseService.findCourse(courseId);

        if (studentCertainId.getGrade() >= courseCertainId.getRequiredGrade()) {
            service.addRow(id, courseId);
        }
    }
}
