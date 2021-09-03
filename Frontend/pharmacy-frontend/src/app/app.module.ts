import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DermatologistHomepageComponent } from './dermatologist_homepage/dermatologist-homepage.component';
import { PharmacyProfileComponent } from './components/pharmacy-profile/pharmacy-profile/pharmacy-profile.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { StateInputComponent } from './components/state-input/state-input/state-input.component';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { PredefinedExaminationComponent } from './components/predefined-examination/predefined-examination/predefined-examination.component';
import {MatSelectModule} from '@angular/material/select';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {MatButtonModule} from '@angular/material/button';
import { DrugComponent } from './components/drug/drug/drug.component';
import {MatTableModule} from '@angular/material/table';
import { MoreInfoDialogComponent } from './components/drug/more-info-dialog/more-info-dialog/more-info-dialog.component';
import { PharmacistPharmacyAdminComponent } from './components/pharmacist-pharmacy-admin/pharmacist-pharmacy-admin/pharmacist-pharmacy-admin.component';
import { DermatologistsComponent } from './components/dermatologists/dermatologists.component';
import {MatExpansionModule} from '@angular/material/expansion';
import { LoginComponent } from './components/login/login.component';
import { ToastrModule, ToastrService } from 'ngx-toastr';
import { JwtInterceptor } from './security/jwt-interceptor';
import { ErrorInterceptor } from './security/error-interceptor';
import { DatePipe } from '@angular/common';
import { PromotionsComponent } from './components/promotions/promotions.component';
import { CreateOrderComponent } from './components/order/create-order/create-order.component';
import { PricelistComponent } from './components/pricelist/pricelist.component';
import { OrdersComponent } from './components/order/orders/orders.component';
import {MatRadioModule} from '@angular/material/radio';
import { OffersDialogComponent } from './components/order/orders/offers-dialog/offers-dialog.component';
import { AddDermatologistComponent } from './components/dermatologists/add-dermatologist/add-dermatologist.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AgmCoreModule } from '@agm/core';
import { MapComponent } from './components/map/map.component'
@NgModule({
  declarations: [
    AppComponent,
    DermatologistHomepageComponent,
    PharmacyProfileComponent,
    StateInputComponent,
    PredefinedExaminationComponent,
    DrugComponent,
    MoreInfoDialogComponent,
    PharmacistPharmacyAdminComponent,
    DermatologistsComponent,
    LoginComponent,
    PromotionsComponent,
    CreateOrderComponent,
    PricelistComponent,
    OrdersComponent,
    OffersDialogComponent,
    AddDermatologistComponent,
    MapComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
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
    MatTableModule,
    MatExpansionModule,
    MatRadioModule,
    ToastrModule.forRoot(),
    NgbModule,
    AgmCoreModule.forRoot({
      apiKey: "AIzaSyDEmGJYq8-CAS15re0tM_wwF9JOaZwHY3g"
    })
  ],
  providers: [
    MatDatepickerModule,
    MatNativeDateModule,
    {provide : HTTP_INTERCEPTORS, useClass : JwtInterceptor, multi : true},
    {provide : HTTP_INTERCEPTORS, useClass : ErrorInterceptor, multi : true},
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
