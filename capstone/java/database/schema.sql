BEGIN TRANSACTION;

DROP TABLE IF EXISTS users_course, users, course, curricula;

DROP SEQUENCE IF EXISTS seq_course_id, seq_curricula_id;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	is_teacher boolean NOT NULL,
	name varchar(100) NOT NULL,
	email varchar(50) NOT NULL,
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
	cost integer NOT NULL,
	curriculum_id int NOT NULL,
	teacher_id int NOT NULL,
	CONSTRAINT PK_course_id PRIMARY KEY (course_id),
	CONSTRAINT FK_teacher_id FOREIGN KEY (teacher_id) REFERENCES users (user_id),
	CONSTRAINT CK_difficulty CHECK (difficulty IN ('Easy', 'Medium', 'Difficult'))
);

    CREATE SEQUENCE seq_curricula_id
    INCREMENT BY 1
    start WITH 3001
    NO MAXVALUE;

CREATE TABLE curricula (
	curriculum_id int NOT NULL DEFAULT nextval('seq_curricula_id'),
	daily_instruction varchar(2000) NOT NULL,
	links varchar(2000),
	hw_assignment varchar(16000) NOT NULL,
	course_id int NOT NULL,
	CONSTRAINT PK_curricula_id PRIMARY KEY (curriculum_id),
	CONSTRAINT FK_course_id FOREIGN KEY (course_id) REFERENCES course (course_id)
);

CREATE TABLE users_course (
	user_id int NOT NULL,
	course_id int NOT NULL,
	completed boolean NOT NULL,
	CONSTRAINT PK_users_course PRIMARY KEY (user_id, course_id),
	CONSTRAINT FK_users_course_user FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT FK_users_course_course FOREIGN KEY (course_id) REFERENCES course (course_id)
);


COMMIT TRANSACTION;