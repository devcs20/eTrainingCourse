package com.hcl.eTraining.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.eTraining.entity.UserCourse;


/**
 * @author Dev
 *
 */
@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, Integer> {
	
	Optional<UserCourse> findByUserIdAndCourseId(int userId,int courseID);
	List<UserCourse> findAllByUserId(int userId);

}
