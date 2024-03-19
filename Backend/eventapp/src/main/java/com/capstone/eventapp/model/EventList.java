package com.capstone.eventapp.model;

// create EventList class and add List<Event> events field 
// add @Getter @Setter annotation to generate getters and setters
// * use @NoArgsConstructor and @AllArgsConstructor to generate default and parameterized constructors

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventList {
    private List<Event> events;
}