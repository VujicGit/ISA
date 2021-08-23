import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Allergy } from 'src/app/model/drug/allergy';
import { Drug } from 'src/app/model/drug/drug';
import { Ingredient } from 'src/app/model/drug/ingredient';
import { WarehouseService } from 'src/app/services/warehouse-service/warehouse.service';
import { MoreInfoDialogComponent } from '../more-info-dialog/more-info-dialog/more-info-dialog.component';

@Component({
  selector: 'app-drug',
  templateUrl: './drug.component.html',
  styleUrls: ['./drug.component.css']
})
export class DrugComponent implements OnInit {

  drugs: Drug[];
  displayedColumns: String[] = ["Name", "Manufacturer", "Quantity", "showMore", "remove"]
  constructor(private dialog: MatDialog, private warehouseService: WarehouseService) { }

  ngOnInit(): void {
    //call a service
    this.warehouseService.getItems().subscribe(

      data => {
        this.drugs = data;
      },
      err => {
        console.log(err);
      }
    )

  }

  showMore(element: Drug) {
    const dialog = this.dialog.open(MoreInfoDialogComponent, {
      width: 'fit-content',
      minWidth:'35vw',
      height: 'fit-content',
      maxHeight: '50vw',
      data: element
    })
  }

  deleteDrug(drugCode: String) {
    this.warehouseService.deleteDrug(drugCode).subscribe(
      success => {
        this.updateElements(drugCode);
      },
      error => {
        alert("Error");
      }
    )
  }

  updateElements(drugCode: String) {
    this.drugs = this.drugs.filter(item => item.code !== drugCode);
  }

  search() {
    this.warehouseService.search("M01AE01").subscribe(
      data => {
        this.drugs = data;
      }
    )
  }
}
