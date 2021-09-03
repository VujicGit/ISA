import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Offer } from 'src/app/model/offer/offer';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OfferService {

  constructor(private http: HttpClient) { }

  findAll(orderId: number) : Observable<Offer[]> {
    return this.http.get<Offer[]>(`${environment.baseUrl}/${environment.offer}/orderId/${orderId}`);
  }

  confirmOffer(orderId: number, offerId: number) {
    return this.http.put(`${environment.baseUrl}/${environment.offer}/${environment.accept}/${orderId}/${offerId}`, null);
  }
}
