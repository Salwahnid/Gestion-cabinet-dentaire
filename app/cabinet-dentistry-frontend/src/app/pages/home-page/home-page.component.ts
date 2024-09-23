import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  showLoginModal = false;
  showSignupModal = false;

  openLoginModal() {
    if(this.showSignupModal == true){
      this.closeSignupModal();
    }
    this.showLoginModal = true;
  }

  closeLoginModal() {
    this.showLoginModal = false;
  }
  openSignupModal() {
    if(this.showLoginModal == true){
      this.closeLoginModal();
    }
    this.showSignupModal = true;
  }

  closeSignupModal() {
    this.showSignupModal = false;
  }

}
