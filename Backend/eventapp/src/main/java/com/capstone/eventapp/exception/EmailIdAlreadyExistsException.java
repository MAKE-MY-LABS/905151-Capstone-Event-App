package com.capstone.eventapp.exception;

// create a custom exception class EmailIdAlreadyExistsException which extends RuntimeException
public class EmailIdAlreadyExistsException extends RuntimeException {
    // create a constructor with a message parameter
    public EmailIdAlreadyExistsException(String message) {
        // call the super class constructor with the message
        super(message);
    }
}

