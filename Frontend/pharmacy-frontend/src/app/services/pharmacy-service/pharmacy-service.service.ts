import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pharmacy } from 'src/app/model/pharmacy/pharmacy';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PharmacyServiceService {

  constructor(private http: HttpClient) { }

  findAll() : Observable<Pharmacy[]> {
    return this.http.get<Pharmacy[]>(`${environment.baseUrl}/${environment.pharmacy}`);
  }
}
