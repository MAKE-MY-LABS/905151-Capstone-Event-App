package com.capstone.eventapp.service;

// create UserServiceImpl class and implement UserService interface and add the implementation for the methods. 
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.eventapp.exception.EmailIdAlreadyExistsException;
import com.capstone.eventapp.model.User;
import com.capstone.eventapp.repository.UserRepository;

/**
 * This class implements the UserService interface and provides the
 * implementation for various user-related operations.
 */
@Service

public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    // autowire the UserRepository
    @Autowired
    private UserRepository userRepository;

    // add the implementation for the saveUser method
    /**
     * Represents a user in the system.
     */
    @Override
    public User saveUser(User user) throws EmailIdAlreadyExistsException {
        logger.info("User with emailId: {} saved successfully", user.getEmailId());
        // check if the user with the emailId already exists
        if (userRepository.findByEmailId(user.getEmailId()).isPresent()) {
            // if user with the emailId already exists, throw EmailIdAlreadyExistsException
            logger.error("EmailIdAlreadyExistsException occurred: User with emailId {} already exists",
                    user.getEmailId());
            throw new EmailIdAlreadyExistsException("User with emailId " + user.getEmailId() + " already exists");
        }
        // if user with the emailId does not exist, save the user
        return userRepository.save(user);
    }

    // add the implementation for the findByEmailId method
    /**
     * Finds a user by their email ID.
     *
     * @param emailId the email ID of the user to find
     * @return an Optional containing the user with the specified email ID, or an
     *         empty Optional if no user is found
     */
    @Override
    public Optional<User> findByEmailId(String emailId) {
        // return the user by emailId
        logger.info("User with emailId: {} found", emailId);
        return userRepository.findByEmailId(emailId);
    }

    // add the implementation for the findByEmailIdAndPassword method
    /**
     * Finds a user by their email ID and password.
     *
     * @param emailId  The email ID of the user.
     * @param password The password of the user.
     * @return An Optional containing the user if found, otherwise an empty
     *         Optional.
     */
    @Override
    public Optional<User> findByEmailIdAndPassword(String emailId, String password) {
        // return the user by emailId and password
        logger.info("User with emailId: {} and password found", emailId);
        return userRepository.findByEmailIdAndPassword(emailId, password);
    }
}
