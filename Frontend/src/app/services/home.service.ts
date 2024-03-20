import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NGXLogger } from 'ngx-logger';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private http: HttpClient, private logger: NGXLogger) { }

  private apiUrl: string = environment.apiUrl; // Replace with your actual API URL
  // get all events method using get request
  // * @returns An Observable that emits the all events.

  getAllEvents(): Observable<any> {
    this.logger.info('Getting All Events');
    return this.http.get(`${this.apiUrl}event/all`);
  }

  /**
  * Retrieves the favorite events.
  * @returns An Observable that emits the favorite events.
  */
  getFavoriteEvents(): Observable<any> {
    this.logger.info('Getting Favorite Events');
    return this.http.get(`${this.apiUrl}event/all-favorite`);

  }

  /**
   * Adds a favorite event.
   * @param event - The event to be added as a favorite.
   * @returns An Observable that emits the response from the API.
   */
  addFavoriteEvent(event: any): Observable<any> {
    this.logger.info('Adding Favorite Event:', event);
    return this.http.post(`${this.apiUrl}event/save-favorite`, event);

  }

}
