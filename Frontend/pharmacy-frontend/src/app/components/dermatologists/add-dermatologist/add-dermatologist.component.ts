import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Employment } from 'src/app/model/employment/employment';
import { SearchDermatologist } from 'src/app/model/search-dermatologist/search-dermatologist';
import { Shift } from 'src/app/model/shift/shift';
import { DermatologistServiceService } from 'src/app/services/dermatologist-service/dermatologist-service.service';
import { EmploymentServiceService } from 'src/app/services/employment-service/employment-service.service';

@Component({
  selector: 'app-add-dermatologist',
  templateUrl: './add-dermatologist.component.html',
  styleUrls: ['./add-dermatologist.component.css']
})
export class AddDermatologistComponent implements OnInit {

  start = {hour: 7, minute: 0};
  end = {hour: 15, minute: 0};
  dateStart: Date = new Date();
  dateEnd: Date = new Date();

  employment: Employment;

  dermatologistId: number;
  dermatologists: SearchDermatologist[];

  shifts: Shift[] = [];

  addDermatologistForm: FormGroup;

  constructor(private dermatologistService: DermatologistServiceService, private fb: FormBuilder, private employmentSevice: EmploymentServiceService) { }

  ngOnInit(): void {
    this.addDermatologistForm = this.fb.group({
      dermatologistId: '',
      startDate: Date.now(),
      endDate: Date.now(),
      shiftDuration: '',
      shiftStart: {hour: 7, minute: 0},
      shiftEnd: {hour: 15, minute: 0}
    })
    this.addDermatologistForm.valueChanges.subscribe(data => {
      this.dateStart = data.startDate;
      this.dateEnd = data.endDate;
      this.start = data.shiftStart;
      this.end = data.shiftEnd;
      this.dermatologistId = data.dermatologistId;
    })
    this.getAllDermatologists();
  }

  getAllDermatologists() {
    this.dermatologistService.findAll().subscribe(
      data => {
        this.dermatologists = data;
        console.log(data);
      }
    )
  }

  confirm() {
    this.generateShifts(this.dateStart, this.dateEnd);
    this.employment = new Employment(this.dermatologistId, this.shifts);
    this.employmentSevice.employ(this.employment).subscribe(
      success => {
        this.shifts = []
        console.log(success);
      },
      error => {
        console.log(error);
      }
    )
    
  }

  generateShifts(start: Date, end: Date) {
    for(var dt=new Date(start); dt<=end; dt.setDate(dt.getDate()+1)){
      let dateStart = new Date(dt);
      dateStart.setHours(this.start.hour);
      dateStart.setMinutes(this.start.minute);
      dateStart = this.formatDate(dateStart);

      let dateEnd = new Date(dt);
      dateEnd.setHours(this.end.hour);
      dateEnd.setMinutes(this.end.minute);
      dateEnd = this.formatDate(dateEnd);
      let shift = new Shift(dateStart, dateEnd, 1, this.dermatologistId);
      this.shifts.push(shift)
    }
  }

  formatDate(date: Date) : Date {
    let offset = 7200000;
    let dateMillis = date.getTime();
    dateMillis = dateMillis + offset;

    return new Date(dateMillis);
    
  }
}

