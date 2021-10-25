package ru.tinkoff.fintech.lesson4.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private long course_id;
    private String name2;
    private String description;


}