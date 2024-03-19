package com.capstone.eventapp.controller;

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

@RestController
@RequestMapping("/api/v1/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/all")
    public ResponseEntity<EventList> findAllEvents() {
        return new ResponseEntity<>(eventService.findAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<Event> findEventById(@PathVariable String eventId) {
        return new ResponseEntity<>(eventService.findEventById(eventId), HttpStatus.OK);
    }

    // add the implementation for the findAllFavoriteEvents method save favorite
    // event and delete favorite event

    @GetMapping("/all-favorite")
    public ResponseEntity<EventList> findAllFavoriteEvents() {
        return new ResponseEntity<>(eventService.findAllFavoriteEvents(), HttpStatus.OK);
    }

    @PostMapping("/save-favorite")
    public ResponseEntity<Event> saveFavoriteEvent(Event event) {
        return new ResponseEntity<>(eventService.saveFavoriteEvent(event), HttpStatus.OK);
    }

    @DeleteMapping("/favorite/{eventId}")
    public ResponseEntity<Void> deleteFavoriteEvent(@PathVariable String eventId) {
        eventService.deleteFavoriteEvent(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
