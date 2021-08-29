import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CreateOrder } from 'src/app/model/order/create-order';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  createOrder(order: CreateOrder) : Observable<String>{
    console.log("Usao u servis  ")
    return this.http.post<String>(`${environment.baseUrl}/${environment.order}`, order);
  }
 }
