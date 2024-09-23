package com.example.cabinetdentistrybackend.model;

import lombok.Data;
import lombok.Setter;

@Setter
@Data
public class SecretaryRegistrationRequest {
    private Secretary secretaryRequest;
    private PaymentAccountRequest paymentAccountRequest;

}
