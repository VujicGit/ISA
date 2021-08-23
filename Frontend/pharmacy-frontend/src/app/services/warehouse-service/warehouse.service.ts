import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Drug } from 'src/app/model/drug/drug';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class WarehouseService {

  constructor(private http: HttpClient) { }

  getItems() : Observable<Drug[]> {
    return this.http.get<Drug[]>(`${environment.baseUrl}/${environment.warehouse}/${environment.items}`);
  }

  deleteDrug(drugCode: String) {
    return this.http.delete(`${environment.baseUrl}/${environment.warehouse}/${drugCode}`);
  }

  search(drugCode: String) : Observable<Drug[]>{
    return this.http.get<Drug[]>(`${environment.baseUrl}/${environment.search}/${drugCode}`)
  }
}
