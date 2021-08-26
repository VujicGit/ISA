import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { DrugList } from 'src/app/model/drug/drug-list';
import { CreateOrder } from 'src/app/model/order/create-order';
import { OrderedDrug } from 'src/app/model/order/ordered-drug';
import { DrugService } from 'src/app/services/drug-service/drug.service';

@Component({
  selector: 'app-create-order',
  templateUrl: './create-order.component.html',
  styleUrls: ['./create-order.component.css']
})
export class CreateOrderComponent implements OnInit {

  drugs: DrugList[];
  selected = 'option2';
  matcher: ErrorStateMatcher;
  quantity: number;
  order: CreateOrder;
  orderedDrugs: OrderedDrug[]
  selectedDrug: number;

  isValid: boolean = false;

  createOrderForm: FormGroup;
  constructor(private drugService : DrugService, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.matcher = new ErrorStateMatcher();
    this.matcher.isErrorState;
    this.orderedDrugs = new Array();
    this.getDrugList();

    this.createOrderForm = this.fb.group({
      drugId: '',
      quantityControl: [1, Validators.min(1)]
    })

    this.createOrderForm.valueChanges.subscribe(data => {
      this.validate();
      this.selectedDrug = data.drugId;
      this.quantity = data.quantityControl;
    })

  }

  getDrugList() {
    this.drugService.getAllBasic().subscribe(
      data => {
        this.drugs = data;
        console.log(this.drugs);
      }
    );
  }

  addOrderedDrug() {
    let quantity = this.quantity;
    let drugId = this.selectedDrug;
    let orderedDrug = new OrderedDrug(drugId, quantity);
    this.orderedDrugs.push(orderedDrug);
    console.log(this.orderedDrugs);
  }

  validate() {
    if(this.selected === undefined && this.quantity === undefined) {
      this.isValid = false;
    } else {
      this.isValid = true;
    }
  }

  submitOrder() {
    if(this.orderedDrugs.length === 0) {
      return;
    }
    this.order = new CreateOrder(this.orderedDrugs, new Date());
    console.log(this.order);
  }

}
