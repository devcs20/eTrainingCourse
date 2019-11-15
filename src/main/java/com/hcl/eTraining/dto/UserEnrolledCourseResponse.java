package com.hcl.eTraining.dto;

import java.time.LocalDate;

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
public class UserEnrolledCourseResponse {

	private Integer userCourseId;
	private Integer courseId;
	private Integer userId;
	private LocalDate enrolledOn;
	private LocalDate expiryDate;
	private String courseStatus;

}
