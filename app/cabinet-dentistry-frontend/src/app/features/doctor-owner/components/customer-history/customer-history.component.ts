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


  deletePatient(id: number) {
    console.log(id);
    this.patientService.deletePatient(id).subscribe(
      () => {
        console.log('Patient deleted successfully.');
        this.patientService.getAllPatients();
      },
      (error) => {
        console.error('An error occurred while deleting the client:', error);
      }
    );
    window.location.reload();
  }

  viewPatientDetails(id: number) {
    this.router.navigate(['/doctor-owner/patient-details', id]);
  }
  /*
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




  addClient() {
    this.router.navigate(['/add-client']);
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



