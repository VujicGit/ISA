import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { MatTable } from '@angular/material/table';
import { DrugList } from 'src/app/model/drug/drug-list';
import { CreateOrder } from 'src/app/model/order/create-order';
import { OrderedDrug } from 'src/app/model/order/ordered-drug';
import { DrugService } from 'src/app/services/drug-service/drug.service';
import { OrderService } from 'src/app/services/order-service/order.service';


export interface TableData {
  id: number;
  quantity: number;
  name: String;
}

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
  dueDate: Date;
  minDate: Date = new Date();

  dataSource : TableData[] = [];
  displayedColumns: string[] = ['id', 'quantity', '#'];

  isValid: boolean = false;

  createOrderForm: FormGroup;

  @ViewChild(MatTable) table: MatTable<TableData>;
  constructor(private drugService : DrugService, private fb: FormBuilder, private orderService: OrderService) { }

  ngOnInit(): void {
    this.matcher = new ErrorStateMatcher();
    this.matcher.isErrorState;
    this.orderedDrugs = new Array();
    this.getDrugList();

    this.createOrderForm = this.fb.group({
      drugId: '',
      quantityControl: ['', [
        Validators.min(1), 
        Validators.pattern('[0-9]+'),
        Validators.required
      ]],
      dueDate:[new Date()]
    })

    this.createOrderForm.valueChanges.subscribe(data => {
      this.validate();
      this.selectedDrug = data.drugId;
      this.quantity = data.quantityControl;
      this.dueDate = data.dueDate;
    })

  }

  getDrugList() {
    this.drugService.getAllBasic().subscribe(
      data => {
        this.drugs = data;
      }
    );
  }

  addOrderedDrug() {
    let quantity = this.quantity;
    let drugId = this.selectedDrug;
    quantity = Number(quantity);
    let orderedDrug = new OrderedDrug(drugId, quantity);

    if(this.exists(drugId)) { 
      this.updateQuantity(drugId, quantity);
    } else{
      this.orderedDrugs.push(orderedDrug);
      let drugName = this.getDrugName(drugId);
      this.dataSource.push({id: drugId, name: drugName, quantity: quantity});
    }
    
    this.table.renderRows();
  }

  validate() {
    let isQuantityValid = this.validateQuantityInput()
    if(this.selected !== undefined && this.quantity !== undefined && this.validateQuantityInput()) {
      this.isValid = true;
    } else {
      this.isValid = false;
    }
  }

  submitOrder() {
    if(this.orderedDrugs.length === 0) return;

    if(!this.validateDueDate()) return;

    this.formatDate();
    this.order = new CreateOrder(this.orderedDrugs, this.dueDate);
    this.orderService.createOrder(this.order).subscribe(
      success => {
        this.dataSource = [];
        this.orderedDrugs = [];
      },
      error => {
        
      }
    );
    console.log(this.order);
  }

  removeItem(id: number) {
    this.removeItemFromTable(id);
    this.removeItemFromOrderedDrugs(id);
    this.table.renderRows();
  }

  removeItemFromTable(id: number) {
    this.dataSource.forEach((element, index) => {
      if(element.id === id) this.dataSource.splice(index, 1);
    })
  }

  getDrugName(id: number) : String{
    return this.drugs.filter(drug => drug.id === id)[0].name;
  }

  removeItemFromOrderedDrugs(id: number) {
    this.orderedDrugs.forEach((element, index) => {
      if(element.drugId === id) this.orderedDrugs.splice(index, 1);
    })
  }

  exists(id: number) : boolean{
    let val = this.orderedDrugs.some(element => element.drugId === id);
    return val;
  }

  updateQuantity(id: number, quantity: number) {
    this.orderedDrugs.forEach(element => {
      if(element.drugId === id) element.quantity = element.quantity + quantity;
    })

    this.dataSource.forEach(element => {
      if(element.id === id) element.quantity = element.quantity + quantity;
    })
  }

  validateQuantityInput() : boolean {
    let valid = this.createOrderForm.get('quantityControl').valid
    return valid;
  }
  
  validateDueDate() : boolean {
    if(this.dueDate <= new Date()) {
      return false;
    }

    return true;
  }

  formatDate() {
    let offset = 7200000;
    let dateMillis = this.dueDate.getTime();
    dateMillis = dateMillis + offset;

    this.dueDate = new Date(dateMillis);
    
  }
}
