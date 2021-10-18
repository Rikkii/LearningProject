CREATE TABLE students
(
    id   LONG PRIMARY KEY,
    name1 VARCHAR(64) NOT NULL,
    age  INT         NOT NULL,
    timeStart INT    NOT NULL,
    timeEnd   INT    NOT NULL,
    course JSON    NOT NULL
);
