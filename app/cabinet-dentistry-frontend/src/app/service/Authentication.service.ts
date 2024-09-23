import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import jwt_decode from 'jwt-decode';
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private readonly PATH_OF_API = 'http://localhost:8080/auth/authenticate';
  private readonly requestHeader = new HttpHeaders({ 'No-Auth': 'True' });

  constructor(
    private router: Router,
    private cookieService: CookieService,
    private httpclient: HttpClient
  ) {}

  public login(loginData: any) {
    return this.httpclient.post(this.PATH_OF_API, loginData, {
      headers: this.requestHeader,
    });
  }

  public getRole(): string | null {
    const token = this.getToken();
    if (token) {
      try {
        const decodedToken: any = jwt_decode(token);
        console.log('Decoded Token:', decodedToken); // Debugging log
        return decodedToken ? decodedToken.role : null;
      } catch (error) {
        console.error('Token decoding failed:', error);
        return null;
      }
    }
    return null;
  }

  isAuthenticated(): boolean {
    const token = this.getToken();
    if (!token) {
      return false;
    }

    try {
      const decodedToken: any = jwt_decode(token);
      const currentTime = Math.floor(new Date().getTime() / 1000);
      // Vérifie si le token est expiré
      if (decodedToken.exp < currentTime) {
        return false;
      }
      return true;
    } catch (error) {
      console.error('Token decoding failed:', error);
      return false;
    }
  }


  public getToken(): string {
    const token = this.cookieService.get('Authorization');
    console.log('Token:', token); // Debugging log
    return token;
  }

  logout() {
    // Supprimer le cookie qui contient le token
    this.cookieService.delete('Authorization', '/');
    // Rediriger l'utilisateur vers la page de login
    this.router.navigate(['/mohamed_hnid_cabinet']);
  }

}
