package com.hcl.eTraining.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorResponse> handleException(UserException ex){
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setMessage(ex.getExceptionMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CourseException.class)
	public ResponseEntity<ErrorResponse> courseEnrollException(CourseException ex){
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setMessage(ex.getExceptionMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
