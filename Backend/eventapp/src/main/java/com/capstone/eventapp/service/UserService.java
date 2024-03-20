package com.capstone.eventapp.service;

// craete userService interface and add method for save user, find user by emailId, find user by emailId and password and autowired user Repository
import java.util.Optional;

import com.capstone.eventapp.exception.EmailIdAlreadyExistsException;
import com.capstone.eventapp.model.User;

/**
 * The UserService interface provides methods for managing user data.
 */
public interface UserService {

    /**
     * Saves a new user to the system.
     *
     * @param user The user object to be saved.
     * @return The saved user object.
     * @throws EmailIdAlreadyExistsException If the email ID already exists in the system.
     */
    public User saveUser(User user) throws EmailIdAlreadyExistsException;

    /**
     * Finds a user by their email ID.
     *
     * @param emailId The email ID of the user to be found.
     * @return An Optional containing the user object if found, or an empty Optional if not found.
     */
    public Optional<User> findByEmailId(String emailId);

    /**
     * Finds a user by their email ID and password.
     *
     * @param emailId The email ID of the user to be found.
     * @param password The password of the user to be found.
     * @return An Optional containing the user object if found, or an empty Optional if not found.
     */
    public Optional<User> findByEmailIdAndPassword(String emailId, String password);
}

