import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import { catchError, throwError } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';
import {Appointment} from "../shared/models/Appointment";
import {AppointmentRegistrationRequest} from "../shared/models/AppointmentRegistrationRequest";
import {ActivatedRoute, Router} from "@angular/router";




@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  private serverUrl = `http://localhost:8080/appointments`;


  private authorization = this.cookieService.get('Authorization');

  constructor(private httpClient: HttpClient, private cookieService: CookieService,private router: Router) {
  }

  public createAppointment(patientRegisterRequest: AppointmentRegistrationRequest): Observable<AppointmentRegistrationRequest> {
    const headers = {
      'Authorization': `${this.authorization}`
    };
    const dataUrl = this.serverUrl;
    return this.httpClient.post<AppointmentRegistrationRequest>(dataUrl, patientRegisterRequest, {headers})
      .pipe(catchError(this.handleError));
  }



  //const dataUrl = `${this.serverUrl}/listByAgent/${idAgent}`;
  //console.log(this.authorization);

  public getAllAppointments(): Observable<Appointment[]> {


    const dataUrl = this.serverUrl;
    const headers = {
      'Authorization': `${this.authorization}`
    };
    return this.httpClient.get<Appointment[]>(dataUrl, {headers}).pipe(catchError(this.handleError));
  }





  public getAppointments(id: number): Observable<Appointment> {
    const headers = {
      'Authorization': `${this.authorization}`
    };
    const dataUrl = `${this.serverUrl}/${id}`;
    return this.httpClient.get<Appointment>(dataUrl, {headers}).pipe(catchError(this.handleError));
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



  viewPatientDetails(id: number) {
    this.router.navigate(['/doctor-owner/patient-details', id]);
  }

  //a modifer encore
  public validateAppointment(id: number): Observable<{}> {

    const headers = {
      'Authorization': `${this.authorization}`
    };
    const dataUrl = `${this.serverUrl}/${id}`;
    return this.httpClient.put<{}>(dataUrl, {headers}).pipe(catchError(this.handleError));

  }




}
