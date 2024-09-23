export interface DoctorOwner {
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
  specialization : string;
  roletype : string;
}
