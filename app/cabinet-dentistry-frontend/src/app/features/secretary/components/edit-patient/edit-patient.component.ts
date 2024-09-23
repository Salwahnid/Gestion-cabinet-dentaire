import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Patient} from "../../../../shared/models/Patient";
import {PatientService} from "../../../../service/Patient.service";

@Component({
  selector: 'app-edit-patient',
  templateUrl: './edit-patient.component.html',
  styleUrls: ['./edit-patient.component.scss']
})
export class EditPatientComponent implements OnInit {


  public loading = false;
  public id: string | null = null;
  public patient: Patient = {} as Patient;

  constructor(private activatedRoute: ActivatedRoute, private patientService: PatientService, private router: Router) {

  }
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((param) => {
      this.id = param.get('id');
    });
    if (this.id) {
      this.loading = true;
      // tslint:disable-next-line:radix
      this.patientService.getPatient(parseInt(this.id)).subscribe((data) => {
        this.patient = data;
        this.loading = false;
      }, (error) => {
        console.log(error);
      });
    }
  }







}
