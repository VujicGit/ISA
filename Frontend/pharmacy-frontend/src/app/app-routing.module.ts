import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PharmacyProfileComponent } from './components/pharmacy-profile/pharmacy-profile/pharmacy-profile.component';
import { StateInputComponent } from './components/state-input/state-input/state-input.component';

const routes: Routes = [
  {
    path: 'pharmacyProfile',
    component: PharmacyProfileComponent
  },
  {
    path: 'states',
    component: StateInputComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
