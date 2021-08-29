import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatTable } from '@angular/material/table';
import { deepStrictEqual } from 'assert';
import { Drug } from 'src/app/model/drug/drug';
import { Price } from 'src/app/model/pricelist/price';
import { UpdatePrice } from 'src/app/model/pricelist/update-price';
import { PricelistService } from 'src/app/services/pricelist-service/pricelist.service';
import { WarehouseService } from 'src/app/services/warehouse-service/warehouse.service';

@Component({
  selector: 'app-pricelist',
  templateUrl: './pricelist.component.html',
  styleUrls: ['./pricelist.component.css']
})
export class PricelistComponent implements OnInit {

  selected = 'option2';
  minDate: Date = new Date();

  drugs: Drug[];
  drugId: number;
  price: number;
  startDate: Date = new Date();
  endDate: Date = new Date();

  isValid: boolean = false;

  prices: Price[];

  displayedColumns: String[] = ["drugName", "drugCode", "price", "startPeriod", "endPeriod"];

  pricelistForm: FormGroup;

  @ViewChild(MatTable) table: MatTable<Price>;
  constructor(private pricelistService: PricelistService, private warehouseService: WarehouseService, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.getItems();
    this.getPricelist();
    this.pricelistForm = this.fb.group({
      drugId: '',
      price: ['',[
        Validators.min(1),
        Validators.required,
        Validators.pattern('[0-9]+')
      ]],
      startDate: [new Date(), [
        Validators.required
      ]],
      endDate: [new Date(), [
        Validators.required
      ]]
    })

    this.pricelistForm.valueChanges.subscribe(data => {
      this.validate();
      this.drugId = data.drugId;
      this.price = data.price;
      this.startDate = data.startDate;
      this.endDate = data.endDate;
      
    })
    
  }


  getItems() {
    this.warehouseService.getItems().subscribe(
      data => {
        this.drugs = data;
      }
    )
  }

  getPricelist() {
    this.pricelistService.getPricelist().subscribe(
      data => {
        this.prices = data;
      }
    )
  }

  updatePrice() {
  

    let price = Number(this.price);
    this.formatDate();
    let updatePrice = new UpdatePrice(this.drugId, price, this.startDate, this.endDate);
    this.pricelistService.updatePrice(updatePrice).subscribe(
      success => {
        let drugName = this.getDrugName(this.drugId);
        let drugCode = this.getDrugCode(this.drugId);
        let price = new Price(drugName, drugCode, this.drugId, this.price, this.startDate, this.endDate);
        if(!this.exists(price)) {
          
          this.prices.push(price);
        } else {
          this.updateRow(this.drugId, this.price);
        }    
    
        this.table.renderRows();
      }, 
      error => {
        console.log("Usao u error")
      }
    )
    console.log(updatePrice);
    
  }

  getDrugName(drugId: number) : String {
    return this.drugs.find(element => element.drugId === drugId).name;
  }

  getDrugCode(drugId: number) : String {
    return this.drugs.find(element => element.drugId === drugId).code;
  }
  
  validatePriceInput() : boolean {
    return this.pricelistForm.get('price').valid;
  }

  exists(price: Price) : boolean {
    let val = this.prices.some(element => element.equal(price));
    console.log(val);
    return val
  }

  equals() : boolean{
    return false;
  }

  updateRow(drugId: number, price: number) {
    this.prices.forEach(element => {
      if(element.drugId === drugId) element.price = price;
    })
  }

  remove() {
    this.prices.forEach((element, index) => {
      this.prices.splice(index, 1);
    })

    this.table.renderRows();
  }

  validate() {
    if(this.selected !== undefined && this.price !== undefined && this.validatePriceInput()) {
      this.isValid = true;
    } else {
      this.isValid = false;
    }
  }

  formatDate() {
    let offset = 7200000;
    let startMillis = this.startDate.getTime();
    startMillis = startMillis + offset;
    this.startDate = new Date(startMillis);

    let endMillis = this.endDate.getTime();
    endMillis = endMillis + offset;
    this.endDate = new Date(endMillis);
  }
}
