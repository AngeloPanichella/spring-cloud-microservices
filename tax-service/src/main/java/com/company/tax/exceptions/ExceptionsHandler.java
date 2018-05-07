package com.company.tax.exceptions;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@ControllerAdvice(basePackages = "com.company.tax.exceptions")
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TaxNotFoundException.class)
    public ResponseEntity<VndErrors> notFoundException(final TaxNotFoundException e) {
        return error(e, HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(TaxGenericException.class)
    public ResponseEntity<VndErrors> genericException(final TaxGenericException e) {
        return error(e, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler(TaxMoreResultException.class)
    public ResponseEntity<VndErrors> moreFoundedException(final TaxMoreResultException e) {
        return error(e, HttpStatus.CONFLICT, e.getMessage());
    }

    private ResponseEntity<VndErrors> error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(new VndErrors(logRef, message), httpStatus);
    }
}