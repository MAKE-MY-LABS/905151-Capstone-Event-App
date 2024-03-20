
import { Component, OnInit } from '@angular/core';
import { NGXLogger } from 'ngx-logger';
import { from } from 'rxjs';
import { IEvent } from 'src/app/models/event.interface';
import { HomeService } from 'src/app/services/home.service';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.scss']
})
export class EventsComponent implements OnInit {

  selectedEvent: IEvent | null = null;
  events: IEvent[] = [];

  constructor(private homeService: HomeService, private logger: NGXLogger) { }

  /**
   * Initializes the component and retrieves the events.
   */
  ngOnInit(): void {
    this.getAllEvents();
  }

  // add method to get all events

  /**
   * Retrieves the latest events from the server.
   */
  getAllEvents() {
    this.homeService.getAllEvents().subscribe((response: { events: IEvent[] }) => {
      this.events = response.events || [];
      this.logger.debug('Event received:', this.events);
    });

  }

  // create method for search event

  /**
   * Searches for events based on the search query.
   * @param query The search query.
   */
  searchEvents(query: string) {
    // this.homeService.searchEvents(query).subscribe((response: { events: IEvent[] }) => {
    //   this.events = response.events || [];
    //   this.logger.debug('Event received:', this.events);
    // }); 
  }

  // create metthod to favorite event

  /**
   * Favorites the selected event.
   */
  favoriteEvent(event: any) {
    this.logger.debug('Adding event to favorites:', event);

    this.homeService.getFavoriteEvents().subscribe((response: IEvent[]) => {
      const favoriteEvent: IEvent[] = response || [];
      event.id = favoriteEvent.length + 1;

      this.homeService.addFavoriteEvent(event).subscribe((response: { event: IEvent }) => {
        // add alert to show success message
        alert('Event added to favorites');
        this.logger.debug('Event added to favorites:', response.event);
      });
    }
    );

  }

  // create method to show details of event

  /**
   * Shows the details of the selected event.
   * @param event The selected event.
   */
  showEventDetails(event: IEvent) {
    this.selectedEvent = event;
  }

  // creae method to close event details

  /**
   * Closes the event details.
   */
  closeEventDetails() {
    this.selectedEvent = null;

  }

}
