package com.hcl.eTraining.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.eTraining.dto.CourseRequest;
import com.hcl.eTraining.entity.Course;
import com.hcl.eTraining.exception.CourseException;
import com.hcl.eTraining.repository.CourseRepository;

import lombok.extern.slf4j.Slf4j;


/**
 * @author Dev
 *
 */
@Service
@Slf4j
public class CourseServiceImpl implements CourseService{
	@Autowired
	CourseRepository courseRepository;
	
	
	public Optional<List<CourseRequest>> getAllAvailableCourses(){
		
		log.info("Entering into getAllAvailableCourses of CouseServiceImpl");
		List<Course> courses=courseRepository.findAll();
		List<CourseRequest> response= new ArrayList<>();
		for(Course course:courses) {
			CourseRequest courseRequest = new CourseRequest();
			BeanUtils.copyProperties(course, courseRequest);
			response.add(courseRequest);
		}
			
		return Optional.of(response);
		
	}
	
	public CourseRequest getCourseById(int courseId) throws CourseException {
		log.info("Entering into getCourseById of CouseServiceImpl");
		Optional<Course> courseOptionalDetails=courseRepository.findById(courseId);
		if(!courseOptionalDetails.isPresent()) {
			throw new CourseException("Invalid Course ID");
		}
		Course courseDetails= courseOptionalDetails.get();
		CourseRequest courseRequest= new CourseRequest();
		BeanUtils.copyProperties(courseDetails, courseRequest);
		return courseRequest;
		
	}
}
