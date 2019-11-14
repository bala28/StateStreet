package com.bala.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

/**
 * 
 * @author bala
 *
 */
@Entity
@Table(name="student")
@Data
public class Student implements Comparable<Student>{

	@Id
	@Column(name="student_id")
	private Integer studentId;
	
	@Column(name="student_name")
	private String studentName;
	
	@ManyToMany(fetch=FetchType.LAZY)
	//@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
	name = "student_courses", 
	joinColumns = @JoinColumn(name = "student_id"), 
	inverseJoinColumns = @JoinColumn(name = "course_id"))
    Set<Course> courses;

	

	@Override
	public int compareTo(Student o) {
		return this.getStudentName().compareTo(o.getStudentName());
	}
	
}
