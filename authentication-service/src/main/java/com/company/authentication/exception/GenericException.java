package com.company.authentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class GenericException extends Exception {

    private static final long serialVersionUID = 1L;

    public String xxx;

    public GenericException(String msg) {
        super("Generic exception: " + msg);
    }

}