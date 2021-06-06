package com.bipin.vehicle.tracker.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private HttpStatus httpStatus;
	
	public CustomException(String message, HttpStatus httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	
	

}
