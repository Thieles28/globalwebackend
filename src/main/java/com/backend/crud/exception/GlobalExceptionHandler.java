package com.backend.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        DetalhesError detalhesError = new DetalhesError(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(detalhesError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        DetalhesError detalhesError = new DetalhesError(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(detalhesError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
