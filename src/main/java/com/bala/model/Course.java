package com.bala.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@Entity
@Table(name="course")
@Data
public class Course {
	
	@Id
	@Column(name="course_id")
	private Integer courseId;
	
	@Column(name="course_name")
	private String courseName;
	
	@ManyToMany(
			mappedBy = "courses",
			fetch=FetchType.LAZY
			)
	//@LazyCollection(LazyCollectionOption.FALSE)
    Set<Student> students;

}
