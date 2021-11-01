CREATE TABLE students
(
    id   LONG PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    age  INT         NOT NULL,
    timeStart INT    NOT NULL,
    timeEnd   INT    NOT NULL,
    grade INT NOT NULL
);

CREATE TABLE courses
(
    courseId LONG NOT NULL PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    description VARCHAR(64) NOT NULL,
    requiredGrade INT NOT NULL
);

CREATE TABLE students_courses
(
    id LONG NOT NULL,
    courseId LONG NOT NULL,
    foreign key (id) references students (id),
    foreign key (courseId) references courses (courseId)
)