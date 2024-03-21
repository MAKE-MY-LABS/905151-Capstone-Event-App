package com.capstone.eventapp.service;

import com.capstone.eventapp.model.Event;
import com.capstone.eventapp.model.EventList;
import com.capstone.eventapp.repository.EventRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class EventServiceImplTest {

    @InjectMocks
    private EventServiceImpl eventService;

    @Mock
    private EventRepository eventRepository;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAllEvents() {
        EventList eventList = new EventList();
        eventList.setEvents(Collections.emptyList());

        when(restTemplate.getForObject(anyString(), any())).thenReturn(eventList);

        EventList found = eventService.findAllEvents();
        assertEquals(eventList, found);
    }

    @Test
    public void testFindEventById() {
        Event event = new Event();
        event.setId("1");

        when(restTemplate.getForObject(anyString(), any())).thenReturn(event);

        Event found = eventService.findEventById("1");
        assertEquals(event, found);
    }

    @Test
    public void testSaveFavoriteEvent() {
        Event event = new Event();
        event.setId("1");

        when(eventRepository.save(any(Event.class))).thenReturn(event);

        Event saved = eventService.saveFavoriteEvent(event);
        assertEquals(event, saved);
    }

    @Test
    public void testFindAllFavoriteEvents() {
        EventList eventList = new EventList();
        eventList.setEvents(Collections.emptyList());

        when(eventRepository.findAll()).thenReturn(Collections.emptyList());

        EventList found = eventService.findAllFavoriteEvents();
        assertEquals(eventList, found);
    }

    @Test
    public void testDeleteFavoriteEvent() {
        eventService.deleteFavoriteEvent("1");
    }
}
