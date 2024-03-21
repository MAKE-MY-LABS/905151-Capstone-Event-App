package com.capstone.eventapp.controller;

import com.capstone.eventapp.exception.EmailIdAlreadyExistsException;
import com.capstone.eventapp.model.User;
import com.capstone.eventapp.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setEmailId("test@test.com");
        user.setPassword("password");

        when(userService.saveUser(any(User.class))).thenReturn(user);

        ResponseEntity<User> response = userController.saveUser(user);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testSaveUser_EmailIdAlreadyExists() {
        User user = new User();
        user.setEmailId("test@test.com");
        user.setPassword("password");

        when(userService.saveUser(any(User.class))).thenThrow(EmailIdAlreadyExistsException.class);

        ResponseEntity<User> response = userController.saveUser(user);
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    public void testValidateUser() {
        User user = new User();
        user.setEmailId("test@test.com");
        user.setPassword("password");

        when(userService.findByEmailIdAndPassword(any(String.class), any(String.class))).thenReturn(Optional.of(user));

        ResponseEntity<String> response = userController.validateUser(user);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testValidateUser_Unauthorized() {
        User user = new User();
        user.setEmailId("test@test.com");
        user.setPassword("password");

        when(userService.findByEmailIdAndPassword(any(String.class), any(String.class))).thenReturn(Optional.empty());

        ResponseEntity<String> response = userController.validateUser(user);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }
}