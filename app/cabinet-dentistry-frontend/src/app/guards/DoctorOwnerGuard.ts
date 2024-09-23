import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import {AuthenticationService} from "../service/Authentication.service";
import {DoctorownerModule} from "../features/doctor-owner/doctor-owner.module";
import {DoctorOwner} from "../shared/models/DoctorOwner";

@Injectable({
  providedIn: 'root'
})
export class DoctorOwnerGuard implements CanActivate {

  constructor(private authService: AuthenticationService, private router: Router) {}

  canActivate(): boolean {
    // Vérifiez si l'utilisateur est authentifié
    if (this.authService.isAuthenticated() && this.authService.getRole() == "ROLE_DOCTOR_OWNER") {
      return true; // L'accès est autorisé
    } else {
      // Redirigez l'utilisateur vers la page de connexion
      this.router.navigate(['/mohamed_hnid_cabinet']);
      return false; // L'accès est refusé
    }
  }
}
