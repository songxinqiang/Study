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

create table p_user(
    id      int     primary key     auto_increment,
    name    varchar(10),
    sex     char(2)
);

insert into p_user(name,sex) values('A',"男");
insert into p_user(name,sex) values('B',"女");
insert into p_user(name,sex) values('C',"男");

-- 创建存储过程(查询得到男性或女性的数量, 如果传入的是0就女性否则是男性)
DELIMITER $
CREATE PROCEDURE ges_user_count(IN sex_id INT, OUT user_count INT)
BEGIN
    IF sex_id=0 THEN
        SELECT COUNT(*) FROM p_user WHERE sex='女' INTO user_count;
    ELSE
        SELECT COUNT(*) FROM p_user WHERE sex='男' INTO user_count;
    END IF;
END
$
DELIMITER ;

-- 调用存储过程
SET @user_count = 0;
CALL ges_user_count(1, @user_count);
SELECT @user_count;


