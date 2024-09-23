import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {CustomerHistoryComponent} from "./components/customer-history/customer-history.component";
import {UserProfileComponent} from "../../pagesToDelete/user-profile/user-profile.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {SecretaryComponent} from "./secretary.component";
import {AddPatientComponent} from "./components/addPatient/add-patient.component";
import {SecretaryGuard} from "../../guards/Secretary.guard";
import {AddAppointmentComponent} from "./components/add-appointment/add-appointment.component";

const routes: Routes = [

  {
    path: 'secretary',  // Route pour le Dashboard
    component: SecretaryComponent,
    canActivate: [SecretaryGuard],
    children: [
      {
        path: '',
        redirectTo: 'dashboard',
        pathMatch: 'full'
      },
      {
        path: 'dashboard',
        component: DashboardComponent
      },
      {
        path: 'customer_history',
        component: CustomerHistoryComponent  // Replace with your actual component
      }, {
        path: 'profile',
        component: ProfileComponent  // Le composant qui doit être rendu pour cette route
      }, {
        path: 'add-patient',
        component: AddPatientComponent  // Le composant qui doit être rendu pour cette route
      }, {
        path: 'add-appointment',
        component: AddAppointmentComponent  // Le composant qui doit être rendu pour cette route
      }
    ]
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SecretaryRoutingModule { }
