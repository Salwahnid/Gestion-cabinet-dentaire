import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharedInfosService {

  private readonly phoneNumberKey = 'phoneNumber';

  constructor() { }

  setPhoneNumber(phoneNumber: string) {
    sessionStorage.setItem(this.phoneNumberKey, phoneNumber);
  }

  getPhoneNumber(): string | null {
    return sessionStorage.getItem(this.phoneNumberKey);
  }

  clearPhoneNumber() {
    sessionStorage.removeItem(this.phoneNumberKey);
  }
}
