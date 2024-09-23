import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import { catchError, throwError } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';
import {SecretaryRegistrationRequest} from "../shared/models/SecretaryRegistrationRequest";
import {Secretary} from "../shared/models/Secretary";





@Injectable({
  providedIn: 'root'
})
export class SecretaryService {

  private serverUrl = `http://localhost:8080/secretary`;


  private authorization = this.cookieService.get('Authorization');

  constructor(private httpClient: HttpClient, private cookieService: CookieService) {
  }

  public createSecretary(clientRegisterRequest: SecretaryRegistrationRequest): Observable<SecretaryRegistrationRequest> {
    const headers = {
      'Authorization': `${this.authorization}`
    };
    const dataUrl = this.serverUrl;
    return this.httpClient.post<SecretaryRegistrationRequest>(dataUrl, clientRegisterRequest, {headers})
      .pipe(catchError(this.handleError));
  }



  public deactiveSecretary(id: number): Observable<{}> {

    const headers = {
      'Authorization': `${this.authorization}`
    };
    const dataUrl = `${this.serverUrl}/delete/${id}`;
    return this.httpClient.delete<{}>(dataUrl, {headers}).pipe(catchError(this.handleError));

  }



  public handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // client error
      errorMessage = `Error : ${error.error.message}`;
    } else {
      // server error
      errorMessage = `Status : ${error.status} \n Message: ${error.message}`;
    }
    return throwError(errorMessage);
  }

  public getSecretary(id: number): Observable<Secretary> {
    const headers = {
      'Authorization': `${this.authorization}`
    };
    const dataUrl = `${this.serverUrl}/${id}`;
    return this.httpClient.get<Secretary>(dataUrl, {headers}).pipe(catchError(this.handleError));
  }





}
