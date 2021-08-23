import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SearchDermatologist } from 'src/app/model/search-dermatologist/search-dermatologist';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DermatologistServiceService {

  constructor(private http: HttpClient) { }

  searchDermatologists(name: String, surname: String): Observable<SearchDermatologist[]> {
    console.log("Usau u servis")
    return this.http.get<SearchDermatologist[]>(`${environment.baseUrl}/${environment.dermatologist}/${name}/${surname}`);
  }

  findAll() : Observable<SearchDermatologist[]> {
    return this.http.get<SearchDermatologist[]>(`${environment.baseUrl}/${environment.dermatologist}`);
  }


}
