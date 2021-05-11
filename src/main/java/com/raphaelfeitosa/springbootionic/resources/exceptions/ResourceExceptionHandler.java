package com.raphaelfeitosa.springbootionic.resources.exceptions;

import com.raphaelfeitosa.springbootionic.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> userNotFoundExceptionHandler(ObjectNotFoundException e, HttpServletRequest request) {
        String error = "User not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<StandardError> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e, HttpServletRequest request) {
//        String error = "Insert argument error";
//        HttpStatus status = HttpStatus.BAD_REQUEST;
//        StandardError err = new StandardError(Instant.now(), status.value(), error, "Error validation", request.getRequestURI());
//        List<FieldMessage> fields = new ArrayList<>();
//        e.getBindingResult().getFieldErrors().forEach( f -> fields.add(new FieldMessage(f.getField(), f.getDefaultMessage())));
//        err.setFields(fields);
//        return ResponseEntity.status(status).body(err);
//    }
//
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
