import { Component, OnInit } from '@angular/core';
import {Patient} from "../../../../shared/models/Patient";
import {ActivatedRoute} from "@angular/router";
import {PatientService} from "../../../../service/Patient.service";

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.scss']
})
export class PatientDetailsComponent implements OnInit {

  patient: Patient;

  constructor(private route: ActivatedRoute, private patientService: PatientService) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.patientService.getPatient(parseInt(id)).subscribe((patient) => {
      this.patient = patient;
    });
  }

}
