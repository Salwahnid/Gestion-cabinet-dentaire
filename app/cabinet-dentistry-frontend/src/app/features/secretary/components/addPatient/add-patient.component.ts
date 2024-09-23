import { Component, OnInit } from '@angular/core';

import {Router} from '@angular/router';
import {catchError, throwError} from 'rxjs';

import {ToastrService} from 'ngx-toastr';
import {PatientRegistrationRequest} from "../../../../shared/models/PatientRegistrationRequest";
import {Patient} from "../../../../shared/models/Patient";
import {PatientService} from "../../../../service/Patient.service";
import {SharedInfosService} from "../../../../service/shared-infos.service";
import {SecretaryRegistrationRequest} from "../../../../shared/models/SecretaryRegistrationRequest";
import {SecretaryService} from "../../../../service/Secretary.service";
import {CookieService} from "ngx-cookie-service";


@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.scss']
})
export class AddPatientComponent implements OnInit {

  public patientRegistrationRequest: PatientRegistrationRequest = {
    patientRequest: {
      firstname: '',
      lastname: '',
      username: '',
      email: '',
      cin: '',
      phoneNumber: '',
      birthdate: new Date(),
      password: '',
      firstLogin: false,
      roletype: "PATIENT",
    },
    paymentAccountRequest: {
      type: ''
    }
  };

  private authorization: string;

  constructor(
    private patientService: PatientService,
    private router: Router,
    private toastr: ToastrService,
    private cookieService: CookieService
  ) {
    this.authorization = this.cookieService.get('Authorization');
    console.log('Authorization token:', this.authorization);
  }
  async ngOnInit(): Promise<void> {

  }



  createSubmit() {
    console.log('Sending request:', this.patientRegistrationRequest);

    this.patientService.createPatient(this.patientRegistrationRequest)
      .subscribe((data: any) => {
          this.toastr.success('Secretary created successfully', 'Success');
          this.router.navigate([`/secretary/customer_history`]).then();
        },
        (error) => {
          this.toastr.error('Error creating patient', 'Error');
          setTimeout(() => {
            this.router.navigate([`/secretary/customer_history`]).then();
          }, 300); // Délai de 3 secondes avant la redirection
        });
  }

}
