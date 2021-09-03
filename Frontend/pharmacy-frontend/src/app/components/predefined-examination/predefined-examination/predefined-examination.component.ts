import { Time } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { PredefinedExamination } from 'src/app/model/predefined-examination/predefined-examination';
import { SearchDermatologist } from 'src/app/model/search-dermatologist/search-dermatologist';
import { DermatologistServiceService } from 'src/app/services/dermatologist-service/dermatologist-service.service';
import { ExaminationService } from 'src/app/services/examination-service/examination.service';

interface Dermatologist {
  name : String,
  id : number
}

interface Period {
  start: Time,
  end: Time
}
@Component({
  selector: 'app-predefined-examination',
  templateUrl: './predefined-examination.component.html',
  styleUrls: ['./predefined-examination.component.css']
})


export class PredefinedExaminationComponent implements OnInit {

  predefinedExaminationForm : FormGroup;
  options: SearchDermatologist[] = [];
  predefinedExamination: PredefinedExamination;
  start = {hour: 7, minute: 0};
  


  dermatologistId: number
  price: number
  date: Date
  startHours: number
  startMinutes: number
  endHours: number
  endMinutes: number
  duration: number;
  constructor(private fb: FormBuilder, private examinationService: ExaminationService, private dermatologistService: DermatologistServiceService) { }

  ngOnInit(): void {

    this.getDermatologists();

    this.predefinedExaminationForm = this.fb.group({
      dermatologistId: '',
      price: 23,
      date: new Date(),
      time: '',
      examinationStart: this.start,
      duration: ''
    })

    this.predefinedExaminationForm.valueChanges.subscribe(a => {
      this.dermatologistId = a.dermatologistId;
      this.price = Number(a.price);
      this.date = a.date;
      this.start = a.examinationStart;
      this.duration =  Number(a.duration);
      console.log(a);
      
    })
  }

  confirm() {
    let startDate = this.date;
    startDate.setHours(this.start.hour);
    startDate.setMinutes(this.start.minute);
    startDate.setSeconds(0);
    let endMinutes = startDate.getMinutes() + this.duration;
    let endDate = new Date(startDate);
    endDate.setMinutes(endMinutes);

    startDate = this.formatDate(startDate);
    endDate = this.formatDate(endDate);

    console.log(startDate)
    console.log(endDate)

    this.predefinedExamination = new PredefinedExamination(this.dermatologistId, this.price, startDate, endDate);

    this.examinationService.createPredefinedExamination(this.predefinedExamination).subscribe(
      data => {
        console.log(data);
      },
      err => {}
    )
  }

  formatDate(date: Date) : Date {
    let offset = 7200000;
    let dateMillis = date.getTime();
    dateMillis = dateMillis + offset;

    return new Date(dateMillis);
    
  }

  getDermatologists() {
    console.log("Usao u get")
    this.dermatologistService.findAllForAdmin().subscribe(
      data => {
        this.options = data;
      }
    )
  }

}
