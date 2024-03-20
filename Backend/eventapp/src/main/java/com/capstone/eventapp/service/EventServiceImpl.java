package com.capstone.eventapp.service;

// create EventServiceImpl class and implement EventService interface and add the implementation for the methods. 
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capstone.eventapp.model.Event;
import com.capstone.eventapp.model.EventList;
import com.capstone.eventapp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Value;

/**
 * This class implements the EventService interface and provides the
 * implementation for various event-related operations.
 * It interacts with the EventRepository and external API to perform CRUD
 * operations on events.
 */
@Service
public class EventServiceImpl implements EventService {

    private static final Logger logger = LogManager.getLogger(EventServiceImpl.class);
    // autowire the EventRepository
    @Autowired
    private EventRepository eventRepository;

    @Value("${API_URL}")
    private String apiUrl;

    @Value("${CLIENT_ID}")
    private String clientId;

    @Value("${SECRET_KEY}")
    private String secretKey;

    // add the implementation for the findAllEvents method
    /**
     * Retrieves a list of events.
     *
     * @return The list of events.
     */
    @Override
    public EventList findAllEvents() {
        logger.info("Find All Events");
        // return all the events
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "?client_id=" + clientId + "&client_secret=" + secretKey;
        EventList events = restTemplate.getForObject(url, EventList.class);
        return events;
    }

    // add the implementation for the findEventById method
    /**
     * Finds an event by its ID.
     *
     * @param eventId the ID of the event to find
     * @return the event with the specified ID, or null if not found
     */
    @Override
    public Event findEventById(String eventId) {
        logger.info("Find Events Event by EventId: {}", eventId);
        // return the event by eventId
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "/" + eventId + "?client_id=" + clientId + "&client_secret=" + secretKey;

        Event event = restTemplate.getForObject(url, Event.class);
        return event;
    }

    // add the implementation for the saveFavoriteEvent method
    /**
     * Saves a favorite event.
     *
     * @param event The event to be saved.
     * @return The saved event.
     */
    @Override

    public Event saveFavoriteEvent(Event event) {
        logger.info("Save Favorite Event: {}", event.getId());
        // save the favorite event
        return eventRepository.save(event);
    }

    // add the implementation for the findAllFavoriteEvents method
    /**
     * Retrieves a list of favorite events.
     *
     * @return An instance of EventList containing all the favorite events.
     */
    @Override
    public EventList findAllFavoriteEvents() {
        logger.info("Find All Favorite Events");
        // return all the favorite events
        List<Event> events = eventRepository.findAll();
        EventList eventList = new EventList();
        eventList.setEvents(events);
        return eventList;
    }

    // add the implementation for the deleteFavoriteEvent method
    /**
     * Deletes a favorite event.
     *
     * @param eventId the ID of the event to be deleted
     */
    public void deleteFavoriteEvent(String eventId) {
        logger.info("Delete Favorite Event: {}", eventId);
        // delete the favorite event
        eventRepository.deleteById(eventId);
    }

}
