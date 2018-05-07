package com.company.order.security.exception;

import org.springframework.security.authentication.BadCredentialsException;

public class JwtBadCredentialsException extends BadCredentialsException {

    public JwtBadCredentialsException(String msg) {
        super(msg);
    }

    public JwtBadCredentialsException(String msg, Throwable t) {
        super(msg, t);
    }

}
