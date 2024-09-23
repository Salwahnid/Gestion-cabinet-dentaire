import {PaymentAccount} from "./paymentAccount";
import {Secretary} from "./Secretary";


export interface SecretaryRegistrationRequest {
  secretaryRequest: Secretary;
  paymentAccountRequest: PaymentAccount;
}
