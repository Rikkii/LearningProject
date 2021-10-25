package ru.tinkoff.fintech.lesson4;
import java.util.List;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.tinkoff.fintech.lesson4.model.Course;
import ru.tinkoff.fintech.lesson4.model.Student;
import ru.tinkoff.fintech.lesson4.service.CourseService;
import ru.tinkoff.fintech.lesson4.service.CourseStudentService;
import ru.tinkoff.fintech.lesson4.service.StudentService;

@SpringBootApplication
public class Lesson4Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson4Application.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(StudentService service1, CourseService service2, CourseStudentService service3) {
        return args -> {
            Course johnCourse = new Course(1L, "Java", "very good");
            Student john = new Student(555L, "John", 27, 12, 14);
            service1.save1(john);
            service2.save1(johnCourse);
            service3.addRow(555L, 1L);

            Student actual = service1.findStudent(john.getId());
            assert john.equals(actual);

            Course maryCourse = new Course(2L, "SQL", "practical");
            Student mary1 = new Student(556L, "Mary", 19, 11, 15);
            
            service1.save1(mary1);
            service2.save1(maryCourse);
            service3.addRow(556L, 2L);
            service3.addRow(555L, 2L);

            List<Student> all = service1.findAll();
            System.out.println(all);
        };
    }
}
