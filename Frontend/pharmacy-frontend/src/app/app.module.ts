import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PharmacyProfileComponent } from './components/pharmacy-profile/pharmacy-profile/pharmacy-profile.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { StateInputComponent } from './components/state-input/state-input/state-input.component';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import { HttpClientModule } from '@angular/common/http';
import { PredefinedExaminationComponent } from './components/predefined-examination/predefined-examination/predefined-examination.component';
import {MatSelectModule} from '@angular/material/select';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {MatButtonModule} from '@angular/material/button';
import { DrugComponent } from './components/drug/drug/drug.component';
import {MatTableModule} from '@angular/material/table';
import { MoreInfoDialogComponent } from './components/drug/more-info-dialog/more-info-dialog/more-info-dialog.component';
import { PharmacistPharmacyAdminComponent } from './components/pharmacist-pharmacy-admin/pharmacist-pharmacy-admin/pharmacist-pharmacy-admin.component';

@NgModule({
  declarations: [
    AppComponent,
    PharmacyProfileComponent,
    StateInputComponent,
    PredefinedExaminationComponent,
    DrugComponent,
    MoreInfoDialogComponent,
    PharmacistPharmacyAdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatAutocompleteModule,
    HttpClientModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatButtonModule,
    MatTableModule
  ],
  providers: [
    MatDatepickerModule,
    MatNativeDateModule,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
