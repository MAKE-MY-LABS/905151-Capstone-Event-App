import { Component, OnInit } from '@angular/core';
import { IEvent } from 'src/app/models/event.interface';
import { HomeService } from 'src/app/services/home.service';

@Component({
  selector: 'app-favorite-events',
  templateUrl: './favorite-events.component.html',
  styleUrls: ['./favorite-events.component.scss']
})
export class FavoriteEventsComponent implements OnInit {

  selectedEvent: IEvent | null = null;
  favoritEvents: any[] = [];
  constructor(
    // call homeService in constructor
    private homeService: HomeService
  ) { }

  ngOnInit(): void {

    this.getFavoriteEvents();
  }


  // create a function to get favorite events
  getFavoriteEvents() {
    // return this.homeService.getFavoriteEvents();
  }

  // creae method to close event details


  /**
 * Closes the event details.
 */
  closeEventDetails() {
    this.selectedEvent = null;

  }

// create method to show details of event

  /**
   * Shows the details of the selected event.
   * @param event The selected event.
   */
  showEventDetails(event: IEvent) {
    this.selectedEvent = event;
  }

  deleteEvent(event: IEvent){
    
  }




}
