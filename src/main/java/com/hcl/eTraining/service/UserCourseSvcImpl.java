package com.hcl.eTraining.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.eTraining.dto.UserCourseRequestdto;
import com.hcl.eTraining.dto.UserCourseResponsedto;
import com.hcl.eTraining.dto.UserEnrolledCourseResponse;
import com.hcl.eTraining.entity.Course;
import com.hcl.eTraining.entity.User;
import com.hcl.eTraining.entity.UserCourse;
import com.hcl.eTraining.exception.CourseException;
import com.hcl.eTraining.repository.CourseRepository;
import com.hcl.eTraining.repository.UserCourseRepository;
import com.hcl.eTraining.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;


/**
 * @author Dev
 *
 */
@Service
@Slf4j
public class UserCourseSvcImpl implements  UserCourseService{

	@Autowired
	UserCourseRepository userCourseRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public Optional<UserCourseResponsedto> enrollCourse(UserCourseRequestdto userCourseRequestdto) throws CourseException {
		log.info("Entering into enrollCourse of UserCourseSvcImpl");
		Optional<Course> courseValidation=courseRepository.findById(userCourseRequestdto.getCourseId());
		Optional<User> userValidation=userRepository.findById(userCourseRequestdto.getUserId());
		Optional<UserCourse> checkForEnrollment=userCourseRepository.findByUserIdAndCourseId(userCourseRequestdto.getCourseId(), userCourseRequestdto.getCourseId());
		if(checkForEnrollment.isPresent()) {
			log.error("User has already enrolled this course");
			throw new CourseException("You have already enrolled this course");
		}
		UserCourse userCourse= new UserCourse();
		userCourse.setCourseId(userCourseRequestdto.getCourseId());
		userCourse.setUserId(userCourseRequestdto.getUserId());
		userCourse.setCourseStatus("Not Started");
		userCourse.setEnrolledOn(LocalDate.now());
		userCourse.setExpiryDate(LocalDate.now().plusDays(30));
		userCourseRepository.save(userCourse);
		UserCourseResponsedto userCourseResponsedto= new UserCourseResponsedto();
		Optional<UserCourseResponsedto> optional=Optional.of(userCourseResponsedto);
		return optional;
	}
	
	public Optional<List<UserEnrolledCourseResponse>> getAllUserEnrolledCourses(int userId){
		log.info("Entering into getAllEnrolledCourses of UserCourseSvcImpl");
		List<UserCourse> lists=userCourseRepository.findAllByUserId(userId);
		List<UserEnrolledCourseResponse> enrolledList= new ArrayList<>();
		lists.forEach(list->{
			UserEnrolledCourseResponse userEnrolledCourseResponse= new UserEnrolledCourseResponse();
			BeanUtils.copyProperties(list, userEnrolledCourseResponse);
			enrolledList.add(userEnrolledCourseResponse);
		}
		);
		return Optional.of(enrolledList);
		
	}
}
