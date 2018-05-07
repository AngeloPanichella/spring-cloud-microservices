package com.company.authentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RefreshTokenNotExistsException extends Exception {

    private static final long serialVersionUID = 1L;

    public RefreshTokenNotExistsException(String msg) {
        super("Refresh token not exists: " + msg);
    }

}