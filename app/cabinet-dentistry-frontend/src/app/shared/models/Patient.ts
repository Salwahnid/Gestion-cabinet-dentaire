import {Appointment} from "./Appointment";

export interface Patient {
  id? : number;
  firstname : string;
  lastname : string;
  username : string;
  email : string;
  cin : string;
  phoneNumber : string;
  birthdate : Date;
  password : string;
  firstLogin : boolean;
  roletype : string;
  appointments?: Appointment[];


}
