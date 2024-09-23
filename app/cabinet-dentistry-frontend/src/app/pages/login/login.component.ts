import { Component, OnInit } from '@angular/core';
import { DatePipe } from "@angular/common";
import { FormsModule, NgForm } from "@angular/forms";
import { Router } from "@angular/router";
import { AuthenticationService } from '../../service/authentication.service';
import jwtDecode from "jwt-decode";
import {MyToken} from "../../shared/models/MyToken";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  imports: [
    FormsModule,
    DatePipe
  ],
  standalone: true,
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  email: string = '';
  password: string = '';
  errorMessage: string | null = null;
  test: Date = new Date();

  constructor(private authService: AuthenticationService, private router: Router) { }

  ngOnInit(): void {
  }

  login(loginForm: NgForm) {
    this.email = loginForm.value.email;
    this.authService.login(loginForm.value).subscribe({
      next: (response: any) => {
        const decodedToken = jwtDecode<MyToken>(response.access_token);

        const expirationDate = new Date();
        expirationDate.setTime(expirationDate.getTime() + 24 * 60 * 60 * 1000);
        const expires = `expires=${expirationDate.toUTCString()}`;
        document.cookie = `Authorization=${encodeURIComponent('Bearer ' + response.access_token)}; ${expires}; path=/`;

        console.log(decodedToken.role);
        console.log(decodedToken.isFirstLogin);

        this.redirectUser(decodedToken.role);
      },
      error: (err) => {
        this.errorMessage = "Invalid email or password";
        console.error('Login error:', err);
      }
    });
  }

  private redirectUser(role: string) {
    console.log('Redirecting role:', role); // Ajoutez cette ligne

    switch(role) {
      case 'ROLE_DOCTOR_OWNER':
        this.router.navigate(['/doctor-owner/dashboard']);
        break;
      case 'ROLE_DOCTOR_ASSISTANT':
        this.router.navigate(['/doctor-assistant/dashboard']);
        break;
      case 'ROLE_SECRETARY':
        this.router.navigate(['/secretary/dashboard']);
        break;
      case 'ROLE_PATIENT':
        this.router.navigate(['/patient/dashboard']);
        break;
      default:
        this.router.navigate(['/']);  // Redirection par défaut
        break;
    }
  }
}
