package com.bala.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="student_courses")
@Data
public class CourseStudents {
	
	@Id
	@Column(name="course_student_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_courses_generator")
	@SequenceGenerator(name="student_courses_generator", sequenceName = "student_courses_generator", allocationSize=1)
	private Integer courseStudentId;

	@Column(name="course_id")
	private Integer courseId;
	
	@Column(name="student_id")
	private Integer studentId;
}
