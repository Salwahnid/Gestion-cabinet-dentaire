import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {CommonModule} from "@angular/common";
import { NgbCollapseModule } from '@ng-bootstrap/ng-bootstrap';
import {SidebarComponent} from "./components/sidebar/sidebar.component";
import {FooterComponent} from "./components/footer/footer.component";
import {NavbarComponent} from "./components/navbar/navbar.component";
import { ProfileComponent } from './components/profile/profile.component';
import {CustomerHistoryComponent} from "./components/customer-history/customer-history.component";
import {SecretaryRoutingModule} from "./secretary-routing.module";
import {AddPatientComponent} from "./components/addPatient/add-patient.component";
import {FormsModule} from "@angular/forms";
import {EditPatientComponent} from "./components/edit-patient/edit-patient.component";
import { AddAppointmentComponent } from './components/add-appointment/add-appointment.component';




@NgModule({
  declarations: [ //les composants on les declare ici
    DashboardComponent,
    SidebarComponent,
    NavbarComponent,
    FooterComponent,
    CustomerHistoryComponent,
    ProfileComponent,
    AddPatientComponent,
    EditPatientComponent,
    AddAppointmentComponent


  ],
  imports: [ //Contient une liste de modules externes dont ce module dépend.
    CommonModule,
    NgbCollapseModule,
    SecretaryRoutingModule,
    FormsModule

  ],

  exports: [
    SidebarComponent,
    NavbarComponent,
    FooterComponent
  ]
})
export class SecretaryModule { }
