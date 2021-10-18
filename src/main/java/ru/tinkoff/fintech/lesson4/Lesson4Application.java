package ru.tinkoff.fintech.lesson4;

import java.util.List;


import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ru.tinkoff.fintech.lesson4.model.Course;
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
            Course johnCourse = new Course("Java", "very good");
            Student john = new Student(555L, "John", 27, 12, 14, johnCourse);
            service.save1(john);

            // find John by id and assert fields
            Student actual = service.findStudent(john.getId());
            assert john.equals(actual);

            // create and save Mary
            Course maryCourse = new Course("SQL", "practical");
            Student mary = new Student(556L, "Mary", 19, 11, 15, maryCourse);
            service.save1(mary);

            // find all students
            List<Student> all = service.findAll();
            System.out.println(all);
        };

    }



    }
