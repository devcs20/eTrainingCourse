package com.hcl.eTraining.dto;

import java.time.LocalTime;

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

public class CourseRequest {

	private Integer courseId;
	private String courseName;
	private String courseCategory;
	private Integer price;
	private LocalTime courseDuration;
	
}
