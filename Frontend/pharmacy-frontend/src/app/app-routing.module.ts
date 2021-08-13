import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DermatologistHomepageComponent } from './dermatologist_homepage/dermatologist-homepage.component';
import { CalendarComponent } from './calendar/calendar/calendar.component';

const routes: Routes = [

  {  path: 'dermatologist_profile', component: DermatologistHomepageComponent,
 
  children:[
    {path: 'derm-calendar', component: CalendarComponent},
  ],
  }

]


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
