package com.capstone.eventapp.controller;

/*
 * create a controller for the user with following methods: validateUser, saveUser using loggers from UserServices
  
 * user restcontroller autowire the UserService and use the methods to validate and save the user
 * for saveuser method, use UserRepository to save the user and throw EmailIdAlreadyExistsException if the emailId already exists
 * for validateUser method, use UserRepository to validate the user and return generated the token using jwt
 * create generate token method using jwt
 *  
 */
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.eventapp.exception.EmailIdAlreadyExistsException;
import com.capstone.eventapp.model.User;
import com.capstone.eventapp.service.UserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * The UserController class handles the HTTP requests related to user
 * operations.
 * It provides endpoints for saving a user and validating a user's credentials.
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * Saves a user in the system.
     *
     * @param user The user object to be saved.
     * @return ResponseEntity<User> The response entity containing the saved user
     *         object.
     */
    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        try {
            logger.info("User with emailId: {} saved successfully", user.getEmailId());
            return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);

        } catch (EmailIdAlreadyExistsException e) {
            logger.error("EmailIdAlreadyExistsException occurred: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    /**
     * Validates a user by checking their email and password.
     *
     * @param userInput The user input containing the email and password.
     * @return A ResponseEntity containing a string representation of the generated
     *         token if the user is valid,
     *         otherwise returns a ResponseEntity with HTTP status UNAUTHORIZED.
     */
    @PostMapping("/login")
    public ResponseEntity<String> validateUser(@RequestBody User userInput) {
        logger.info("Validating user with emailId: {}", userInput.getEmailId());
        Optional<User> user = userService.findByEmailIdAndPassword(userInput.getEmailId(),
                userInput.getPassword());
        if (user.isPresent()) {
            logger.info("User with emailId: {} validated successfully", userInput.getEmailId());
            return new ResponseEntity<>(generateToken(userInput.getEmailId()), HttpStatus.OK);
        } else {
            logger.error("User with emailId: {} not found", userInput.getEmailId());
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    // for validateUser method, use UserRepository to validate the user and return
    // generated the token using jwt create generate token method using jwt
    /**
     * Generates a token for the given email ID.
     *
     * @param emailId the email ID for which the token is generated
     * @return the generated token
     */
    private String generateToken(String emailId) {
        return Jwts.builder().setSubject(emailId).signWith(SignatureAlgorithm.HS256, "CTS-EVENTAPP").compact();
    }

}
