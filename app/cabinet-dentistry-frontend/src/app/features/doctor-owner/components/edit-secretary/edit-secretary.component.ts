import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {SecretaryService} from "../../../../service/Secretary.service";
import {Secretary} from "../../../../shared/models/Secretary";


@Component({
  selector: 'app-edit-secretary',
  templateUrl: './edit-secretary.component.html',
  styleUrls: ['./edit-secretary.component.scss']
})
export class EditSecretaryComponent implements OnInit {


  public loading = false;
  public id: string | null = null;
  public secretary: Secretary = {} as Secretary;

  constructor(private activatedRoute: ActivatedRoute, private secretaryService: SecretaryService, private router: Router) {

  }
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((param) => {
      this.id = param.get('id');
    });
    if (this.id) {
      this.loading = true;
      // tslint:disable-next-line:radix
      this.secretaryService.getSecretary(parseInt(this.id)).subscribe((data) => {
        this.secretary = data;
        this.loading = false;
      }, (error) => {
        console.log(error);
      });

    }
  }



}
