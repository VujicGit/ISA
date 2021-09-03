import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { env } from 'process';
import { PredefinedExamination } from 'src/app/model/predefined-examination/predefined-examination';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ExaminationService {

  constructor(private http: HttpClient) { }

  createPredefinedExamination(predefinedExamination: PredefinedExamination) {
    return this.http.post(`${environment.baseUrl}/${environment.examination}/${environment.define}`, predefinedExamination);
  }
}
