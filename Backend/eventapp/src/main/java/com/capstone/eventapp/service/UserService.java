package com.capstone.eventapp.service;

// craete userService interface and add method for save user, find user by emailId, find user by emailId and password and autowired user Repository
import java.util.Optional;

import com.capstone.eventapp.exception.EmailIdAlreadyExistsException;
import com.capstone.eventapp.model.User;

public interface UserService {
    public User saveUser(User user) throws EmailIdAlreadyExistsException;

    public Optional<User> findByEmailId(String emailId);

    public Optional<User> findByEmailIdAndPassword(String emailId, String password);
}

