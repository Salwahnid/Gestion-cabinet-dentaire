import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {CommonModule} from "@angular/common";
import {LayoutComponent} from "./layout.component";
import {DoctorOwnerRoutingModule} from "./doctor-owner-routing.module";
import { NgbCollapseModule } from '@ng-bootstrap/ng-bootstrap';
import {SidebarComponent} from "./components/sidebar/sidebar.component";
import {FooterComponent} from "./components/footer/footer.component";
import {NavbarComponent} from "./components/navbar/navbar.component";
import { StatisticComponent } from './components/statistic/statistic.component';
import { ProfileComponent } from './components/profile/profile.component';
import { BankTransactionsComponent } from './components/bank-transactions/bank-transactions.component';
import {CustomerHistoryComponent} from "./components/customer-history/customer-history.component";
import { StaffComponent } from './components/staff/staff.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { PatientDetailsComponent } from './components/patient-details/patient-details.component';
import {EditPatientComponent} from "./components/edit-patient/edit-patient.component";
import { EditSecretaryComponent } from './components/edit-secretary/edit-secretary.component';




@NgModule({
  declarations: [ //les composants on les declare ici
    DashboardComponent,
    SidebarComponent,
    NavbarComponent,
    FooterComponent,
    LayoutComponent,
    StatisticComponent,
    CustomerHistoryComponent,
    ProfileComponent,
    BankTransactionsComponent,
    StaffComponent,
    PatientDetailsComponent,
    EditPatientComponent,
    EditSecretaryComponent

  ],
    imports: [ //Contient une liste de modules externes dont ce module dépend.
        CommonModule,
        DoctorOwnerRoutingModule,
        NgbCollapseModule,
        FormsModule,
        ReactiveFormsModule

    ],

})
export class DoctorownerModule { }
