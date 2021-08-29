import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Price } from 'src/app/model/pricelist/price';
import { UpdatePrice } from 'src/app/model/pricelist/update-price';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PricelistService {

  constructor(private http: HttpClient) { }

  getPricelist() : Observable<Price[]> {
    return this.http.get<Price[]>(`${environment.baseUrl}/${environment.pricelist}`)
  }

  updatePrice(price: UpdatePrice) {
    return this.http.post(`${environment.baseUrl}/${environment.pricelist}`, price);
  } 
}
