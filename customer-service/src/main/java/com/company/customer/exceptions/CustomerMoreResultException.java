package com.company.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CustomerMoreResultException extends Exception {

    private static final long serialVersionUID = 1L;

    public CustomerMoreResultException(String msg) {
        super("More customer founded: " + msg);
    }

}