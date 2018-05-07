package com.company.tax.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class TaxNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TaxNotFoundException(String msg) {
		super("No such tax: " + msg);
	}
	
}
