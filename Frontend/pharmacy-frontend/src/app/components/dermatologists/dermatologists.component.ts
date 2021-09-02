import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Pharmacy } from 'src/app/model/pharmacy/pharmacy';
import { SearchDermatologist } from 'src/app/model/search-dermatologist/search-dermatologist';
import { DermatologistServiceService } from 'src/app/services/dermatologist-service/dermatologist-service.service';
import { PharmacyServiceService } from 'src/app/services/pharmacy-service/pharmacy-service.service';


const ELEMENT_DATA: SearchDermatologist[] = [
  {name: "Pera", surname: "Peric", grade: 8.0, pharmacies:[], id: 1},
];

@Component({
  selector: 'app-dermatologists',
  templateUrl: './dermatologists.component.html',
  styleUrls: ['./dermatologists.component.css']
})



export class DermatologistsComponent implements OnInit {

  searchDataForm: FormGroup;
  name: String = ' ';
  surname: String = ' ';
  grade: String;
  pharmacy: String;
  minGrade: number = 0;
  maxGrade: number = 10;
  pharmacies: Pharmacy[] = [];
  constructor(private fb: FormBuilder, private dermatologistService: DermatologistServiceService, private pharmacyService: PharmacyServiceService) { }

  displayedColumns: string[] = ['name', 'surname', 'grade'];
  dataSource: SearchDermatologist[] = []

  ngOnInit(): void {
    this.searchDataForm = this.fb.group({
      name: '',
      surname: '',
      minGrade: [null, [
        Validators.pattern('^([0-9]|10)$'),
        Validators.min(0),
        Validators.max(10),
      ]],
      maxGrade: [null, [
        Validators.pattern('^([0-9]|10)$'),
        Validators.min(0),
        Validators.max(10),
      ]],
      
    })
    this.searchDataForm.valueChanges.subscribe(data => {
      this.name = data.name;
      this.surname = data.surname;
      this.minGrade = data.minGrade;
      this.maxGrade = data.maxGrade;
    
    });

    this.getDermatologists();
    this.getPharmacies();
  
  }

  search() {
    this.dermatologistService.searchDermatologists(this.name, this.surname).subscribe(
      data => {
        this.dataSource = data;
      },
      err => {
        console.log(err);
      }
    )
  }

  getDermatologists() {
    this.dermatologistService.findAll().subscribe(
      data => {
        this.dataSource = data;
      },
      err => {
        console.log("Can not fetch data");
      }
    );
  }

  getPharmacies() {
    this.pharmacyService.findAll().subscribe(
      data => {
        this.pharmacies = data;
        console.log(this.pharmacies);
      }, 
      err => {
        console.log(err);
      }
    
    )
  }

  isAdmin() : boolean {
    return false;
  }
  getPharmacy(pharmacyId: number) {
    console.log(pharmacyId);
  }
}
