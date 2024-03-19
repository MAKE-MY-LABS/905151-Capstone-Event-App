package com.capstone.eventapp.service;
// create UserServiceImpl class and implement UserService interface and add the implementation for the methods. 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.eventapp.exception.EmailIdAlreadyExistsException;
import com.capstone.eventapp.model.User;
import com.capstone.eventapp.repository.UserRepository;

@Service

public class UserServiceImpl implements UserService {
    // autowire the UserRepository
    @Autowired
    private UserRepository userRepository;

    // add the implementation for the saveUser method
    @Override
    public User saveUser(User user) throws EmailIdAlreadyExistsException {
        // check if the user with the emailId already exists
        if (userRepository.findByEmailId(user.getEmailId()).isPresent()) {
            // if user with the emailId already exists, throw EmailIdAlreadyExistsException
            throw new EmailIdAlreadyExistsException("User with emailId " + user.getEmailId() + " already exists");
        }
        // if user with the emailId does not exist, save the user
        return userRepository.save(user);
    }

    // add the implementation for the findByEmailId method
    @Override
    public Optional<User> findByEmailId(String emailId) {
        // return the user by emailId
        return userRepository.findByEmailId(emailId);
    }

    // add the implementation for the findByEmailIdAndPassword method
    @Override
    public Optional<User> findByEmailIdAndPassword(String emailId, String password) {
        // return the user by emailId and password
        return userRepository.findByEmailIdAndPassword(emailId, password);
    }
}
