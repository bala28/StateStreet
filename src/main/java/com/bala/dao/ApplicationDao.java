package com.bala.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bala.model.Course;
import com.bala.model.Student;

@Repository
public class ApplicationDao {

	@Autowired
	private EntityManager entityManager;
	
	/**
	 * 
	 * @return
	 */
	public List<Student> getStudentsNotRegistered(){
		String qlString = "Select s from Student s where s.studentId not in (select distinct cs.studentId from CourseStudents cs)";
		return entityManager.createQuery(qlString).getResultList();
	}
	
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	public Student getStudentById(Integer studentId){
		return entityManager.find(Student.class, studentId);
	}
	
	/**
	 * 
	 * @param entity
	 */
	public void deleteEntity(Object entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}
	
	/**
	 * Save Entity
	 * @param entity
	 */
	public void saveEntity(Object entity) {
		entityManager.persist(entity);
	}

	/**
	 * 
	 * @param courseId
	 * @return
	 */
	public Course getCourseByCourseId(Integer courseId) {
		Course course = entityManager.find(Course.class, courseId);
		return course;
	}
	
}
