package com.capstone.eventapp.service;

import com.capstone.eventapp.model.Event;
import com.capstone.eventapp.model.EventList;

/**
 * The EventService interface provides methods to interact with events and favorite events.
 */
public interface EventService {

    /**
     * Retrieves all events.
     *
     * @return an EventList object containing all events
     */
    public EventList findAllEvents();

    /**
     * Retrieves an event by its ID.
     *
     * @param eventId the ID of the event to retrieve
     * @return the Event object with the specified ID, or null if not found
     */
    public Event findEventById(String eventId);

    /**
     * Saves a favorite event.
     *
     * @param event the Event object to save as a favorite
     * @return the saved Event object
     */
    public Event saveFavoriteEvent(Event event);

    /**
     * Retrieves all favorite events.
     *
     * @return an EventList object containing all favorite events
     */
    public EventList findAllFavoriteEvents();

    /**
     * Deletes a favorite event by its ID.
     *
     * @param eventId the ID of the favorite event to delete
     */
    public void deleteFavoriteEvent(String eventId);

}
