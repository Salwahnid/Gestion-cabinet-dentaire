import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";
import { CookieService } from "ngx-cookie-service";
import { SecretaryService } from "../../../../service/Secretary.service";
import { SecretaryRegistrationRequest } from "../../../../shared/models/SecretaryRegistrationRequest";

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.scss']
})
export class StaffComponent implements OnInit {

  public secretaryRegistrationRequest: SecretaryRegistrationRequest = {
    secretaryRequest: {
      firstname: '',
      lastname: '',
      username: '',
      email: '',
      cin: '',
      phoneNumber: '',
      birthdate: new Date(),
      password: '',
      firstLogin: false,
      specialization: '',
      roletype: 'SECRETARY'
    },
    paymentAccountRequest: {
      type: '' // Initialisation de paymentAccountRequest avec une valeur par défaut
    }
  };

  private authorization: string;

  constructor(
    private secretaryService: SecretaryService,
    private router: Router,
    private toastr: ToastrService,
    private cookieService: CookieService
  ) {
    this.authorization = this.cookieService.get('Authorization');
    console.log('Authorization token:', this.authorization);
  }

  ngOnInit(): void {
    // Initialisations supplémentaires si nécessaire
  }

  createSubmit() {
    console.log('Sending request:', this.secretaryRegistrationRequest);

    this.secretaryService.createSecretary(this.secretaryRegistrationRequest)
      .subscribe((data: any) => {
          // Affiche un message de succès
          this.toastr.success('Secretary created successfully', 'Success');

          // Rafraîchir la page après un court délai
          setTimeout(() => {
            location.reload(); // Rafraîchit la page
          }, 2000); // Délai de 2 secondes avant le rafraîchissement

        },
        (error) => {
          this.toastr.error('Error creating secretary', 'Error');
          setTimeout(() => {
            location.reload(); // Rafraîchit la page en cas d'erreur
          }, 3000); // Délai de 3 secondes avant le rafraîchissement
        });
  }}
