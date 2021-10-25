CREATE TABLE students
(
    id   LONG PRIMARY KEY,
    name1 VARCHAR(64) NOT NULL,
    age  INT         NOT NULL,
    timeStart INT    NOT NULL,
    timeEnd   INT    NOT NULL
);

CREATE TABLE courses
(
    course_id LONG NOT NULL PRIMARY KEY,
    name2 VARCHAR(64) NOT NULL,
    description VARCHAR(64) NOT NULL

);

CREATE TABLE students_courses
(
    id LONG NOT NULL,
    course_id LONG NOT NULL,
    foreign key (id) references students (id),
    foreign key (course_id) references courses (course_id)
)
