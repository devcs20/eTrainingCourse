package com.hcl.eTraining.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author Dev
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class CourseResponsedto {
	
	private String message;
	private Integer statusCode;
	private List<CourseRequest> listOfCourses;

}
