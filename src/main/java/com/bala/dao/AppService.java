package com.bala.dao;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bala.model.Course;
import com.bala.model.CourseStudents;
import com.bala.model.Student;

@Component
public class AppService {

	@Autowired
	private ApplicationDao appDao;

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	public Student getStudentById(Integer studentId) {
		return appDao.getStudentById(studentId);
	}

	/**
	 * 
	 * @param student
	 */
	@Transactional
	public void deleteStudent(Student student) {
		appDao.deleteEntity(student);
	}

	/**
	 * 
	 * @param student
	 * @param courses
	 */
	@Transactional
	public void registerStudentCouse(Student student, List<Course> courses) {
		appDao.saveEntity(student);
		courses.forEach((c)->{
			CourseStudents cs = new CourseStudents();
			cs.setCourseId(c.getCourseId());
			cs.setStudentId(student.getStudentId());
			appDao.saveEntity(cs);
		});
	}

	/**
	 * 
	 * @param courseId
	 * @return
	 */
	@Transactional
	public List<Student> getStudentsByCourse(Integer courseId){
		Course course = appDao.getCourseByCourseId(courseId);
		Hibernate.initialize(course.getStudents());
		List<Student> studentsList = course.getStudents().stream().collect(Collectors.toList());
		Collections.sort(studentsList);
		return studentsList;
	}
}
