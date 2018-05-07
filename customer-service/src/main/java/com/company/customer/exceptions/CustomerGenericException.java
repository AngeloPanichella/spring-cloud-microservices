package com.company.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CustomerGenericException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomerGenericException(String msg) {
		super("Generic customer: " + msg);
	}
	
}
