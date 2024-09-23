package com.example.cabinetdentistrybackend.model;

import lombok.Data;
import lombok.Setter;

@Setter
@Data
public class PatientRegistrationRequest {
    private Patient patientRequest;
    private PaymentAccountRequest paymentAccountRequest;

}
