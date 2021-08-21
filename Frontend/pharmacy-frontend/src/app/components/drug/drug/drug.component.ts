import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Allergy } from 'src/app/model/drug/allergy';
import { Drug } from 'src/app/model/drug/drug';
import { Ingredient } from 'src/app/model/drug/ingredient';
import { MoreInfoDialogComponent } from '../more-info-dialog/more-info-dialog/more-info-dialog.component';

@Component({
  selector: 'app-drug',
  templateUrl: './drug.component.html',
  styleUrls: ['./drug.component.css']
})
export class DrugComponent implements OnInit {

  drugs: Drug[];
  displayedColumns: String[] = ["Name", "Manufacturer", "showMore", "remove"]
  constructor(private dialog: MatDialog) { }

  ngOnInit(): void {
    //call a service
    this.drugs  = [new Drug(
      1, "Brufen", "123", "Hemofarm", "Lek za glavobolju", 1, 1, "Dva puta dnevno",
      [new Ingredient(1, "So"), new Ingredient(2, "Biber")], [new Allergy(1, "Alergija na prasinu")])]

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

}
