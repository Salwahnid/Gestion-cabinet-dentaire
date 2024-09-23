import { NgModule } from '@angular/core';
import { CommonModule, } from '@angular/common';
import { BrowserModule  } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';

import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';
import {LoginComponent} from "./pages/login/login.component";
import {SecretaryComponent} from "./features/secretary/secretary.component";
import {HomePageComponent} from "./pages/home-page/home-page.component";
import {SignupComponent} from "./pages/signup/signup/signup.component";

const routes: Routes =[
 {
    path: '',
    redirectTo: 'doctor-owner',
    children: [
      {
        path: '',
        loadChildren: () => import('src/app/features/doctor-owner/doctor-owner.module').then(m => m.DoctorownerModule)
      }
    ]
  }, {
    path: '**',          // Redirection vers la page d'accueil si la route n'existe pas
    redirectTo: 'dashboard'
  },{
    path: '/secretary',
    redirectTo: 'secretary',
    children: [
      {
        path: '',
        loadChildren: () => import('src/app/features/secretary/secretary.module').then(m => m.SecretaryModule)
      }
    ]
  },{
    path: 'mohamed_hnid_cabinet',
    component: HomePageComponent
  }

];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes,{
      useHash: true
    })
  ],
  exports: [
  ],
})
export class AppRoutingModule { }
