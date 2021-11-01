package ru.tinkoff.fintech.lesson4.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private long courseId;
    private String name;
    private String description;
    private int requiredGrade;

}