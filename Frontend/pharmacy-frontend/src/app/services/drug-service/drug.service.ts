import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Drug } from 'src/app/model/drug/drug';
import { DrugList } from 'src/app/model/drug/drug-list';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DrugService {

  constructor(private http: HttpClient) { }

  getAllBasic() : Observable<DrugList[]> {
    return this.http.get<DrugList[]>(`${environment.baseUrl}/${environment.drug}/${environment.basic}`);
  }
}
