import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import { catchError, throwError } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';
import {Patient} from "../shared/models/Patient";
import {PatientRegistrationRequest} from "../shared/models/PatientRegistrationRequest";




@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private serverUrl = `http://localhost:8080/patient1`;


  private authorization = this.cookieService.get('Authorization');

  constructor(private httpClient: HttpClient, private cookieService: CookieService) {
  }

  public createPatient(patientRegisterRequest: PatientRegistrationRequest): Observable<PatientRegistrationRequest> {
    const headers = {
      'Authorization': `${this.authorization}`
    };
    const dataUrl = this.serverUrl;
    return this.httpClient.post<PatientRegistrationRequest>(dataUrl, patientRegisterRequest, {headers})
      .pipe(catchError(this.handleError));
  }



  //const dataUrl = `${this.serverUrl}/listByAgent/${idAgent}`;
  //console.log(this.authorization);

  public getAllPatients(): Observable<Patient[]> {


    const dataUrl = this.serverUrl;
    const headers = {
      'Authorization': `${this.authorization}`
    };
    return this.httpClient.get<Patient[]>(dataUrl, {headers}).pipe(catchError(this.handleError));
  }





  public getPatient(id: number): Observable<Patient> {
    const headers = {
      'Authorization': `${this.authorization}`
    };
    const dataUrl = `${this.serverUrl}/${id}`;
    return this.httpClient.get<Patient>(dataUrl, {headers}).pipe(catchError(this.handleError));
  }

  public handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // patient error
      errorMessage = `Error : ${error.error.message}`;
    } else {
      // server error
      errorMessage = `Status : ${error.status} \n Message: ${error.message}`;
    }
    return throwError(errorMessage);
  }

  public deletePatient(id: number): Observable<{}> {

    const headers = {
      'Authorization': `${this.authorization}`
    };
    const dataUrl = `${this.serverUrl}/${id}`;
    return this.httpClient.delete<{}>(dataUrl, {headers}).pipe(catchError(this.handleError));

  }




}
