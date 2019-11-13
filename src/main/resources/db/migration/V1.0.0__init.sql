CREATE TABLE student(
	student_id INT(11) NOT NULL,
	student_name VARCHAR(255),
	PRIMARY KEY (student_id)
);


CREATE TABLE course(
	course_id INT(11) NOT NULL ,
	course_name VARCHAR(255),
	PRIMARY KEY (course_id)
);

CREATE TABLE student_courses(
    course_student_id INT(11) NOT NULL AUTO_INCREMENT,
	course_id INT(11) NOT NULL,
	student_id INT(11) NOT NULL,
    FOREIGN KEY (course_id) REFERENCES course(course_id),
    FOREIGN KEY (student_id) REFERENCES student(student_id),
    PRIMARY KEY (course_student_id)
);

create sequence student_courses_generator START WITH 10 INCREMENT BY 1;
