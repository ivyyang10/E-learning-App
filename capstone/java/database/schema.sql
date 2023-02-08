BEGIN TRANSACTION;

DROP TABLE IF EXISTS users_course, users, course, quiz, question, quiz_question, homework CASCADE;

DROP SEQUENCE IF EXISTS seq_course_id;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	name varchar(100) NOT NULL,
	email varchar(50) NOT NULL,
	role varchar (20) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

	CREATE SEQUENCE seq_course_id
	INCREMENT BY 1
	start with 2001
	NO MAXVALUE;

CREATE TABLE course (
    course_id INT NOT NULL DEFAULT nextval('seq_course_id'),
	course_name varchar(100) NOT NULL UNIQUE,
	description varchar(200) NOT NULL,
	difficulty varchar(10) NOT NULL,
	cost numeric(9,2) NOT NULL,
	teacher_id integer NOT NULL,
	daily_instruction varchar(2000) NOT NULL,
	links varchar(2000),
    hw_assignment varchar(16000) NOT NULL,
	CONSTRAINT PK_course_id PRIMARY KEY (course_id),
	CONSTRAINT FK_teacher_id FOREIGN KEY (teacher_id) REFERENCES users (user_id),
	CONSTRAINT CK_difficulty CHECK (difficulty IN ('Easy', 'Medium', 'Difficult'))
);



CREATE TABLE users_course (
	user_id int NOT NULL,
	course_id int NOT NULL,
	CONSTRAINT PK_users_course PRIMARY KEY (user_id, course_id),
	CONSTRAINT FK_users_course_user FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT FK_users_course_course FOREIGN KEY (course_id) REFERENCES course (course_id)
);

CREATE TABLE homework (
     homework_id serial,
     course_id int NOT NULL,
     student_id int NOT NULL,
     hw_submission VARCHAR(16000),
     completed boolean NOT NULL,
     grade int,
     CONSTRAINT PK_homework_id PRIMARY KEY (homework_id),
     CONSTRAINT FK_course_id FOREIGN KEY (course_id) REFERENCES course (course_id),
     CONSTRAINT FK_student_id FOREIGN KEY (student_id) REFERENCES users (user_id)
     );


CREATE TABLE quiz (
    quiz_id serial,
    quiz_name varchar(20) NOT NULL,
    course_id int,
    CONSTRAINT PK_quiz PRIMARY KEY(quiz_id),
    CONSTRAINT FK_course_id FOREIGN KEY (course_id) REFERENCES course (course_id)
);

CREATE TABLE question (
    question_id serial,
    question_text varchar(100) NOT NULL,
    correct_answer int NOT NULL,
    answers VARCHAR,
    CONSTRAINT PK_question PRIMARY KEY(question_id)
);

CREATE TABLE quiz_question (
    quiz_id int,
    question_id int,
    CONSTRAINT PK_quiz_question PRIMARY KEY(quiz_id, question_id),
	CONSTRAINT FK_quiz_id FOREIGN KEY(quiz_id) REFERENCES quiz(quiz_id),
	CONSTRAINT FK_question_id FOREIGN KEY(question_id) REFERENCES question(question_id)
);




INSERT INTO quiz
(quiz_name)
VALUES
('test_quiz');

--Question 1
INSERT INTO question
(question_text, correct_answer,  answers)
VALUES
('What color is the sky?', 2,'yellow, blue, green, red');

INSERT INTO quiz_question
(quiz_id, question_id)
VALUES
((SELECT quiz_id FROM quiz WHERE quiz_name = 'test_quiz'), lastval());

--Question 2
INSERT INTO question
(question_text, correct_answer, answers)
VALUES
('A skeleton walks into a bar, and says to the bartender, "Give me a beer and a ..."', 3,'hair brush, dry erase marker, mop, yo-yo');


INSERT INTO quiz_question
(quiz_id, question_id)
VALUES
((SELECT quiz_id FROM quiz WHERE quiz_name = 'test_quiz'), lastval());


COMMIT TRANSACTION;
