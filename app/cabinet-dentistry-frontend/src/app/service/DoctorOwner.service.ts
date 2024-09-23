import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Observable} from 'rxjs';

import { catchError, throwError } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';
import {DoctorOwner} from "../shared/models/DoctorOwner";





@Injectable({
  providedIn: 'root'
})


export class DoctroOwnerService {

  private serverUrl = `http://localhost:8080/doctor-owner`;


  private authorization = this.cookieService.get('Authorization');

  constructor(private httpClient: HttpClient, private cookieService: CookieService) {
  }

/*  public createClient(clientRegisterRequest: DoctorOwnerRegistrationRequest): Observable<DoctorOwnerRegistrationRequest> {
    const headers = {
      'Authorization': `${this.authorization}`
    };
    const dataUrl = `${this.serverUrl}/register`;
    return this.httpClient.post<DoctorOwnerRegistrationRequest>(dataUrl, clientRegisterRequest, {headers})
      .pipe(catchError(this.handleError));
  }

 */


  public getDoctorOwner(id: number): Observable<DoctorOwner> {
    const headers = {
      'Authorization': `${this.authorization}`
    };
    const dataUrl = `${this.serverUrl}/${id}`;
    return this.httpClient.get<DoctorOwner>(dataUrl, {headers}).pipe(catchError(this.handleError));
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



}
