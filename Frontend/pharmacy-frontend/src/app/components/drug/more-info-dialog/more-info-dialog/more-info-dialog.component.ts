import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Drug } from 'src/app/model/drug/drug';
import { Ingredient } from 'src/app/model/drug/ingredient';

@Component({
  selector: 'app-more-info-dialog',
  templateUrl: './more-info-dialog.component.html',
  styleUrls: ['./more-info-dialog.component.css']
})
export class MoreInfoDialogComponent implements OnInit {

  form : FormGroup;

  name: String;
  code: String;
  dailyDose: String;
  manufacturer: String;
  ingredients: Ingredient[]
  ingredientsString: string;

  constructor(private fb: FormBuilder, public dialogRef: MatDialogRef<MoreInfoDialogComponent>, 
    private dialog: MatDialog, @Inject(MAT_DIALOG_DATA) public data: Drug) { }

  ngOnInit(): void {
    this.name = this.data.name;
    this.code = this.data.code;
    this.dailyDose = this.data.dailyDose;
    this.manufacturer = this.data.manufacturer
    this.ingredients = this.data.ingredients;
    this.form = this.fb.group({
      name: this.name,
      code: this.code,
      dailyDose: this.dailyDose,
      manufactuer: this.manufacturer
    })
  }

}
