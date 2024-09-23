import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {LayoutComponent} from "./layout.component";
import {CustomerHistoryComponent} from "./components/customer-history/customer-history.component";
import {UserProfileComponent} from "../../pagesToDelete/user-profile/user-profile.component";
import {BankTransactionsComponent} from "./components/bank-transactions/bank-transactions.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {StatisticComponent} from "./components/statistic/statistic.component";
import {DoctorOwnerGuard} from "../../guards/DoctorOwnerGuard";
import {StaffComponent} from "./components/staff/staff.component";
import {EditPatientComponent} from "./components/edit-patient/edit-patient.component";
import {PatientDetailsComponent} from "./components/patient-details/patient-details.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'doctor-owner/dashboard',
    pathMatch: 'full',
  },
  {
    path: 'doctor-owner',
    component: LayoutComponent,
    canActivate: [DoctorOwnerGuard],

    children: [
      {
        path: '',
        redirectTo: 'dashboard',
        pathMatch: 'full'},
      { path: 'dashboard', component: DashboardComponent},
      { path: 'customer_history', component: CustomerHistoryComponent},
      { path: 'bank-transactions', component: BankTransactionsComponent},
      { path: 'profile', component: ProfileComponent},
      { path: 'statistic', component: StatisticComponent},
      { path: 'staff', component: StaffComponent },
      { path: 'edit-patient', component: EditPatientComponent },
      { path: 'patient-details/:id', component: PatientDetailsComponent },
    ]
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DoctorOwnerRoutingModule { }
