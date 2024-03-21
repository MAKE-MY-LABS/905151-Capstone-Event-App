package com.capstone.eventapp.controller;

import com.capstone.eventapp.model.Event;
import com.capstone.eventapp.model.EventList;
import com.capstone.eventapp.service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class EventControllerTest {

    @InjectMocks
    private EventController eventController;

    @Mock
    private EventService eventService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAllEvents() {
        EventList eventList = new EventList();
        eventList.setEvents(Collections.emptyList());

        when(eventService.findAllEvents()).thenReturn(eventList);

        ResponseEntity<EventList> response = eventController.findAllEvents();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(eventList, response.getBody());
    }

    @Test
    public void testFindEventById() {
        Event event = new Event();
        event.setId("1");

        when(eventService.findEventById(anyString())).thenReturn(event);

        ResponseEntity<Event> response = eventController.findEventById("1");
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(event, response.getBody());
    }

    @Test
    public void testFindAllFavoriteEvents() {
        EventList eventList = new EventList();
        eventList.setEvents(Collections.emptyList());

        when(eventService.findAllFavoriteEvents()).thenReturn(eventList);

        ResponseEntity<EventList> response = eventController.findAllFavoriteEvents();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(eventList, response.getBody());
    }

    @Test
    public void testSaveFavoriteEvent() {
        Event event = new Event();
        event.setId("1");

        when(eventService.saveFavoriteEvent(any(Event.class))).thenReturn(event);

        ResponseEntity<Event> response = eventController.saveFavoriteEvent(event);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(event, response.getBody());
    }

    @Test
    public void testDeleteFavoriteEvent() {
        ResponseEntity<Void> response = eventController.deleteFavoriteEvent("1");
        assertEquals(200, response.getStatusCodeValue());
    }
}