package com.capstone.eventapp.repository;

import java.util.Optional;

// create interface UserRepository which extends MongoRepository
// use User model class and String as the type of the primary key
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capstone.eventapp.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // create a method to find user by emailId
    public Optional<User> findByEmailId(String emailId);

    // create a method to check email and password and return optional of user
    public Optional<User> findByEmailIdAndPassword(String emailId, String password);

}



