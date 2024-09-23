import { Component, OnInit } from '@angular/core';
import Chart from 'chart.js';

// core components
import {
  chartOptions,
  parseOptions,
  chartExample1,
  chartExample2
} from "../../../../variables/charts";
import {Patient} from "../../../../shared/models/Patient";
import {ActivatedRoute, Router} from "@angular/router";
import {SharedInfosService} from "../../../../service/shared-infos.service";
import {PatientService} from "../../../../service/Patient.service";
import {Observable} from "rxjs";
import {Appointment} from "../../../../shared/models/Appointment";
import {AppointmentService} from "../../../../service/Appointment.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {



  public appointments: Appointment[] = [];
  constructor(private router: Router, private appointmentService: AppointmentService,
              private sharedInfosService : SharedInfosService, private route: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.appointmentService.getAllAppointments().subscribe(
      (appointments: Appointment[]) => {
        this.appointments = appointments;
      },
      (error) => {
        console.error('Une erreur s\'est produite lors de la récupération des patients :', error);
      }
    );

  }




  getAllAppointments(): void {
    this.appointmentService.getAllAppointments().subscribe(
      (appointments: Appointment[]) => {
        this.appointments = appointments;
      },

      (error) => {
        console.error('Une erreur s\'est produite lors de la récupération des patients :', error);
      }
    );
  }

  validateAppointment(id: number) {
    console.log(id);
    this.appointmentService.validateAppointment(id).subscribe(
      () => {
        console.log('Patient deleted successfully.');
        this.getAllAppointments();
      },
      (error) => {
        console.error('An error occurred while deleting the client:', error);
      }
    );
    window.location.reload();
  }

}
