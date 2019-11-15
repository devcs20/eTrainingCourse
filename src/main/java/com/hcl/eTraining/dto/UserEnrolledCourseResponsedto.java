package com.hcl.eTraining.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


/**
 * @author Dev
 *
 */
@Getter
@Setter
public class UserEnrolledCourseResponsedto {
	private String message;
	private Integer statusCode;
	private List<UserEnrolledCourseResponse> listOfenrolledCourses;
}
