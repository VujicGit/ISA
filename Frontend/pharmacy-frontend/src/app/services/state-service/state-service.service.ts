import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { State } from 'src/app/model/state/state';

@Injectable({
  providedIn: 'root'
})
export class StateServiceService {

  constructor(private http : HttpClient) { }

  getStates() : Observable<State[]> {
    return this.http.get<State[]>("https://restcountries.eu/rest/v2/all")
  }
}
