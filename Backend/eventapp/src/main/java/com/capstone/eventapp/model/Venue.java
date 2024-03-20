package com.capstone.eventapp.model;


// create a model class for the Venue with following fields  {
    //     "state": "MO",
    //     "postal_code": "63103",
    //     "address": "2100 Market Street",
    //     "country": "US",
    //     "has_upcoming_events": true,
    //     "num_upcoming_events": 29,
    //     "city": "St. Louis",
    //     "slug": "citypark",
    //     "extended_address": "St. Louis, MO 63103",
    //     "id": 223306,
    //     "popularity": 0,
    //     "metro_code": 609,
    //     "capacity": 0,
    //     "display_location": "St. Louis, MO"
    //   }
    
    //     * using lambok @Getter @Setter annotation to generate getters and setters
//  * use @Document annotation to specify the collection name in the database
//  * use @NoArgsConstructor and @AllArgsConstructor to generate default and parameterized constructors

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a venue where events can take place.
 */
@Document(collection = "Venue")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venue {
    @Id
    private String id;
    private String state;
    private String postalCode;
    private String address;
    private String country;
    private boolean hasUpcomingEvents;
    private int numUpcomingEvents;
    private String city;
    private String slug;
    private String extendedAddress;
    private int popularity;
    private int metroCode;
    private int capacity;
    private String displayLocation;
}
