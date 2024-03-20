package com.capstone.eventapp.model;

// create a model class for the Event with following fields  {
//   "type": "mls",
//   "id": 6077353,
//   "datetime_utc": "2023-12-31T09:30:00",
//   "venue": {
//     "state": "MO",
//     "name_v2": "CITYPARK",
//     "postal_code": "63103",
//     "name": "CITYPARK",
//     "links": [],
//     "timezone": "America/Chicago",
//     "url": "https://seatgeek.com/venues/citypark/tickets",
//     "score": 0.87,
//     "location": {
//       "lat": 38.6312,
//       "lon": -90.2105
//     },
//     "address": "2100 Market Street",
//     "country": "US",
//     "has_upcoming_events": true,
//     "num_upcoming_events": 29,
//     "city": "St. Louis",
//     "slug": "citypark",
//     "extended_address": "St. Louis, MO 63103",
//     "id": 223306,
//     "popularity": 0,
//     "access_method": {
//       "method": "QRCODE",
//       "created_at": "2021-10-19T21:09:46Z",
//       "employee_only": false
//     },
//     "metro_code": 609,
//     "capacity": 0,
//     "display_location": "St. Louis, MO"
//   },
//   "datetime_tbd": true,
//   "performers": [
//     {
//       "type": "mls",
//       "name": "St. Louis CITY SC",
//       "image": "https://seatgeek.com/images/performers-landscape/st-louis-city-sc-3-7d3951/793870/51611/huge.jpg",
//       "id": 793870,
//       "images": {
//         "huge": "https://seatgeek.com/images/performers-landscape/st-louis-city-sc-3-7d3951/793870/51611/huge.jpg"
//       },
//       "divisions": [
//         {
//           "taxonomy_id": 1050100,
//           "short_name": "Western",
//           "display_name": "Western Conference",
//           "display_type": "Conference",
//           "division_level": 1,
//           "slug": "western-conference"
//         }
//       ],
//       "has_upcoming_events": true,
//       "primary": true,
//       "stats": {
//         "event_count": 30
//       },
//       "taxonomies": [
//         {
//           "id": 1000000,
//           "name": "sports",
//           "parent_id": null,
//           "document_source": {
//             "source_type": "ELASTIC",
//             "generation_type": "FULL"
//           },
//           "rank": 0,
//           "seo_event_type": "sport"
//         },
//         {
//           "id": 1050000,
//           "name": "soccer",
//           "parent_id": 1000000,
//           "document_source": {
//             "source_type": "ELASTIC",
//             "generation_type": "FULL"
//           },
//           "rank": 0,
//           "seo_event_type": "soccer"
//         },
//         {
//           "id": 1050100,
//           "name": "mls",
//           "parent_id": 1050000,
//           "document_source": {
//             "source_type": "ELASTIC",
//             "generation_type": "FULL"
//           },
//           "rank": 0,
//           "seo_event_type": "mls"
//         }
//       ],
//       "image_attribution": "cjh",
//       "url": "https://seatgeek.com/st-louis-city-sc-3-tickets",
//       "score": 0.78,
//       "slug": "st-louis-city-sc-3",
//       "home_venue_id": 223306,
//       "short_name": "St Louis CITY SC",
//       "num_upcoming_events": 30,
//       "colors": null,
//       "image_license": "cjh",
//       "popularity": 0,
//       "home_team": true,
//       "location": {
//         "lat": 38.6312,
//         "lon": -90.2105
//       },
//       "image_rights_message": ""
//     }
//   ],
//   "is_open": true,
//   "links": [],
//   "datetime_local": "2023-12-31T03:30:00",
//   "time_tbd": true,
//   "short_title": "2024 myCITY+ Membership",
//   "visible_until_utc": "2024-12-31T06:00:00",
//   "stats": {
//     "listing_count": 3,
//     "average_price": 55,
//     "lowest_price_good_deals": null,
//     "lowest_price": 55,
//     "highest_price": 55,
//     "visible_listing_count": 1,
//     "dq_bucket_counts": [
//       0,
//       0,
//       0,
//       0,
//       0,
//       0,
//       0,
//       0
//     ],
//     "median_price": 55,
//     "lowest_sg_base_price": 50,
//     "lowest_sg_base_price_good_deals": null,
//     "ticket_count": 42
//   },
//   "taxonomies": [
//     {
//       "id": 1000000,
//       "name": "sports",
//       "parent_id": null,
//       "rank": 0,
//       "seo_event_type": "sport"
//     },
//     {
//       "id": 1050000,
//       "name": "soccer",
//       "parent_id": 1000000,
//       "rank": 0,
//       "seo_event_type": "soccer"
//     },
//     {
//       "id": 1050100,
//       "name": "mls",
//       "parent_id": 1050000,
//       "rank": 0,
//       "seo_event_type": "mls"
//     }
//   ],
//   "url": "https://seatgeek.com/st-louis-city-sc-3-tickets/mls/2023-12-31-3-30-am/6077353",
//   "score": 0,
//   "announce_date": "2023-01-17T00:00:00",
//   "created_at": "2023-06-28T15:03:44",
//   "date_tbd": true,
//   "title": "2024 myCITY+ Membership",
//   "popularity": 0,
//   "description": "",
//   "status": "normal",
//   "access_method": {
//     "method": "QRCODE",
//     "created_at": "2021-10-19T21:09:46Z",
//     "employee_only": false
//   },
//   "event_promotion": null,
//   "announcements": {},
//   "conditional": false,
//   "enddatetime_utc": "2024-12-31T06:00:00",
//   "visible_at": "2023-09-01T05:00:00Z",
//   "is_visible_override": "UNSET",
//   "tdc_pvo_id": 0,
//   "tdc_pv_id": 0,
//   "is_visible": true,
//   "performer_order": [
//     {
//       "id": 793870,
//       "ordinal": 0
//     }
//   ],
//   "integrated": {
//     "provider_name": "OPEN",
//     "provider_id": "e_rVMFYgD6p0uVg15dBcRdMpNQCLN06r4"
//   },
//   "general_admission": true,
//   "themes": [],
//   "domain_information": []
// }

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
 * Represents an event.
 * This class contains various properties related to an event, such as its type, date and time, venue, and more.
 */
