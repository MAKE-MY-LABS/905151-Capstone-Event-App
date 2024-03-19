package com.capstone.eventapp.service;

import com.capstone.eventapp.model.Event;
import com.capstone.eventapp.model.EventList;

public interface EventService {

    // craete method to find all events
    public EventList findAllEvents();

    // create method to find event by id
    public Event findEventById(String eventId);

    // create method to save favorite event
    public Event saveFavoriteEvent(Event event);

    // create method to find all favorite events
    public EventList findAllFavoriteEvents();

    // create method to delete favorite event
    public void deleteFavoriteEvent(String eventId);
    

}
