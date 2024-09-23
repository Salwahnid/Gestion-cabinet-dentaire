import {Patient} from "./Patient";
import {PaymentAccount} from "./paymentAccount";


export interface PatientRegistrationRequest {
  patientRequest: Patient;
  paymentAccountRequest: PaymentAccount;
}
