import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DermatologistHomepageComponent } from './dermatologist_homepage/dermatologist-homepage.component';
import { DrugComponent } from './components/drug/drug/drug.component';
import { MoreInfoDialogComponent } from './components/drug/more-info-dialog/more-info-dialog/more-info-dialog.component';
import { PharmacyProfileComponent } from './components/pharmacy-profile/pharmacy-profile/pharmacy-profile.component';
import { PredefinedExaminationComponent } from './components/predefined-examination/predefined-examination/predefined-examination.component';
import { StateInputComponent } from './components/state-input/state-input/state-input.component';
import { DermatologistsComponent } from './components/dermatologists/dermatologists.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';

const routes: Routes = [
  {
    path: 'pharmacyProfile',
    component: PharmacyProfileComponent
  },
  {
    path: 'states',
    component: StateInputComponent
  },
  {
    path: 'predefinedExamination',
    component: PredefinedExaminationComponent
  },
  {
    path: 'drugs',
    component: DrugComponent
  },
  {
    path: 'dialogProba',
    component: MoreInfoDialogComponent
  },
  {
    path: 'dermatologist_profile', 
    component: DermatologistHomepageComponent,
  },
  {
    path: 'dermatologists',
    component: DermatologistsComponent
  },
  {
    path: 'userProfile',
    component: UserProfileComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
