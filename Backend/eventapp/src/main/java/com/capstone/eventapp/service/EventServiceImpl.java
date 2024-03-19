package com.capstone.eventapp.service;

// create EventServiceImpl class and implement EventService interface and add the implementation for the methods. 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capstone.eventapp.model.Event;
import com.capstone.eventapp.model.EventList;
import com.capstone.eventapp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Value;

@Service
public class EventServiceImpl implements EventService {
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
    @Override
    public EventList findAllEvents() {
        // return all the events
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "?client_id=" + clientId + "&client_secret=" + secretKey;
        EventList events = restTemplate.getForObject(url, EventList.class);
        return events;
    }

    // add the implementation for the findEventById method
    @Override
    public Event findEventById(String eventId) {
        // return the event by eventId
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "/" + eventId + "?client_id=" + clientId + "&client_secret=" + secretKey;

        Event event = restTemplate.getForObject(url, Event.class);
        return event;
    }

    // add the implementation for the saveFavoriteEvent method
    @Override

    public Event saveFavoriteEvent(Event event) {
        // save the favorite event
        return eventRepository.save(event);
    }

    // add the implementation for the findAllFavoriteEvents method
    @Override
    public EventList findAllFavoriteEvents() {
        // return all the favorite events
        List<Event> events = eventRepository.findAll();
        EventList eventList = new EventList();
        eventList.setEvents(events);
        return eventList;
    }

    // add the implementation for the deleteFavoriteEvent method
    @Override
    public void deleteFavoriteEvent(String eventId) {
        // delete the favorite event
        eventRepository.deleteById(eventId);
    }

}
