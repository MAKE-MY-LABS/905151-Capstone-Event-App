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

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
        } catch (EmailIdAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> validateUser(@RequestBody User userInput) {
        Optional<User> user = userService.findByEmailIdAndPassword(userInput.getEmailId(), 
        userInput.getPassword());
        if (user.isPresent()) {
            return new ResponseEntity<>(generateToken(userInput.getEmailId()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
// for validateUser method, use UserRepository to validate the user and return generated the token using jwt create generate token method using jwt 
private String generateToken(String emailId) {
        return Jwts.builder().setSubject(emailId).signWith(SignatureAlgorithm.HS256, "CTS-EVENTAPP").compact();
    }

   
}

