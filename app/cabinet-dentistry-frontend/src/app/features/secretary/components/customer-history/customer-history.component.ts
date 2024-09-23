import {Component, OnInit} from '@angular/core';
import {DoctorOwner} from "../../../../shared/models/doctorowner";
import {ActivatedRoute, Router} from "@angular/router";
import {Patient} from "../../../../shared/models/Patient";
import {PatientService} from "../../../../service/Patient.service";
import {SharedInfosService} from "../../../../service/shared-infos.service";


@Component({
  selector: 'app-customer-history',
  templateUrl: './customer-history.component.html',
  styleUrls: ['./customer-history.component.scss']
})
export class CustomerHistoryComponent implements OnInit{

  patients: Patient[] = [];
  constructor(private router: Router, private patientService: PatientService,
              private sharedInfosService : SharedInfosService, private route: ActivatedRoute
  ) {
  }


  ngOnInit(): void {
    this.patientService.getAllPatients().subscribe(data => {
      this.patients = data;
    }, error => {
      console.error('There was an error fetching patients!', error);
    });
  }


  addPatient() {
    this.router.navigate(['secretary/add-patient']);
  }
/*
  // tslint:disable-next-line:max-line-length
  constructor(private router: Router, private clientService: ClientService, private doctorOwnerService: AgentService,
              private sharedInfosService : SharedInfosService, private route: ActivatedRoute
  ) {
  }


  async ngOnInit(): Promise<void> {
    try {
      const phoneNumber = this.sharedInfosService.getPhoneNumber();
      this.doctorOwner = await this.getAgentByPhone(phoneNumber);
      if (this.doctorOwner) {
        this.getAllClients(this.doctorOwner.id);
      }
    } catch (error) {
      console.error('Error retrieving doctorOwner:', error);
    }
  }


  async getAgentByPhone(phoneNum: string): Promise<DoctorOwner> {
    try {
      const doctorOwner = await this.doctorOwnerService.getAgentByPhoneNumber(phoneNum).toPromise();
      console.log(doctorOwner);
      return doctorOwner;
    } catch (error) {
      console.error('Error retrieving doctorOwner by phone number:', error);
      throw error;
    }
  }





  getAllClients(idAgent: number): void {
    this.clientService.getAllClientsByAgentId(idAgent).subscribe(
      (clients: Client[]) => {
        this.clients = clients;
      },

      (error) => {
        console.error('Une erreur s\'est produite lors de la récupération des clients :', error);
      }
    );
  }

  getAllClientByAgentId(idAgent: number): void {
    this.clientService.getAllClientsByAgentId(idAgent).subscribe(res => {
      this.clients = res;
    }, error => {
      console.log(error);
    });

  }


  deleteClient(id: number) {
    console.log(id);
    this.clientService.deleteClient(id).subscribe(
      () => {
        console.log('Client deleted successfully.');
        this.getAllClients(this.doctorOwner.id);
        this.getAllClientByAgentId(this.doctorOwner.id);
      },
      (error) => {
        console.error('An error occurred while deleting the client:', error);
      }
    );
    window.location.reload(); }
*/

}



