package com.company.tax.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class TaxMoreResultException extends Exception {

    private static final long serialVersionUID = 1L;

    public TaxMoreResultException(String msg) {
        super("More tax founded: " + msg);
    }

}