/**
 * Represents an event.
 * 
 * This class contains information about an event, such as its type, date and
 * time, venue, and other details.
 * 
 * @param id                The unique identifier of the event.
 * @param type              The type of the event.
 * @param datetimeUtc       The date and time of the event in UTC format.
 * @param venue             The venue where the event takes place.
 * @param datetimeTbd       A flag indicating whether the date and time of the
 *                          event is to be determined.
 * @param isOpen            A flag indicating whether the event is open.
 * @param datetimeLocal     The date and time of the event in local format.
 * @param timeTbd           A flag indicating whether the time of the event is
 *                          to be determined.
 * @param shortTitle        The short title of the event.
 * @param visibleUntilUtc   The date and time until which the event is visible
 *                          in UTC format.
 * @param url               The URL of the event.
 * @param score             The score of the event.
 * @param announceDate      The date on which the event was announced.
 * @param createdAt         The date and time at which the event was created.
 * @param dateTbd           A flag indicating whether the date of the event is
 *                          to be determined.
 * @param title             The title of the event.
 * @param popularity        The popularity of the event.
 * @param description       The description of the event.
 * @param status            The status of the event.
 * @param eventPromotion    The promotion of the event.
 * @param conditional       A flag indicating whether the event is conditional.
 * @param enddatetimeUtc    The end date and time of the event in UTC format.
 * @param visibleAt         The date and time at which the event is visible.
 * @param isVisibleOverride The override for the visibility of the event.
 * @param tdcPvoId          The TDC PVO ID of the event.
 * @param tdcPvId           The TDC PV ID of the event.
 */
@Document(collection = "Event")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    private String id;
    private String type;
    private String datetimeUtc;
    private Venue venue;
    private boolean datetimeTbd;
    private boolean isOpen;
    private String datetimeLocal;
    private boolean timeTbd;
    private String shortTitle;
    private String visibleUntilUtc;
    private String url;
    private int score;
    private String announceDate;
    private String createdAt;
    private boolean dateTbd;
    private String title;
    private int popularity;
    private String description;
    private String status;
    private String eventPromotion;
    private boolean conditional;
    private String enddatetimeUtc;
    private String visibleAt;
    private String isVisibleOverride;
    private int tdcPvoId;
    private int tdcPvId;
}