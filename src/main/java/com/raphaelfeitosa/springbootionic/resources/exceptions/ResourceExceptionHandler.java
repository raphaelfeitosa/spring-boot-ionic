package com.raphaelfeitosa.springbootionic.resources.exceptions;

import com.raphaelfeitosa.springbootionic.services.exceptions.DataIntegrityException;
import com.raphaelfeitosa.springbootionic.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundExceptionHandler(ObjectNotFoundException e, HttpServletRequest request) {
        String error = "Object not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrityExceptionHandler(DataIntegrityException e, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotExceptionHandler(MethodArgumentNotValidException e, HttpServletRequest request) {
        String error = "Insert argument error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidationError err = new ValidationError(Instant.now(), status.value(), error, "Error validation", request.getRequestURI());
        for(FieldError x : e.getBindingResult().getFieldErrors()) {
            err.addError(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(err);
    }

//
//
//    @ExceptionHandler(ValidateCpfException.class)
//    public ResponseEntity<StandardError> validateCpfExceptionHandler(ValidateCpfException e, HttpServletRequest request) {
//        String error = "Insert error";
//        HttpStatus status = HttpStatus.BAD_REQUEST;
//        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
//        return ResponseEntity.status(status).body(err);
//    }
//
//    @ExceptionHandler(ValidateEmailException.class)
//    public ResponseEntity<StandardError> validateEmailExceptionHandler(ValidateEmailException e, HttpServletRequest request) {
//        String error = "Insert error";
//        HttpStatus status = HttpStatus.BAD_REQUEST;
//        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
//        return ResponseEntity.status(status).body(err);
//    }
//
//    @ExceptionHandler(AddressNotFoundException.class)
//    public ResponseEntity<StandardError> addressNotFoundExceptionHandler(AddressNotFoundException e, HttpServletRequest request) {
//        String error = "Address not found";
//        HttpStatus status = HttpStatus.NOT_FOUND;
//        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
//        return ResponseEntity.status(status).body(err);
//    }
}
