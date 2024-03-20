package com.capstone.eventapp.repository;

// create interface EventRepository which extends MongoRepository
// use Event model class and String as the type of the primary key

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capstone.eventapp.model.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

}