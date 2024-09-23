import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { ClipboardModule } from 'ngx-clipboard';

import { AdminLayoutRoutes } from './admin-layout.routing';
import { DashboardComponent } from '../../pagesToDelete/dashboard/dashboard.component';
import { IconsComponent } from '../../pagesToDelete/icons/icons.component';
import { MapsComponent } from '../../pagesToDelete/maps/maps.component';
import { UserProfileComponent } from '../../pagesToDelete/user-profile/user-profile.component';
import { TablesComponent } from '../../pagesToDelete/tables/tables.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {SidebarComponent} from "../../features/doctor-owner/components/sidebar/sidebar.component";
import {NavbarComponent} from "../../features/doctor-owner/components/navbar/navbar.component";
import {FooterComponent} from "../../features/doctor-owner/components/footer/footer.component";
// import { ToastrModule } from 'ngx-toastr';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    HttpClientModule,
    NgbModule,
    ClipboardModule
  ],
  declarations: [
    DashboardComponent,
    UserProfileComponent,
    TablesComponent,
    IconsComponent,
    MapsComponent
  ]
})

export class AdminLayoutModule {}
