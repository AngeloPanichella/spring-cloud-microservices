package com.company.authentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AuthenticationSessionMoreResultException extends Exception {

    private static final long serialVersionUID = 1L;

    public String xxx;

    public AuthenticationSessionMoreResultException(String msg) {
        super("More authentication session founded: " + msg);
    }

}