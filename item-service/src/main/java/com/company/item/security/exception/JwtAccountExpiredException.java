package com.company.item.security.exception;

import org.springframework.security.authentication.AccountExpiredException;

public class JwtAccountExpiredException extends AccountExpiredException{

    public JwtAccountExpiredException(String msg) {
        super(msg);
    }

    public JwtAccountExpiredException(String msg, Throwable t) {
        super(msg, t);
    }
}
