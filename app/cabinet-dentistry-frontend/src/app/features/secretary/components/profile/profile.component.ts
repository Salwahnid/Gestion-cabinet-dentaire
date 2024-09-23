import { Component, OnInit } from '@angular/core';
import {DoctorOwner} from "../../../../shared/models/doctorowner";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  doctorOwner: DoctorOwner ;
  constructor() { }

  ngOnInit(): void {
    //this.agent = this.sharedAgentService.getAgent();

  }

}
