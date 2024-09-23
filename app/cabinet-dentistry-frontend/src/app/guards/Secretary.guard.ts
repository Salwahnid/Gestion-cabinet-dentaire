// Secretary.guard.ts
import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class SecretaryGuard implements CanActivate {


  constructor(private authService: AuthenticationService , private router: Router) {}

  canActivate(): boolean {
    if (this.authService.isAuthenticated() && this.authService.getRole() == "ROLE_SECRETARY") {
      return true;
    } else {
      this.router.navigate(['/login']); // Redirigez vers la page de connexion si l'utilisateur n'est pas administrateur
      return false;
    }
  }
}
