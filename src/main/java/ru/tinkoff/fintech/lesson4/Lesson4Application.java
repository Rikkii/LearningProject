package ru.tinkoff.fintech.lesson4;
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
            Course johnCourse = new Course(1L, "Java", "very good", 3);
            Student john = new Student(555L, "John", 27, 12, 14, 2);
            Student ron = new Student(557L, "Ron", 26, 12, 17, 5);
            service1.save(john);
            service2.save(johnCourse);
            service3.addRow(555L, 1L);

            System.out.println(service1.findStudent(555L));
            System.out.println(service2.findCourse(1L));

            Course maryCourse = new Course(2L, "SQL", "practical", 2);
            Student mary1 = new Student(556L, "Mary", 19, 11, 15, 5);

            service1.save(mary1);
            service2.save(maryCourse);
            service3.addRow(556L, 2L);
        };
    }
}

