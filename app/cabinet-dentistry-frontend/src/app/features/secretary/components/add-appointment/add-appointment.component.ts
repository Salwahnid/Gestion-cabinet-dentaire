import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {CookieService} from "ngx-cookie-service";

import {AppointmentRegistrationRequest} from "../../../../shared/models/AppointmentRegistrationRequest";
import {AppointmentService} from "../../../../service/Appointment.service";

@Component({
  selector: 'app-add-appointment',
  templateUrl: './add-appointment.component.html',
  styleUrls: ['./add-appointment.component.scss']
})
export class AddAppointmentComponent implements OnInit {


  public appointmentRegistrationRequest: AppointmentRegistrationRequest = {
    appointmentRequest: {
      date: new Date(),
      dentNum: [],
      medicament: '',
      status: '',
      time: '',
      treatment: '',
      patientId: null
    }
  };

  private authorization: string;


  constructor(
    private appointmentService: AppointmentService,
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
    console.log('Sending request:', this.appointmentRegistrationRequest);

    this.appointmentService.createAppointment(this.appointmentRegistrationRequest)
      .subscribe((data: any) => {
          this.toastr.success('Appointment created successfully', 'Success');
          this.router.navigate([`/secretary/dashboard`]).then();
        },
        (error) => {
          this.toastr.error('Error creating appointment', 'Error');
          setTimeout(() => {
            this.router.navigate([`/secretary/dashboard`]).then();
          }, 300); // Délai de 3 secondes avant la redirection
        });
  }


}
