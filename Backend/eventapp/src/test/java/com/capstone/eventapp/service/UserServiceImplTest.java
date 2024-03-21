package com.capstone.eventapp.service;

import com.capstone.eventapp.exception.EmailIdAlreadyExistsException;
import com.capstone.eventapp.model.User;
import com.capstone.eventapp.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setEmailId("test@test.com");
        user.setPassword("password");

        when(userRepository.findByEmailId(anyString())).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(user);

        User saved = userService.saveUser(user);
        assertEquals(user, saved);
    }

    @Test
    public void testSaveUser_EmailIdAlreadyExists() {
        User user = new User();
        user.setEmailId("test@test.com");
        user.setPassword("password");

        when(userRepository.findByEmailId(anyString())).thenReturn(Optional.of(user));

        assertThrows(EmailIdAlreadyExistsException.class, () -> userService.saveUser(user));
    }

    @Test
    public void testFindByEmailId() {
        User user = new User();
        user.setEmailId("test@test.com");
        user.setPassword("password");

        when(userRepository.findByEmailId(anyString())).thenReturn(Optional.of(user));

        Optional<User> found = userService.findByEmailId("test@test.com");
        assertEquals(user, found.get());
    }

    @Test
    public void testFindByEmailIdAndPassword() {
        User user = new User();
        user.setEmailId("test@test.com");
        user.setPassword("password");

        when(userRepository.findByEmailIdAndPassword(anyString(), anyString())).thenReturn(Optional.of(user));

        Optional<User> found = userService.findByEmailIdAndPassword("test@test.com", "password");
        assertEquals(user, found.get());
    }
}
