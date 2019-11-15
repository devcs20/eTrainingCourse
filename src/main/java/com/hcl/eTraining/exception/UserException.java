package com.hcl.eTraining.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Dev
 *
 */
@Setter
@Getter
public class UserException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String exceptionMessage;

	public UserException(String exceptionMessage) {
		super();
		this.exceptionMessage = exceptionMessage;
	}
	
	
	
}
