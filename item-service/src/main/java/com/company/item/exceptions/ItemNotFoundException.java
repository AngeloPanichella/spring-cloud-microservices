package com.company.item.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ItemNotFoundException(String msg) {
		super("No such item: " + msg);
	}
	
}
