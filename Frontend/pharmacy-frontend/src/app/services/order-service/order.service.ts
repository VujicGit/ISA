import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CreateOrder } from 'src/app/model/order/create-order';
import { Order } from 'src/app/model/order/order';
import { OrderStatus } from 'src/app/model/order/status';
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

  findAll() : Observable<Order[]> {
    return this.http.get<Order[]>(`${environment.baseUrl}/${environment.order}`);
  }

  filter(status: OrderStatus) : Observable<Order[]> {
    return this.http.get<Order[]>(`${environment.baseUrl}/${environment.order}/${status}`);
  }
  
 }
