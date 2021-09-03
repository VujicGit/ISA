import { Component, Inject, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatTable } from '@angular/material/table';
import { Offer } from 'src/app/model/offer/offer';
import { OfferService } from 'src/app/services/offer-service/offer.service';

@Component({
  selector: 'app-offers-dialog',
  templateUrl: './offers-dialog.component.html',
  styleUrls: ['./offers-dialog.component.css']
})
export class OffersDialogComponent implements OnInit {

  dataSource: Offer[] = [];
  displayedColumns: string[] = ['price', 'supplier', 'date', 'dueDate', 'status', 'acceptOffer'];

  @ViewChild(MatTable) table: MatTable<Offer>;

  constructor(public dialogRef: MatDialogRef<OffersDialogComponent>, private dialog: MatDialog, @Inject(MAT_DIALOG_DATA) private id: number, private offerService: OfferService) { }

  ngOnInit(): void {
    this.dataSource = [];
    this.getOffers(this.id);
  }

  getOffers(orderId: number) {
    this.offerService.findAll(orderId).subscribe(
      data => {
        this.dataSource = data;
        this.table.renderRows();

      }, 
      error => {}
    )
  }

  confirmOffer(offerId: number) {
    this.offerService.confirmOffer(this.id, offerId).subscribe(
      success => {
        console.log(success);
      }
    )
  }

}
