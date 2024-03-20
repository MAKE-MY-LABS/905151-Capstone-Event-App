package com.capstone.eventapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// create contoller for the event with following methods: findAllEvents, findEventById

// event restcontroller autowire the EventService and use the methods to find all the events and find the event by eventId
//

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.eventapp.model.Event;
import com.capstone.eventapp.model.EventList;
import com.capstone.eventapp.service.EventService;

/**
 * The EventController class is responsible for handling HTTP requests related
 * to events.
 * It provides endpoints for retrieving, saving, and deleting events.
 */
@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    private static final Logger logger = LogManager.getLogger(EventController.class);

    @Autowired
    private EventService eventService;

    /**
     * Retrieves all events.
     *
     * @return ResponseEntity<EventList> containing all events
     */
    @GetMapping("/all")
    public ResponseEntity<EventList> findAllEvents() {
        logger.info("Find All Events");
        return new ResponseEntity<>(eventService.findAllEvents(), HttpStatus.OK);
    }

    /**
     * Retrieves an event by its ID.
     *
     * @param eventId the ID of the event to retrieve
     * @return a ResponseEntity containing the event if found, or an empty body with
     *         a status code of 404 if not found
     */
    @GetMapping("/{eventId}")
    public ResponseEntity<Event> findEventById(@PathVariable String eventId) {
        logger.info("Find Events Event by EventId: {}", eventId);
        return new ResponseEntity<>(eventService.findEventById(eventId), HttpStatus.OK);
    }

    // add the implementation for the findAllFavoriteEvents method save favorite
    // event and delete favorite event

    /**
     * Retrieves all favorite events.
     *
     * @return ResponseEntity<EventList> containing the list of favorite events
     */
    @GetMapping("/all-favorite")
    public ResponseEntity<EventList> findAllFavoriteEvents() {
        logger.info("Find All Favorite Events");
        return new ResponseEntity<>(eventService.findAllFavoriteEvents(), HttpStatus.OK);
    }

    /**
     * Saves a favorite event.
     *
     * @param event The event to be saved as a favorite.
     * @return ResponseEntity containing the saved event and HTTP status OK.
     */
    @PostMapping("/save-favorite")
    public ResponseEntity<Event> saveFavoriteEvent(Event event) {
        logger.info("Save Favorite Event");
        return new ResponseEntity<>(eventService.saveFavoriteEvent(event), HttpStatus.OK);
    }

    /**
     * Deletes a favorite event.
     *
     * @param eventId the ID of the event to be deleted
     * @return a ResponseEntity with the HTTP status code indicating the success of
     *         the operation
     */
    @DeleteMapping("/favorite/{eventId}")
    public ResponseEntity<Void> deleteFavoriteEvent(@PathVariable String eventId) {
        logger.info("Delete Favorite Event");
        eventService.deleteFavoriteEvent(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
