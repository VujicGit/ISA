import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CreatePromotion } from 'src/app/model/promotion/create-promotion';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PromotionService {

  constructor(private http: HttpClient) { }

  public create(data: CreatePromotion) {
    return this.http.post(`${environment.baseUrl}/${environment.promotion}`, data);
  }
}
