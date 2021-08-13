import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DermatologistHomepageComponent } from './dermatologist_homepage/dermatologist-homepage.component';
import { CalendarComponent } from './calendar/calendar/calendar.component';
import { DermatologistReportComponent } from './dermatologist-report/dermatologist-report.component';

const routes: Routes = [

  {  path: 'derm-homepage', component: DermatologistHomepageComponent,
 
  children:[
    {path: 'derm-calendar', component: CalendarComponent},
    {path: 'derm-report', component: DermatologistReportComponent},
  ],
  }

]


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
