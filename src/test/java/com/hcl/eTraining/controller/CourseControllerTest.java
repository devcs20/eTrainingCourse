package com.hcl.eTraining.controller;

import static org.junit.Assert.assertEquals;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.http.ResponseEntity;

import com.hcl.eTraining.dto.CourseRequest;
import com.hcl.eTraining.dto.CourseResponsedto;

import com.hcl.eTraining.entity.Course;
import com.hcl.eTraining.exception.CourseException;
import com.hcl.eTraining.service.CourseServiceImpl;




/**
 * @author Dev
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CourseControllerTest {

	@InjectMocks
	CourseController courseController;
	
	@Mock
	CourseServiceImpl courseServiceImpl;
	
	CourseRequest courseRequest=null;
	Course course=null;
	CourseResponsedto courseResponsedto=null;
	Optional<List<CourseRequest>> aa ;
	
	
	@Before
	public void setUp() throws Exception {
		
		List<CourseRequest> list=new ArrayList<>();
		
		
		list.add(courseRequest);
		courseRequest=new CourseRequest();
		courseRequest.setCourseId(1);
		courseRequest.setCourseName("ab");
		courseRequest.setCourseCategory("aa");
		courseRequest.setCourseDuration(LocalTime.now());
		courseRequest.setPrice(11);
		
		aa = Optional.of(list);
		course=new Course();
		course.setCourseId(11);
		course.setCourseName("aba");
		course.setCourseCategory("aaaa");
		course.setCourseDuration(LocalTime.now());
		course.setPrice(111);
		
		
		
	courseResponsedto=new CourseResponsedto();
	courseResponsedto.setMessage("Success");
	courseResponsedto.setStatusCode(201);
	courseResponsedto.setListOfCourses(list);
		
	}

	@Test
	public void testGetAllAvailableCourses() {
	
		Mockito.when(courseServiceImpl.getAllAvailableCourses()).thenReturn(aa);
		
		ResponseEntity<CourseResponsedto> allAvailableCourses = courseController.getAllAvailableCourses();
		
		assertEquals(allAvailableCourses.getStatusCodeValue(),200);
		
		
		
		
		
		
		
	}

	@Test
	public void testGetCourseById() throws CourseException {
		Mockito.when(courseServiceImpl.getCourseById(1)).thenReturn(courseRequest);
		ResponseEntity<CourseRequest> getCourse=courseController.getCourseById(1);
		assertEquals(getCourse.getStatusCodeValue(), 200);
	}

}



