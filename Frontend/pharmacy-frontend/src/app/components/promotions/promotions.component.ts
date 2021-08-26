import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { off } from 'process';
import { CreatePromotion } from 'src/app/model/promotion/create-promotion';
import { PromotionService } from 'src/app/services/promotion-service/promotion.service';

@Component({
  selector: 'app-promotions',
  templateUrl: './promotions.component.html',
  styleUrls: ['./promotions.component.css']
})
export class PromotionsComponent implements OnInit {

  minDateForm: Date;
  minDate: Date;
  maxDate: Date;
  description: String;
  promotionForm: FormGroup;
  createPromotion: CreatePromotion;
  isDateRangeValid: boolean;
  constructor(private fb: FormBuilder, private promotionService: PromotionService) { }

  ngOnInit(): void {
    this.initialState();
    this.promotionForm = this.fb.group({
      minDateInput: [new Date(), Validators.required],
      maxDateInput: new Date(),
      description: ['', Validators.required]
    })

    this.promotionForm.valueChanges.subscribe(data => {
      this.minDate = data.minDateInput;
      this.maxDate = data.maxDateInput;
      this.description = data.description;
      this.validateDateRange();
    })
    
  }

  submit() {
    this.formatDate();
    this.createPromotion = new CreatePromotion(this.description, this.minDate, this.maxDate);
    console.log(this.createPromotion);
    this.promotionService.create(this.createPromotion).subscribe(
      success => {
        this.promotionForm.reset();
        this.initialState();
        console.log("Success");
      }
    )
    
  }

  formatDate() {
    let offset = 7200000;
    let startMillis = this.minDate.getTime();
    startMillis = startMillis + offset;
    this.minDate = new Date(startMillis);
    

    let endMillis = this.maxDate.getTime();
    endMillis = endMillis + offset;
    this.maxDate = new Date(endMillis);
    console.log(this.maxDate);
  }
  
  initialState() {
    this.isDateRangeValid = false;
    this.minDateForm = new Date();
    this.minDate = new Date();
    this.maxDate = new Date();
    this.description = "";
  }

  validateDateRange() {
    
    if(this.minDate >= this.maxDate) {
      console.log(this.isDateRangeValid)
      this.isDateRangeValid = false;
      
    } else {
    this.isDateRangeValid = true;
    }
  }
}
