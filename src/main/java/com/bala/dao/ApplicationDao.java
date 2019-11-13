package com.bala.dao;

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
		entityManager.remove(entity);
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
