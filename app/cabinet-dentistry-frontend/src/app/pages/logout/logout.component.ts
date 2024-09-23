import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../../service/Authentication.service";

@Component({
  selector: 'app-logout',
  template: ''
})
export class LogoutComponent implements OnInit {

  constructor(private authService: AuthenticationService) {
    this.authService.logout();
  }

  ngOnInit(): void {
  }

}
