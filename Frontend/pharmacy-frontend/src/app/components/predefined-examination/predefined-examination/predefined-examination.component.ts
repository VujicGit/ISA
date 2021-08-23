import { Time } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { PredefinedExamination } from 'src/app/model/predefined-examination/predefined-examination';

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
  options: Dermatologist[] = [{id: 1234, name: "Pera"}]
  predefinedExamination: PredefinedExamination
  periods: Period[] = [{start: {hours: 20, minutes:0}, end: {hours: 21, minutes: 0}}]


  dermatologistId: String
  price: number
  date: Date
  startHours: number
  startMinutes: number
  endHours: number
  endMinutes: number
  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {

    this.predefinedExaminationForm = this.fb.group({
      dermatologistId: '',
      price: '',
      date: '',
      time: ''
    })

    this.predefinedExaminationForm.valueChanges.subscribe(a => {
      this.dermatologistId = a.dermatologistId;
      this.price = a.price;
      this.date = a.date;
      console.log(a.time)
      if (a.time != '') {
        this.startHours = a.time.start.hours;
        this.startMinutes = a.time.start.minutes;
        this.endHours = a.time.end.hours;
        this.endMinutes = a.time.end.minutes;
      }
      
    })
  }

  confirm() {
    let startDate = new Date(
      this.date.getFullYear(), 
      this.date.getMonth(), 
      this.date.getDate(), 
      this.startHours, 
      this.startMinutes)
    
    let endDate = new Date(
      this.date.getFullYear(),
      this.date.getMonth(),
      this.date.getDate(),
      this.endHours,
      this.endMinutes
    )
    
    this.predefinedExamination = new PredefinedExamination(
      this.dermatologistId, 
      this.price,
      startDate,
      endDate
      )
    
    console.log(this.predefinedExamination)
  }

}
