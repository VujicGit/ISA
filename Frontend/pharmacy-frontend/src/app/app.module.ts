import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { CommonModule } from '@angular/common';

import { FlatpickrModule } from 'angularx-flatpickr';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import {MatStepperModule} from '@angular/material/stepper';
import { MatInputModule } from '@angular/material/input';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import {MatFormFieldModule} from '@angular/material/form-field';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AngularCalendarYearViewModule } from 'angular-calendar-year-view';
import { AppComponent } from './app.component';
import {MatButtonModule} from '@angular/material/button';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DermatologistHomepageComponent } from './dermatologist_homepage/dermatologist-homepage.component';



import { CalendarComponent } from './calendar/calendar/calendar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { DermatologistReportComponent } from './dermatologist-report/dermatologist-report.component';


@NgModule({
  declarations: [
    AppComponent,
    DermatologistHomepageComponent,
    CalendarComponent,
    DermatologistReportComponent,
  ],
  imports: [
    BrowserModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModalModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatToolbarModule,
    AngularCalendarYearViewModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatStepperModule,
    MatButtonModule,
    FlatpickrModule.forRoot(),
    CalendarModule.forRoot({ provide: DateAdapter, useFactory: adapterFactory }),
    NgbModule
  ],
  schemas:[CUSTOM_ELEMENTS_SCHEMA],
  providers: [],
  bootstrap: [AppComponent],
  exports: [CalendarComponent]
})
export class AppModule { }
