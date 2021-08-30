import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Order } from 'src/app/model/order/order';
import { OrderStatus } from 'src/app/model/order/status';
import { OrderService } from 'src/app/services/order-service/order.service';
import { OffersDialogComponent } from './offers-dialog/offers-dialog.component';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  filters: String[] = [OrderStatus.Accepted, OrderStatus.Pending, OrderStatus.Rejected]
  orders: Order[] = [];

  selectedFilter: OrderStatus;

  displayedColumns: string[] = ['createdBy', 'createdAt', 'dueDate', 'status', 'showOffers'];

  constructor(private orderService: OrderService, private dialog: MatDialog) { }

  ngOnInit(): void {
    console.log(this.selectedFilter);
    this.findAll()
  }

  findAll() {
    this.orderService.findAll().subscribe(
      data => {
        this.orders = data;
      }
    )
  }

  filter() {
    if(this.selectedFilter === undefined) return;
    this.orderService.filter(this.selectedFilter).subscribe(
      data => {
        this.orders = data;
      },
      error => {

      }
    )
  }

  reset() {
    this.orderService.findAll().subscribe(
      data => {
        this.orders = data;
      },
      error => {
        
      }
    )
  }

  openOffersDialog(orderId: number) {
    this.dialog.open(OffersDialogComponent, {
      width: 'fit-content',
      minWidth:'35vw',
      height: 'fit-content',
      maxHeight: '50vw',
      data: orderId,
    })
  }

}
