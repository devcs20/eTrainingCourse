package com.hcl.eTraining.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


/**
 * @author Dev
 *
 */
@Entity
@Table
@Getter
@Setter
public class UserCourse {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userCourseId;
	private Integer courseId;
	private Integer userId;
	private LocalDate enrolledOn;
	private LocalDate expiryDate;
	private String courseStatus;
	
}
