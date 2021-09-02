import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employment } from 'src/app/model/employment/employment';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmploymentServiceService {

  constructor(private http: HttpClient) { }

  employ(employment: Employment) {
    return this.http.post(`${environment.baseUrl}/${environment.employment}/${environment.dermatologist}`, employment);
  }
}
