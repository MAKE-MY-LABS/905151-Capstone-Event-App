package com.capstone.eventapp.exception;

// create a global exception handler class add to handle all the exceptions and custom exceptions
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// create a class GlobalExceptionHandler

/**
 * This class is a global exception handler for the Event App backend.
 * It handles various exceptions that may occur during the execution of the
 * application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    // create a method to handle the EmailIdAlreadyExistsException
    /**
     * Handles the EmailIdAlreadyExistsException and returns a ResponseEntity with
     * the exception message and status code.
     *
     * @param exception The EmailIdAlreadyExistsException that occurred.
     * @return A ResponseEntity containing the exception message and
     *         HttpStatus.CONFLICT.
     */
    @ExceptionHandler(EmailIdAlreadyExistsException.class)
    public ResponseEntity<String> handleEmailIdAlreadyExistsException(EmailIdAlreadyExistsException exception) {
        // return the response entity with the exception message and status code
        logger.error("EmailIdAlreadyExistsException occurred: {}", exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }

    // create a method to handle the Exception
    /**
     * Handles the exception of type Exception.
     * 
     * @param exception The exception to be handled.
     * @return A ResponseEntity object containing the exception message and status
     *         code.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception exception) {
        // return the response entity with the exception message and status code
        logger.error("Exception occurred: {}", exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
