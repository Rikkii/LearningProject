package ru.tinkoff.fintech.lesson4;

import java.util.List;
import java.util.UUID;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ru.tinkoff.fintech.lesson4.model.Student;

import ru.tinkoff.fintech.lesson4.service.StudentService;

@SpringBootApplication
public class Lesson4Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson4Application.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(StudentService service) {
        return args -> {
            // create and save John
            Student john = new Student(555L, "John", 27, 12, 14, "1");
            service.save(john);

            // find John by id and assert fields
            Student actual = service.findStudent(john.getId());
            assert john.equals(actual);

            // create and save Mary
            Student mary = new Student(556L, "Mary", 19, 11, 15, "2");
            service.save(mary);

            // find all students
            List<Student> all = service.findAll();
            System.out.println(all);
        };

    }


}
