// craete interface for Ievent using 
// {
//     "id": "6336498",
//     "type": "golf",
//     "datetimeUtc": null,
//     "venue": {
//       "id": "2767",
//       "state": "AZ",
//       "postalCode": null,
//       "address": "500 East Veterans Way",
//       "country": "US",
//       "hasUpcomingEvents": false,
//       "numUpcomingEvents": 0,
//       "city": "Tempe",
//       "slug": "mountain-america-stadium",
//       "extendedAddress": null,
//       "popularity": 0,
//       "metroCode": 0,
//       "capacity": 0,
//       "displayLocation": null
//     },
//     "datetimeTbd": false,
//     "datetimeLocal": null,
//     "timeTbd": false,
//     "shortTitle": null,
//     "visibleUntilUtc": null,
//     "url": "https://seatgeek.com/sparky-s-fairway-tickets/golf/2024-03-17-3-30-am/6336498",
//     "score": 0,
//     "announceDate": null,
//     "createdAt": null,
//     "dateTbd": false,
//     "title": "Sparky's Fairway At Mountain America Stadium",
//     "popularity": 0,
//     "description": "",
//     "status": "normal",
//     "eventPromotion": null,
//     "conditional": false,
//     "enddatetimeUtc": null,
//     "visibleAt": null,
//     "isVisibleOverride": null,
//     "tdcPvoId": 0,
//     "tdcPvId": 0,
//     "open": false
//   }

/**
 * Represents an event.
 */
export interface IEvent {

    id: string;
    type: string;
    datetimeUtc: string;
    venue: {
        id: string;
        state: string;
        postalCode: string;
        address: string;
        country: string;
        hasUpcomingEvents: boolean;
        numUpcomingEvents: number;
        city: string;
        slug: string;
        extendedAddress: string;
        popularity: number;
        metroCode: number;
        capacity: number;
        displayLocation: string;
    };
    datetimeTbd: boolean;
    datetimeLocal: string;
    timeTbd: boolean;
    shortTitle: string;
    visibleUntilUtc: string;
    url: string;
    score: number;
    announceDate: string;
    createdAt: string;
    dateTbd: boolean;

    title: string;
    popularity: number;
    description: string;
    status: string;
    eventPromotion: string;
    conditional: boolean;
    enddatetimeUtc: string;

    visibleAt: string;
    isVisibleOverride: string;
    tdcPvoId: number;
    tdcPvId: number;

    open: boolean;

}