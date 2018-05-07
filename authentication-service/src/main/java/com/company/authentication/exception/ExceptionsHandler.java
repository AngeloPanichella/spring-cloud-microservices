package com.company.authentication.exception;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@ControllerAdvice(basePackages = "com.company.authentication.exception")
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AuthenticationSessionMoreResultException.class)
    public ResponseEntity<VndErrors> moreResulteException(final AuthenticationSessionMoreResultException e) {
        return error(e, HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(RefreshTokenNotExistsException.class)
    public ResponseEntity<VndErrors> refreshTokenNotExistsException(final RefreshTokenNotExistsException e) {
        return error(e, HttpStatus.NOT_FOUND, e.getMessage());
    }

    private ResponseEntity<VndErrors> error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(new VndErrors(logRef, message), httpStatus);
    }
}