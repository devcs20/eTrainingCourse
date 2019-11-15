package com.hcl.eTraining.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.eTraining.entity.Course;


/**
 * @author Dev
 *
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	

}
