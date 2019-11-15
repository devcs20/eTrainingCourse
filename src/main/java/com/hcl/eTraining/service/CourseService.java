package com.hcl.eTraining.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hcl.eTraining.dto.CourseRequest;
import com.hcl.eTraining.exception.CourseException;


/**
 * @author Dev
 *
 */
@Service
public interface CourseService {

	public Optional<List<CourseRequest>> getAllAvailableCourses();
	public CourseRequest getCourseById(int courseId)throws CourseException;
}
