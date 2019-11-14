package com.bala.rest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bala.dao.AppService;
import com.bala.dao.ApplicationDao;
import com.bala.model.Course;
import com.bala.model.Student;

@SpringBootTest
class StateStreetApplicationTests {


	@Autowired
	private ApplicationDao applicationDao;
	
	@Autowired
	private AppService appService;
	

	@Test
	@DisplayName("Test Get Student by Id")
	public void testGetStudent() {
		assertNotNull(applicationDao.getStudentById(1));
	}
	

	//@Test
	@DisplayName("Test Get Students by Course ")
	public void testGetStudentsByCourseId() {
		List<Student> students =	appService.getStudentsByCourse(1);
		assertNotNull(students);
	//	assertFalse(students.isEmpty());
	}
	
	@Test
	@DisplayName("Test Register Student with courses")
	public void testRegisterStudentCourses() {
		Student student = new Student();
		student.setStudentId(3);
		student.setStudentName("student3");
		
		Course course = new Course();
		course.setCourseId(1);
		course.setCourseName("course1");
		List<Course> courses = new ArrayList<>();
		courses.add(course);
		appService.registerStudentCouse(student, courses);
		
		assertNotNull(applicationDao.getStudentById(3));
	}
	
	@Test
	@DisplayName("Test Delete Students")
	public void testDeleteStudent() {
		appService.deleteStudent(applicationDao.getStudentById(2));
	}
	
	@Test
	@DisplayName("Test Get Students Not Registered")
	public void testGetStudentsNotRegistered(){
		assertFalse(applicationDao.getStudentsNotRegistered().isEmpty());
	}

}
