import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app.routing';
import {DoctorownerModule} from "./features/doctor-owner/doctor-owner.module";
import { CookieService } from 'ngx-cookie-service';
import { SecretaryComponent } from './features/secretary/secretary.component';
import { PatientComponent } from './features/patient/patient.component';
import { LoginComponent } from './pages/login/login.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import {SecretaryModule} from "./features/secretary/secretary.module";
import {MatCardModule} from "@angular/material/card";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import { SignupComponent } from './pages/signup/signup/signup.component';
import { LogoutComponent } from './pages/logout/logout.component';
import {ToastrModule} from "ngx-toastr";



@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    RouterModule,
    AppRoutingModule,
    DoctorownerModule,
    SecretaryModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule,
    LoginComponent,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot() // ToastrModule added


  ],
  declarations: [
    AppComponent,
    AuthLayoutComponent,
    SecretaryComponent,
    PatientComponent,
    HomePageComponent,
    SignupComponent,
    LogoutComponent,
  ],
  providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
