package com.company.customer.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CustomerNotFoundException(String msg) {
		super("No such customer: " + msg);
	}
	
}
