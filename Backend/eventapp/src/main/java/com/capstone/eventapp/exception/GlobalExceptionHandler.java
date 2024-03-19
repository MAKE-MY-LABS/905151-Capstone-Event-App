package com.capstone.eventapp.exception;

// create a global exception handler class add to handle all the exceptions and custom exceptions
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// create a class GlobalExceptionHandler
@ControllerAdvice
public class GlobalExceptionHandler {
    // create a method to handle the EmailIdAlreadyExistsException
    @ExceptionHandler(EmailIdAlreadyExistsException.class)
    public ResponseEntity<String> handleEmailIdAlreadyExistsException(EmailIdAlreadyExistsException exception) {
        // return the response entity with the exception message and status code
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }

    // create a method to handle the Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception exception) {
        // return the response entity with the exception message and status code
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}



