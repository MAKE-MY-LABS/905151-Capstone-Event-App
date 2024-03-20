package com.capstone.eventapp.repository;

import java.util.Optional;

// create interface UserRepository which extends MongoRepository
// use User model class and String as the type of the primary key
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capstone.eventapp.model.User;

/**
 * This interface represents a repository for managing User objects in the database.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    /**
     * Finds a user by their emailId.
     *
     * @param emailId the emailId of the user to find
     * @return an Optional containing the user if found, or an empty Optional if not found
     */
    public Optional<User> findByEmailId(String emailId);

    /**
     * Finds a user by their emailId and password.
     *
     * @param emailId  the emailId of the user to find
     * @param password the password of the user to find
     * @return an Optional containing the user if found, or an empty Optional if not found
     */
    public Optional<User> findByEmailIdAndPassword(String emailId, String password);

}



