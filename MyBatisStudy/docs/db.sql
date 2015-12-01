create database mybatis;
use mybatis;

CREATE TABLE users(
    id      INT     PRIMARY KEY     AUTO_INCREMENT,
    NAME    VARCHAR(20),
    age     INT
);
INSERT INTO users(NAME, age) VALUES('孤傲苍狼', 27);
INSERT INTO users(NAME, age) VALUES('白虎神皇', 27);

CREATE TABLE orders(
    order_id    INT     PRIMARY KEY     AUTO_INCREMENT,
    order_no    VARCHAR(20), 
    order_price FLOAT
);
INSERT INTO orders(order_no, order_price) VALUES('aaaa', 23);
INSERT INTO orders(order_no, order_price) VALUES('bbbb', 33);
INSERT INTO orders(order_no, order_price) VALUES('cccc', 22);

CREATE TABLE teacher(
    t_id        INT         PRIMARY KEY     AUTO_INCREMENT, 
    t_name      VARCHAR(20)
);
CREATE TABLE class(
    c_id        INT         PRIMARY KEY     AUTO_INCREMENT, 
    c_name      VARCHAR(20), 
    teacher_id  INT
);
ALTER TABLE class ADD CONSTRAINT fk_teacher_id FOREIGN KEY (teacher_id) REFERENCES teacher(t_id);    

INSERT INTO teacher(t_name) VALUES('teacher1');
INSERT INTO teacher(t_name) VALUES('teacher2');

INSERT INTO class(c_name, teacher_id) VALUES('class_a', 1);
INSERT INTO class(c_name, teacher_id) VALUES('class_b', 2);

CREATE TABLE student(
    s_id        INT             PRIMARY KEY     AUTO_INCREMENT, 
    s_name      VARCHAR(20), 
    class_id    INT
);
INSERT INTO student(s_name, class_id) VALUES('student_A', 1);
INSERT INTO student(s_name, class_id) VALUES('student_B', 1);
INSERT INTO student(s_name, class_id) VALUES('student_C', 1);
INSERT INTO student(s_name, class_id) VALUES('student_D', 2);
INSERT INTO student(s_name, class_id) VALUES('student_E', 2);
INSERT INTO student(s_name, class_id) VALUES('student_F', 2);

