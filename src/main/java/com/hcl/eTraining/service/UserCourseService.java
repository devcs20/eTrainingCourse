package com.hcl.eTraining.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hcl.eTraining.dto.UserCourseRequestdto;
import com.hcl.eTraining.dto.UserCourseResponsedto;
import com.hcl.eTraining.dto.UserEnrolledCourseResponse;
import com.hcl.eTraining.exception.CourseException;


/**
 * @author Dev
 *
 */
@Service
public interface UserCourseService {
	public Optional<UserCourseResponsedto> enrollCourse(UserCourseRequestdto userCourseRequestdto) throws CourseException;
	public Optional<List<UserEnrolledCourseResponse>> getAllUserEnrolledCourses(int userId);
}
