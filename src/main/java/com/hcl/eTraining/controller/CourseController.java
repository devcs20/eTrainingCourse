package com.hcl.eTraining.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.eTraining.dto.CourseRequest;
import com.hcl.eTraining.dto.CourseResponsedto;
import com.hcl.eTraining.exception.CourseException;
import com.hcl.eTraining.service.CourseService;

import lombok.extern.slf4j.Slf4j;


/**
 * @author Dev
 *
 */
@RestController
@RequestMapping("/eCourse")
@Slf4j
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@GetMapping("/viewAvailableCourses")
	public ResponseEntity<CourseResponsedto> getAllAvailableCourses(){
		log.info("Entering into getAllAvailableCourses of CourseController");
		Optional<List<CourseRequest>> response= courseService.getAllAvailableCourses();
		CourseResponsedto courseResponsedto= new CourseResponsedto();
		if(!response.isPresent()) {
			courseResponsedto.setMessage("No Courses Found");
			courseResponsedto.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<>(courseResponsedto, HttpStatus.EXPECTATION_FAILED);	
		}
		
		courseResponsedto.setMessage("Success");
		courseResponsedto.setStatusCode(HttpStatus.OK.value());
		courseResponsedto.setListOfCourses(response.get());
		
		return new ResponseEntity<>(courseResponsedto, HttpStatus.OK);		
		
	}

	@GetMapping("/viewCourseById/{courseId}")
	public ResponseEntity<CourseRequest> getCourseById(@PathVariable Integer courseId) throws CourseException{
		log.info("Entering into getCourseById of CourseController");
		CourseRequest courseRequest=courseService.getCourseById(courseId);		
		return new ResponseEntity<>(courseRequest, HttpStatus.OK);
	}
}
