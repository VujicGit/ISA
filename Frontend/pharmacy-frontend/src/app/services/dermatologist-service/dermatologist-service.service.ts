import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Filter } from 'src/app/model/filter/filter';
import { SearchDermatologist } from 'src/app/model/search-dermatologist/search-dermatologist';
import { Search } from 'src/app/model/search/search';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DermatologistServiceService {

  constructor(private http: HttpClient) { }

  searchDermatologists(search: Search): Observable<SearchDermatologist[]> {
    return this.http.post<SearchDermatologist[]>(`${environment.baseUrl}/${environment.dermatologist}/${environment.search}`, search);
  }

  findAll() : Observable<SearchDermatologist[]> {
    return this.http.get<SearchDermatologist[]>(`${environment.baseUrl}/${environment.dermatologist}`);
  }

  findAllForAdmin() : Observable<SearchDermatologist[]> {
    return this.http.get<SearchDermatologist[]>(`${environment.baseUrl}/${environment.dermatologist}/${environment.admin}`);
  }

  filterDermatologist(filter: Filter) : Observable<SearchDermatologist[]> {
    return this.http.post<SearchDermatologist[]>(`${environment.baseUrl}/${environment.dermatologist}/${environment.filter}`, filter);
  }

  


}
