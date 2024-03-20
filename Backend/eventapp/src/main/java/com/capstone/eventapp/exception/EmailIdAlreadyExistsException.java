package com.capstone.eventapp.exception;

// create a custom exception class EmailIdAlreadyExistsException which extends RuntimeException

/**
 * Exception thrown when an email ID already exists in the system.
 */
/**
 * Constructs a new EmailIdAlreadyExistsException with the specified detail
 * message.
 *
 * @param message the detail message
 */
public class EmailIdAlreadyExistsException extends RuntimeException {

    /**
     * This exception is thrown when an email ID already exists in the system.
     * It is a subclass of the RuntimeException class.
     */
    public EmailIdAlreadyExistsException(String message) {
        super(message);
    }
}
