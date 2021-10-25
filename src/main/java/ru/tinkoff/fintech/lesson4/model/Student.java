package ru.tinkoff.fintech.lesson4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private long id;
    private String name1;
    private int age;
    private int timeStart;
    private int timeEnd;
    private long course_id;

}
