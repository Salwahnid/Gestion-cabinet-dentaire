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

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  patients: Patient[] = [];

  constructor(private patientService: PatientService,private router: Router,) { }

  ngOnInit(): void {
    this.patientService.getAllPatients().subscribe(data => {
      this.patients = data;
    }, error => {
      console.error('There was an error fetching patients!', error);
    });
  }

  addAppointment() {
    this.router.navigate(['secretary/add-appointment']);
  }

}
