import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MapService {

  constructor(private http: HttpClient) { }

  getResults(latitude: string, longitude: string) : Observable<string> {
    return this.http.get<string>(`https://maps.googleapis.com/maps/api/geocode/json?latlng=${latitude},${longitude}&location_type=ROOFTOP&language=en&types=neighborhood&keylanguage=en&key=AIzaSyAXDwaxkG4DViDlB6zom82wO-7nsoVOo1g`);
  }
}
