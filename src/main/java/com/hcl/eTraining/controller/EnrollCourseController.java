package com.hcl.eTraining.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.eTraining.dto.UserCourseRequestdto;
import com.hcl.eTraining.dto.UserCourseResponsedto;
import com.hcl.eTraining.dto.UserEnrolledCourseResponse;
import com.hcl.eTraining.dto.UserEnrolledCourseResponsedto;
import com.hcl.eTraining.exception.CourseException;
import com.hcl.eTraining.service.UserCourseService;

/**
 * @author Dev
 *
 */
@RestController
@RequestMapping("/eCourseUser")
public class EnrollCourseController {

	private static final Logger logger = LoggerFactory.getLogger(EnrollCourseController.class);

	@Autowired
	private UserCourseService userCourseService;

	@PostMapping(value = "/enrollCourse")
	public ResponseEntity<Optional<UserCourseResponsedto>> enrollCourse(
			@RequestBody UserCourseRequestdto userCourseRequestdto) throws CourseException {
		logger.info("Inside enrollCourse method of User Controller");
		Optional<UserCourseResponsedto> response = userCourseService.enrollCourse(userCourseRequestdto);
		response.get().setMessage("Corse Enrolled Successfully");
		response.get().setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/viewAllUserEnrolledCourses/{userId}")
	public ResponseEntity<UserEnrolledCourseResponsedto> getAllUserEnrolledCourses(@PathVariable Integer userId) {
		logger.info("Inside getAllEnrolledCourses method of User Controller");
		Optional<List<UserEnrolledCourseResponse>> response = userCourseService.getAllUserEnrolledCourses(userId);
		UserEnrolledCourseResponsedto userEnrolledCourseResponsedto = new UserEnrolledCourseResponsedto();
		if (!response.isPresent()) {
			userEnrolledCourseResponsedto.setMessage("No Courses Enrolled");
			userEnrolledCourseResponsedto.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<>(userEnrolledCourseResponsedto, HttpStatus.OK);
		}
		userEnrolledCourseResponsedto.setMessage("Success");
		userEnrolledCourseResponsedto.setStatusCode(HttpStatus.OK.value());
		userEnrolledCourseResponsedto.setListOfenrolledCourses(response.get());
		return new ResponseEntity<>(userEnrolledCourseResponsedto, HttpStatus.OK);
	}
}
