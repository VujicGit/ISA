import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Offer } from 'src/app/model/offer/offer';
import { OfferService } from 'src/app/services/offer-service/offer.service';

@Component({
  selector: 'app-offers-dialog',
  templateUrl: './offers-dialog.component.html',
  styleUrls: ['./offers-dialog.component.css']
})
export class OffersDialogComponent implements OnInit {

  dataSource: Offer[] = [];
  displayedColumns: string[] = ['price'];

  constructor(public dialogRef: MatDialogRef<OffersDialogComponent>, private dialog: MatDialog, @Inject(MAT_DIALOG_DATA) private id: number, private offerService: OfferService) { }

  ngOnInit(): void {
    console.log(this.id);
    this.getOffers(this.id);
  }

  getOffers(orderId: number) {
    this.offerService.findAll(orderId).subscribe(
      data => {
        this.dataSource = data;
      }, 
      error => {}
    )
  }

}
