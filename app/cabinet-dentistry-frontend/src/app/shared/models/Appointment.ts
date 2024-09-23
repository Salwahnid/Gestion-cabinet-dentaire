import {Patient} from "./Patient";

export interface Appointment{
  id? : number;
  date: Date;
  time : string;
  treatment : string;
  dentNum : string[];
  medicament: string;
  status : string;
  patientId: number;
}
