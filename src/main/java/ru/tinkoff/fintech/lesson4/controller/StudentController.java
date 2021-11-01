package ru.tinkoff.fintech.lesson4.controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.fintech.lesson4.model.Student;
import ru.tinkoff.fintech.lesson4.service.StudentService;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController()
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping (
            path = "/getStudent",
            produces = APPLICATION_JSON_VALUE
    )
    public Student getStudent (@RequestParam("id") long id) {

        List <Student> students = studentService.findAll();
        for (var student: students) {
            if (student.getId()==id) {
                return student;
            }
        }
        return null;

//        return studentService.findStudent(id);
//        Такой вариант дает ошибку: Expected one result (or null) to be returned by selectOne(), but found: 2
    }

    @PostMapping (
            path="postStudent",
            consumes = APPLICATION_JSON_VALUE
    )
    public void addStudent (@RequestBody Student student) {
        studentService.save(student);
    }

    @DeleteMapping(path="/deleteStudent")
    public void removeStudent(@RequestParam("id") long id) {
        studentService.deleteById(id);
    }

    @PutMapping(path="/putStudent")
    public void updateStudent (@RequestParam long id, @RequestParam String name, @RequestParam int age) {
        studentService.updateById(id, name, age);
    }
    //не вышло сделать апдейт по-хорошему через
    //public void updateStudent(@RequestParam("id") long id, @RequestBody Student student) {}
    //выдавало ошибку: parameter "name" not found. available parameters are {student, id, param1, param2}

}
