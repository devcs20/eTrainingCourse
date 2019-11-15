package com.hcl.eTraining.exception;

import lombok.Getter;
import lombok.Setter;


/**
 * @author Dev
 *
 */
@Getter
@Setter
public class CourseException extends Exception{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String exceptionMessage;

	public CourseException(String exceptionMessage) {
		super();
		this.exceptionMessage = exceptionMessage;
	}
	
}
