package com.example.cabinetdentistrybackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PaymentMethodType type; // Exemple: "CreditCard", "BankTransfer", "Cash"

    public PaymentMethod() {
    }

    public PaymentMethod(PaymentMethodType type) {
        this.type = type;
    }

}
